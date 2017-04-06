package com.simon.test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

import com.simon.Metting.Singleton;

public class TestClass {
	private static int x =100;
	// 单利模式实现
	public static void main(String[] args) {		
		// Singleton singleton_A = Singleton.Install_A();
		// Singleton singleton_B = Singleton.Install_B();
		// Singleton singleton_D = Singleton.Install_D();
		// singleton_D.ClassA();
		// 在三个线程下访问创建的单利模式
//		for (int i = 0; i < 3; i++) {
//			MultiSingleton();
//		}
		
		String s = "hello";
		String t = "hello";
		char c[] = {'h','e','l','l','o'};
		System.out.println(t.equals(c));
	}
	
	public static  void panduan(Boolean b){
		if(b)System.out.println("true");
		else{
			System.out.println("false");
			}
	}

	// 多线程下测试单利模式
	public static void MultiSingleton() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				Singleton sin = Singleton.Install_C();
				System.out.println(sin.hashCode());
			}
		});
		thread.start();
	}

	public boolean Find(int[][] array, int target) {
		int len = array.length - 1;
		int i = 0;
		while ((len >= 0) && (i < array[0].length)) {
			if (array[len][i] > target) {
				len--;
			} else if (array[len][i] < target) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}

}
