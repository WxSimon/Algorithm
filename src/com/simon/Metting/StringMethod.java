package com.simon.Metting;

import java.util.HashMap;
import java.util.ListIterator;

public class StringMethod {
	
//	StringBuffer  代码同步，线程安全，适用于多线程的操作
//	StringBuilder 代码不同步，线程不安全
//	String
	private static void testString() {
		String a = "abc";
		String b = new String("abc");
		if (a == b) {
			System.out.println("true");
		} else
			System.out.println("false");

		if (a.equals(b))
			System.out.println("true");
		else
			System.out.println("false");
	}

	/**
	 * HashMap使用hashCode和equals方法向集合添加和检索元素
	 * 调用put方法的时候，会计算key的hash值，当存在的时候就会改变key的value
	 */
	private static void testHashMap() {
		HashMap hashMap = new HashMap();
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		hashMap.put(a, b);
		hashMap.put(a, c);
		System.out.println("A:"+a.hashCode());
		System.out.println("B:"+b.hashCode());
		System.out.println("C:"+c.hashCode());
		System.out.println("D:"+d.hashCode());
		System.out.println("E:"+e.hashCode());
		System.out.println("Save In hashMap A is:"+hashMap.get(a));
	}

	private static void testFinally(int n){
		try {
			if (1/n>0)
				System.out.println("Code Try");
		} catch (Exception e) {
			System.out.println("Code Exception");
		} finally {
			System.out.println("Code finally");
		}
	}
	
	public static void main(String[] args) {
//		testString();
//		testHashMap();
		
		int n=0;
		try {
			testFinally(n);
		} catch (Exception e) {
			System.out.println("Code Main Exception");
		}finally{
			System.out.println("Code Main Finally");
		}
	}
}
