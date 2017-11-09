package main.scala.course03

import scala.collection.mutable.ArrayBuffer

/**
  * Array、List
  * http://blog.csdn.net/lovehuangjiaju/article/details/46963721
  */
object Course03 {
    /**
      * 复杂对象类型在数组定义时被初始化为null，数值型被初始化为0
      */
    def functionArray() = {
        val numberArray=new Array[Int](10)
        println(numberArray)
        val strArray=new Array[String](10)
        strArray(0)="First Element"
        println(strArray)
        val strArray2=Array("First","Second")
        println(strArray2)
        strArray2.toBuffer

        val strArrayVar=ArrayBuffer[String]()
        //+=后面还可以跟多个元素的集合
        strArrayVar+="Hello"
        strArrayVar+=("World","Programmer")
        //++=用于向数组中追加内容，++=右侧可以是任何集合
        strArrayVar++=Array("Welcome","To","Scala")
        strArrayVar++=List("Welcome","To","Scala")
        strArrayVar.trimEnd(3)
        var intArrayVar=ArrayBuffer(1,1,2)
        intArrayVar.insert(0,6)
        intArrayVar.insert(0,7,8,9)
        intArrayVar.remove(0,4)
        intArrayVar.toArray
        for(i <- 0 to intArrayVar.length-1) println(i)
        for(i <- 0 until intArrayVar.length) println(i)
        for(i <- intArrayVar) println(i)
        for(i <- 0 until (intArrayVar.length,2)) println(i)
        for(i <- (0 until intArrayVar.length).reverse) println(i)
        var intArrayVar2=for(i <- intArrayVar) yield i*2
        //定长数组转换后产生的仍然是定长数组，原数组不变
        var intArrayNoBuffer=Array(1,2,3)
        var intArrayNoBuffer2=for(i <- intArrayNoBuffer) yield i*2

        //加入过滤条件
        var intArrayNoBuffer3=for(i <- intArrayNoBuffer if i> 2) yield i*2

        val intArr=Array(1,2,3,4,5,6,7,8,9,10)
        intArr.sum
        intArr.max
        var strArrBuffer=ArrayBuffer("Hello","Hel")
        strArrBuffer.max
        intArr.min
        intArr.toString()
        intArr.mkString(",")
        intArr.mkString("<",",",">")

        var multiDimArr=Array(Array(1,2,3),Array(4,5,6))
        multiDimArr(0)(2)
        for(i <- multiDimArr) println(i.mkString(","))
        println(strArrayVar)

    }

    def insert(x: Int, xs: List[Int]):List[Int]={
        if(xs.isEmpty || x <= xs.head) x::xs
        else xs.head :: insert(x,xs.tail)
    }

    def isort(xs: List[Int]):List[Int]={
        if(xs.isEmpty) Nil
        else insert(xs.head,isort(xs.tail))
    }

    /**
      * 1 List一但创建，其值不能被改变
      * 2 List具有递归结构（Recursive Structure),例如链表结构
      */
    def functionList() = {
        val fruit=List("Apple","Banana","Orange")
        val fruit2=List.apply("Apple","Banana","Orange")
        val nums=List(1,2,3,4,5,6,7)
        val diagMatrix=List(List(1,0,0),List(0,1,0),List(0,0,1))
        for(i <- diagMatrix) println(i)
        var listStr:List[Object]=List("This","Is","Covariant","Example")

        val nums2=1::(2::(3::(4::Nil)))
        val num3=1::2::3::4::Nil

        nums.isEmpty
        nums.head
        nums.tail
        nums.tail.head
        isort(nums)
        List(1,2,3):::List(4,5,6)
        nums.init
        nums.last
        nums.reverse
        nums.reverse.reverse
        nums.reverse.init
        nums.tail.reverse
        nums drop 3
        nums drop 1
        nums take 1
        nums.take(3)
        nums.splitAt(2)
        (nums.take(2),nums.drop(2))
        val chars=List("1","2","3","4")
        nums zip chars
        nums.toString
        nums.mkString
        nums.toArray

        List.apply(1,2,3)
        List.range(2,6)
        List.range(2,6,2)
        List.range(2,6,-1)
        List.range(6,2,-1)


    }

    def main(args: Array[String]): Unit = {
        functionArray()
        functionList()
    }

}
