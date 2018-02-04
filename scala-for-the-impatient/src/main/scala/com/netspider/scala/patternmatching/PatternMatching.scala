package scala.com.netspider.scala.patternmatching

object PatternMatching extends App {
  private def matchChar = {
    val ch: Char = '9'
    val sign = ch match {
      case '+' => 1
      case '-' => -1
      case ch if Character.isDigit(ch) => Character.digit(ch, 10)
      case _ => 0
    }
    sign
  }

  private def matchObject = {
    val obj: Any = "100"
    val objValue = obj match {
      case x: Int => x
      case s: String => Integer.parseInt(s)
      case _: BigInt => Int.MaxValue
      case _ => 0
    }
    objValue
  }

  private def matchArr = {
    val arr = Array(0)
    val arrString = arr match {
      case Array(0) => "0"
      case Array(x, y) => x + "" + y
      case Array(0, _*) => "0 ..."
      case _ => "something else"
    }
    arrString
  }

  private def matchList = {
    val lst = List(0)
    val lstString = lst match {
      case 0 :: Nil => "0"
      case x :: y :: Nil => x + "" + y
      case 0 :: tail => "0 ..."
      case _ => "something else"
    }
    lstString
  }

  private def matchTuple2 = {
    val tuple2 = Tuple2(0, 1)
    val tuple2String = tuple2 match {
      case (0, _) => "0 ..."
      case (y, 0) => y + " 0"
      case _ => "neither is 0"
    }
    tuple2String
  }

  println(matchChar)
  println(matchObject)
  println(matchArr)
  println(matchList)
  println(matchTuple2)

}
