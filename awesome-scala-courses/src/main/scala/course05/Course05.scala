package course05

/**
  * 函数与闭包
  * 1.函数字面量（值函数）
  * 2.匿名函数
  * 3.函数的简化
  * 4.函数参数
  * 5.闭包
  * http://blog.csdn.net/lovehuangjiaju/article/details/46992275
  */
object Course05 {

    /**
      * 函数字面量（值函数）
      */
    def functionLiteral(): Unit = {
        val increase = (x: Int) => x + 1
        println(increase(10))

        def increaseAnother(x: Int) = x + 1

        println(increaseAnother(10))
        val increase2 = (x: Int) => {
            println("Xue")
            println("Xi")
            x + 1
        }
        println(increase2(10))
        println(Array(1, 2, 3, 4).map(increase).mkString(","))
    }

    /**
      * 匿名函数
      */
    def functionAnonymous(): Unit = {
        println(Array(1, 2, 3, 4).map((x: Int) => x + 1).mkString(","))
        println(Array(1, 2, 3, 4).map { (x: Int) => x + 1 }.mkString(","))
        println(Array(1, 2, 3, 4) map { (x: Int) => x + 1 } mkString (","))
        println(Array(1, 2, 3, 4) map { (x) => x + 1 } mkString (","))
        println(Array(1, 2, 3, 4) map { x => x + 1 } mkString (","))
        println(Array(1, 2, 3, 4) map {
            _ + 1
        } mkString (","))
        val fun1 = 1 + (_: Double)
        println(fun1(999))
        val fun2: (Double) => Double = 1 + _
        println(fun2(200))
    }

    /**
      * 函数参数
      */
    def functionParameter(): Unit = {
        //函数参数(高阶函数）
        //((Int)=>String)=>String
        def convertTntToString(f: (Int) => String) = f(4)

        println(convertTntToString((x: Int) => x + " s"))

        //高阶函数可以产生新的函数
        //(Double)=>((Double)=>Double)
        def multiplyBy(factor: Double) = (x: Double) => factor * x

        val x = multiplyBy(10)
        println(x(50))
    }


    def functionClosure(): Unit = {
        //像这种运行时确定more类型及值的函数称为闭包,more是个自由变量，在运行时其值和类型得以确定
        //这是一个由开放(free)到封闭的过程，因此称为闭包
        var more = 1
        val fun = (x: Int) => x + more
        println(fun(10))

        val someNumbers = List(-11, -10, -5, 0, 5, 10)
        var sum = 0
        someNumbers.foreach(sum += _)
        println(sum)

    }

    def main(args: Array[String]): Unit = {
        functionLiteral()
        functionAnonymous()
        functionParameter()
        functionClosure()
    }
}
