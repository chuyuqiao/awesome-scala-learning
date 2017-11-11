package course06

import scala.beans.BeanProperty

/**
  * 类和对象（一）
  * 1 类定义、创建对象
  * 2 主构造器
  * 3 辅助构造器
  *
  * http://blog.csdn.net/lovehuangjiaju/article/details/47009607
  *
  */
object Course06 {
    def main(args: Array[String]): Unit = {
        val p=new Person()
        p.name_=("john")
        println(p.name)
        p.name="jack"
        println(p.name)
        p.name="jack"
        println(p.name)
    }

}

//采用关键字class定义
class Person {
    //类成员必须初始化，否则会报错
    //这里定义的是一个公有成员
//    var name:String=null

    private var privateName:String=null

    def name=privateName

    def name_=(pname:String){
        this.privateName=pname
    }

    //类成员必须初始化，否则会报错
    //这里定义的是一个val公有成员
    val address:String=null

    private[this] var phoneNumber:String=null

    @BeanProperty var gender:Int=0

}
/*二进制文件Person
public class course06.Person {
private java.lang.String name;
public java.lang.String name();
public void name_$eq(java.lang.String);
public course06.Person();
}
从字节码文件内容可以看到：虽然我们只在Person类中定义了一个类成员（域）name，
类型为String，但Scala会默认帮我们生成name()与name_=（）及构造函数Person()。
其中name()对应java中的getter方法，name_=()对应java中的setter方法（由于JVM中不允许出现=，所以用$eq代替。
值得注意的是定义的是公有成员，但生成的字节码中却是以私有的方式实现的，生成的getter、setter方法是公有的
因此，可以直接new操作创建Person对象*/

/*
Compiled from "Course06.scala"
public class course06.Person {
  private java.lang.String privateName;
  private java.lang.String privateName();
  private void privateName_$eq(java.lang.String);
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public course06.Person();
}
*/
/*从生成的字节码中可以看出：（1）定义成私有成员，其getter、setter方法也是私有的；（2）直接能访问的是我们自己定义的getter、setter方法
* 从代码执行产生的结果，我们可以知道：通过p.name=“john”这种方式进行赋值，调用者并不需要知道是其通过方法调用还是字段访问来进行操作的，
* 这便是著名的统一访问原则*/

/*public class course06.Person {
    private java.lang.String privateName;
    private final java.lang.String address;
    private java.lang.String privateName();
    private void privateName_$eq(java.lang.String);
    public java.lang.String name();
    public void name_$eq(java.lang.String);
    public java.lang.String address();
    public course06.Person();
}*/
//如果类的成员域是val类型的变量，则只会生成getter方法

/*Compiled from "Course06.scala"
public class course06.Person {
    private java.lang.String privateName;
    private final java.lang.String address;
    private java.lang.String phoneNumber;
    private java.lang.String privateName();
    private void privateName_$eq(java.lang.String);
    public java.lang.String name();
    public void name_$eq(java.lang.String);
    public java.lang.String address();
    public course06.Person();
}*/
//如果将成员域定义为private[this]，则不会生成getter、setter方法
/*Compiled from "Course06.scala"
public class course06.Person {
    private java.lang.String privateName;
    private final java.lang.String address;
    private java.lang.String phoneNumber;
    private int gender;
    private java.lang.String privateName();
    private void privateName_$eq(java.lang.String);
    public java.lang.String name();
    public void name_$eq(java.lang.String);
    public java.lang.String address();
    public int gender();
    public void gender_$eq(int);
    public int getGender();
    public void setGender(int);
    public course06.Person();
}*/
/*在java语言当中，在定义JavaBean的时候生成的都是setXxx()、getXxx()方法，
但scala语言生成的getter方法和setter方法并不是这样的，如果也需要程序自动会生成getter方法和setter方法，
则需要引入 scala.reflect.BeanProperty 然后采用注解的方式修饰变量*/



