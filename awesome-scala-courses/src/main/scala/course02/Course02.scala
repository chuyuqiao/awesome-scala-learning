package main.scala.course02

import java.io.File

/**
  * Scala基本类型及操作、程序控制结构
  * http://blog.csdn.net/lovehuangjiaju/article/details/46953423
  */
object Course02 {

    def main(args: Array[String]): Unit = {
        var x=if("hello" == "hell") 1 else 0
        println(x)
        println(gcdLoop(2, 11))
        println(gcd(2, 11))
        dirFiles()
    }

    /**
      * 与if不同的是，while与do while不能用作表达式，也即其返回值为Unit，在某些函数式编程语言中，
      * 删除了while与do while程序控制结构，但scala仍然保留了while与do while，
      * 可见Scala并不是纯函数式编程语言（另外一个重要原因是，scala函数定义时仍然可以用var指定参数）。
      * @param x
      * @param y
      * @return
      */
    def gcdLoop(x: Long, y: Long) = {
        var a=x
        var b=y
        while(a!=0){
            val temp=a
            a=b%a
            b=temp
        }
        b
    }

    def gcd(x:Long,y:Long):Long =
    if(y == 0) x else gcd(y,y%x)

    def dirFiles()={
        val filesHere=(new File(".")).listFiles()
        for(file <- filesHere if file.getName.endsWith(".scala"))
            println(file)
        for(file <- filesHere if file.isFile;if file.getName.endsWith(".scala"))
            println(file)
    }

}
