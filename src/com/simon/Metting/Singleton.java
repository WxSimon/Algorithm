package com.simon.Metting;
/**
 * @author Wang
 *	单利模式实现的几种方式(对象只能被创建一次)
 */
public class Singleton {
/**
 * 方式一
 * 通过构造函数的私有来实现单利模式
 * 单线程下运行没有问题，但是多线程下操作就会有问题
 */
	private Singleton(){
	}
	private static Singleton install = null;
	public static Singleton Install_A (){
		if (install ==null){
			return new Singleton();
		}
		else return install;
	}
	
	/**
	 * 方式二
	 * 通过添加进程锁的方式来防止多进程访问时多创建的问题
	 * 但是回面临重复上锁解锁的过程
	 */
	public static synchronized Singleton Install_B(){
		if (install ==null){
			System.out.println("我被上锁了。。。");
			return new Singleton();
		}
		else return install;
	}
	
	/**
	 *方式三：
	 *通过先判断是否为空之后再进行上锁 
	 */
	public static  Singleton Install_C(){
		if (install ==null){
			synchronized (Singleton.class) {
				if(install == null){
					install = new Singleton();
					System.out.println("我被上锁了。。。");
				}
			}
			return new Singleton();
		}
		else return install;
	}
	/**
	 * 方式四：
	 * 通过静态类部类的方式
	 */
	private static class install_Class_D { 
		private static Singleton Install = new Singleton();
			
	}
	public static Singleton Install_D (){
			return install_Class_D.Install;
	}
	
	
	public void ClassA(){
		System.out.println("Singleton.ClassA()"); 
	}
	
}
