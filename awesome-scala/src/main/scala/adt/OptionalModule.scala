package adt

object OptionalModule {

  sealed trait Optional[+T]{
    def get: T
    def isEmpty: Boolean
    def getOrElse[B >: T](default: B):B
    def map[R](f: T => R): Optional[R]
    def <%>[R](optFunc: Optional[T => R]): Optional[R]
    def flatMap[R](f: T => Optional[R]): Optional[R]
  }

  case class Just[T](value: T) extends Optional[T] {
    override def get: T = value

    override def isEmpty: Boolean = false

    override def getOrElse[B >: T](default: B): B = value

    override def map[R](f: (T) => R): Optional[R] = Just(f(value))

    override def <%>[R](optFunc: Optional[(T) => R]): Optional[R] = {
      if(optFunc.isEmpty) NotExist else Just(optFunc.get(value))
    }

    override def flatMap[R](f: (T) => Optional[R]): Optional[R] = {
      val optResult = f(value)
      if(optResult.isEmpty) NotExist else optResult
    }
  }

  case object NotExist extends Optional[Nothing] {
    override def get: Nothing = ???

    override def isEmpty: Boolean = true

    override def getOrElse[B >: Nothing](default: B): B = default

    override def map[R](f: (Nothing) => R): Optional[R] = NotExist

    override def <%>[R](optFunc: Optional[(Nothing) => R]): Optional[R] = NotExist

    override def flatMap[R](f: (Nothing) => Optional[R]): Optional[R] = NotExist
  }

}
