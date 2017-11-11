package course06

/**
  * 类和对象（一）
  * 1 类定义、创建对象
  * 2 主构造器
  * 3 辅助构造器
  */
object Course06 {
    def main(args: Array[String]): Unit = {

    }

}

class Course06 {
    //类成员必须初始化，否则会报错
    //这里定义的是一个公有成员
    var name: String = null
    /*
    二进制文件Person包含cn.scala.xtwy.Person
    Compiled from "Person.scala"
    public class cn.scala.xtwy.Person {
        private java.lang.String name;
        public java.lang.String name();
        public void name_$eq(java.lang.String);
        public cn.scala.xtwy.Person();
    }
    从字节码文件内容可以看到：虽然我们只在Person类中定义了一个类成员（域）name，
    类型为String，但Scala会默认帮我们生成name()与name_=（）及构造函数Person()。
    其中name()对应java中的getter方法，name_=()对应java中的setter方法（由于JVM中不允许出现=，所以用$eq代替。
    值得注意的是定义的是公有成员，但生成的字节码中却是以私有的方式实现的，生成的getter、setter方法是公有的
    因此，可以直接new操作创建Person对象*/
}
