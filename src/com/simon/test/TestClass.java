package com.simon.test;

import java.util.Stack;

import com.simon.Metting.Singleton;

public class TestClass {
	
	
	//单利模式实现
	public static void main(String[] args) {
//		Singleton singleton_A = Singleton.Install_A();
//		Singleton singleton_B = Singleton.Install_B();
//		Singleton singleton_D = Singleton.Install_D();
//		singleton_D.ClassA();
		//在三个线程下访问创建的单利模式
		for (int i = 0; i < 3; i++) {
			MultiSingleton();
		}

	}
	//多线程下测试单利模式
	public static void MultiSingleton(){
		Thread thread = new Thread(new Runnable() {
			public void run() {
				Singleton sin = Singleton.Install_C();
				System.out.println(sin.hashCode());
			}
		});
		thread.start();
	}
	
}
