package reactiveComponent.framework

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait Flow[A, B] {
  def append[C](simpleTransformation: SimpleTransformation[B, C]): Flow[A, C]
  def runThrough(input: A):Future[B]
}

case class LastStep[A, B](simpleTransformation: SimpleTransformation[A, B]) extends Flow[A, B] {
  override def append[C](that: SimpleTransformation[B, C]): Flow[A, C] =
    CombinedSteps(simpleTransformation, LastStep(that))

  override def runThrough(input: A): Future[B] = simpleTransformation.update(input)
}

case class CombinedSteps[A, B, C](head: SimpleTransformation[A, B], tail: Flow[B, C]) extends Flow[A, C] {
  override def append[D](simpleTransformation: SimpleTransformation[C, D]): Flow[A, D] =
    CombinedSteps(head, tail.append(simpleTransformation))

  override def runThrough(input: A): Future[C] = {
    val b = head.update(input)
    b.flatMap(tail.runThrough)
  }//tail.runThrough(head.update(input))
}

object Flow {
  def connect[A, B, C](simpleTransformation: SimpleTransformation[A, B],
                       simpleTransformation1: SimpleTransformation[B, C]): Flow[A, C] = {
    CombinedSteps(simpleTransformation, LastStep(simpleTransformation1))
  }
}