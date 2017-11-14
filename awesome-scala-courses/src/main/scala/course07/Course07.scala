package main.scala.course07

/**
  * 类和对象（二）
  * 单例对象
  * 伴生对象与伴生类
  * apply方法
  * 应用程序对象
  * 抽象类
  */
object Course07 {
    def main(args: Array[String]): Unit = {
        println(Student.uniqueStudentNo())
    }
}

object Student{
    private var studentNo:Int=0;
    def uniqueStudentNo()={
        studentNo+=1
        studentNo
    }
}
