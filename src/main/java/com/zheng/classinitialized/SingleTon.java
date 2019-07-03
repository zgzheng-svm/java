package com.zheng.classinitialized;
/**
 * 
 * @author Administrator
 * 虚拟机的类加载机制:虚拟机把Class文件加载到内存，然后进行校验，解析和初始化，最终形成java类型。
 * 
 * 加载:就是通过指定的类全限定名，获取此类的二进制字节流，然后将此二进制字节流转化为方法区的数据结构，在内存中生成一个代表这个类的Class对象。
 * 
 * 验证:是为了确保Class文件中的字节流符合虚拟机的要求，并且不会危害虚拟机的安全。
 * 
 * 解析:把类的全限定名，方法描述符等转化为jvm可以直接获取的jvm内存地址，指针等的过程.
 * 
 * 准备阶段：在java虚拟机加载class文件并且验证完毕之后，就会正式给类变量分配内存并设置类变量的初始值。
 * 这些变量所使用的内存都将在方法区分配。注意这里说的是类变量，也就是static修饰符修饰的变量，在此时已经开始做内存分配，同时也设置了初始值。
 * 
 * 初始化阶段：类初始化阶段是类加载过程的最后阶段。在这个阶段，java虚拟机才真正开始执行类定义中的java程序代码。Java虚拟机是怎么完成初始化的呢？这要从编译开始讲起。在编
         译的时候，编译器会自动收集类中的所有静态变量（类变量）和静态语句块（static｛｝块）中的语句合并产生的，编译器收集的顺序是根据语句在java代码中的顺序决定的。
         收集完成之后，会编译成java类的 static{} 方法。
       
        实例变量的赋值：1）当用new XXX() 创建对象的时候，首先在堆上为XXX对象分配足够的空间。
             2）这块存储空间会被清零，这就是自动将XXX对象中的所有基本类型的数据都设置成了默认值，而引用类型则被设置成了null（类似静态类的准备阶段的过程）
             3）Java收集我们的实例变量赋值语句，合并后在构造函数中执行赋值语句。没有构造函数的，系统会默认生成构造函数。
 */
public class SingleTon {
	
//	private static SingleTon singleTon = new SingleTon();
	public static int count1 ;
	public static int count2 = 0;
	
	private static SingleTon singleTon = new SingleTon();
	
	private SingleTon() {
		count1++;
		count2++;
	}

	public static SingleTon getInstance() {
		return singleTon;
	}
	public static void main(String[] args) {
		SingleTon singleTon = SingleTon.getInstance();
		System.out.println("count1 = "+ count1+"; count2 = "+count2);
		System.out.println(singleTon);
	}
}
