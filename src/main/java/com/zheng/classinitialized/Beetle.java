package com.zheng.classinitialized;

public class Beetle extends Insect {
    
    protected int k = printInit("Beetle.k initialized");
    
    protected static int x2 = printInit("static Beetle.x2 initialized");
    
    public Beetle(){
    	System.out.println("子类构造函数执行 k="+k);
    }
    {
    	System.out.println("子类构造代码块执行");
    }
    
    public static void main(String[] args) {        
        Beetle b = new Beetle();
    } 
}

/*
 * 输出过程解析：类的加载过程为：
 * （1）、加载；
 * （2）、验证；
 * （3）、解析；
 * （4）、准备(static 变量赋初始值 0 null)；
 * （5）、初始化
 * 初始化阶段：由于调用了static main静态方法，所以会触发Beetle的初始化，Beetle的初始化之前会对其父类Insect进行初始化
 *  类Insect初始化过程：编译器会自动收集类中的所有静态变量（类变量）和静态语句块（static｛｝块）中的语句合并产生的，编译器收集的顺序是根据语句在java代码中的顺序决定的。
         收集完成之后，会编译成java类的 static{} 方法
  5.1、父类Insect生成的static{} 方法为
        static{
        System.out.println("hahaha");
        protected static int x1 = printInit("static Insect.x1 initialized");
        System.out.println("hehehe");
        }
 *5.2、子类生成的静态代码块
 *      static{
 *      protected int k = printInit("Beetle.k initialized");
 *      }
 *5.3、父类构造代码块执行
 *5.4、父类构造方法执行：Java收集我们的实例变量赋值语句，合并后在构造函数中执行赋值语句，没有构造函数的，系统会默认生成构造函数。
 *5.5、子类构造代码块执行  
 *5.6、 子类构造方法执行：Java收集我们的实例变量赋值语句，合并后在构造函数中执行赋值语句，没有构造函数的，系统会默认生成构造函数。   
 *
 * */

