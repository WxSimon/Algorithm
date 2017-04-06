package com.simon.Metting;

/**
 * 初始化的过程
 * @author Wang
 *
 */
public  class Initialize {

//	public static void print(){
//	System.out.println("MTDP");
//	}
//
//	public static void main(String[] args) {
//		try {
//			((NULL) null).print();
//		} catch (NullPointerException e) {
//			System.out.println("NullPointerException");
//		}
//	}
	
	//抽象方法不能有方法体
//	public abstract void class2();
	
	
	
	/*
	 * 初始化过程： 
	1. 初始化父类中的静态成员变量和静态代码块 ； 
	2. 初始化子类中的静态成员变量和静态代码块 ； 
	3. 初始化父类的普通成员变量和代码块，再执行父类的构造方法；
	4. 初始化子类的普通成员变量和代码块，再执行子类的构造方法； 
	 
	（1）初始化父类的普通成员变量和代码块，执行  Y y=new Y();  输出Y 
	（2）再执行父类的构造方法；输出X
	（3） 初始化子类的普通成员变量和代码块，执行  Y y=new   Y();  输出Y 
	（4）再执行子类的构造方法；输出Z
	 所以输出YXYZ
	 */
	
	//验证构造函数
	public static void main(String[] args) {
		new Z();
	}
}
class Y{
	public Y(){
		System.out.println("Y");
	}
}
class X{
	Y y = new Y();
	public X(){
		System.out.println("X");
	}
}
class Z extends X{
	Y y = new Y();
	public Z(){
		System.out.println("Z");
	}
	
	
}
