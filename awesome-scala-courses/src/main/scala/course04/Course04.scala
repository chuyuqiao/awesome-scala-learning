package main.scala.Course04

import scala.collection.mutable

/**
  * Set、Map、Tuple、队列操作实战
  * http://blog.csdn.net/lovehuangjiaju/article/details/46984575
  *
  * scala中的集合分为两种，一种是可变的集合，另一种是不可变的集合
  * 可变的集合可以更新或修改，添加、删除、修改元素将作用于原集合
  * 不可变集合一量被创建，便不能被改变，添加、删除、更新操作返回的是新的集合，老集合保持不变
  * scala.collection.immutable包中的集合绝对是不可变的，函数式编程语言推崇使用immutable集合
  * scala.collection.immutable包中的集合在是可变的，使用的时候必须明白集合何时发生变化
  */
object Course04 {

    def functionSet() = {
        //向集中添加一个元素，同前一讲中的列表和数组不一样的是
        //，Set在插入元素时并不保元素的顺序
        //默认情况下，Set的实现方式是HashSet实现方式，
        //集中的元素通过HashCode值进行组织
        val numSet=Set(3.0,5)
        numSet+6
        for(i <- numSet) println(i)

        val linkedHashSet=mutable.LinkedHashSet(3.0,5.0)
        linkedHashSet+6
        for(i <- linkedHashSet) println(i)

    }

    def show(x: Option[Int]) =x match{
        case Some(s) => s
        case None => "????"
    }

    def functionMap() = {
        val studentInfoMap=Map("John"->21,"stephen"->22)
        val studentInfoMutable=mutable.Map("John"->21,"stephen"->22)
        studentInfoMutable.clear()
        for( i <- studentInfoMap) println(i)

        studentInfoMap.foreach(e => {
            val (k,v)=e;print(k+""+v)
        })

        studentInfoMap.foreach(e => print(e._1+":"+e._2))

        val xMap=new mutable.HashMap[String,Int]()
        xMap.put("spark",1)
        xMap.contains("spark")

        val xMap2=mutable.Map(("spark",1),("java",2))

        "spark" -> 1

        xMap.get("spark")

        /*Option,None,Some类型
        Option、None、Some是scala中定义的类型，它们在scala语言中十分常用，因此这三个类型非学重要。
        None、Some是Option的子类，它主要解决值为null的问题，在java语言中，对于定义好的HashMap，
        如果get方法中传入的键不存在，方法会返回null，在编写代码的时候对于null的这种情况通常需要特殊处理，
        然而在实际中经常会忘记，因此它很容易引起 NullPointerException异常。在Scala语言中通过Option、None、
        Some这三个类来避免这样的问题，这样做有几个好处，首先是代码可读性更强，当看到Option时，
        我们自然而然就知道它的值是可选的，然后变量是Option，比如Option[String]的时候，
        直接使用String的话，编译直接通不过。*/

        xMap.get("java")

        show(xMap.get("spark"))

    }

    def functionTuple()={
        //元组的定义
        var tuple=("Hello","World",1)
        //访问元组内容
        tuple._1
        tuple._2
        tuple._3
        //通过模式匹配获取元组内容
        val (first,second,third)=tuple
        first
        second
        third
    }

    def functionQueue() = {
        var queue=scala.collection.immutable.Queue(1,2,3)
        //出队
        queue.dequeue
        //入队
        queue.enqueue(4)
        var muqueue=mutable.Queue(1,2,3,4,5)
        muqueue+=5
        muqueue++=List(6,7,8)

    }

    def functionStack(): Unit = {
        val stack=mutable.Stack(1,2,3)
        //出栈
        stack.top
        //入栈
        stack.push(1)
        //入栈
        stack.push(2)//Stack(2,1)
        //出栈
        stack.top

    }

    def main(args: Array[String]): Unit = {
        functionSet()
        functionMap()
        //元组
        functionTuple()
        //队列
        functionQueue()
        //栈
        functionStack()
    }


}
