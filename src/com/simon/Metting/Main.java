package com.simon.Metting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		dNA();
		findNumber();
	}

	/**
	 * 01: 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 例如：picture 和 turepic 就是属于同一种循环单词。
	 * 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
	 */
	public void stringFind() {
		/**
		 * 该解法思想就是，把每个单词所有可能的循环单词都放在一个数据结构中， 可以是List，map,set，数组等等，此处用ArrayList.
		 * 然后判断下一个单词是否在表中，不在则加入，并把循环种类加1 在的话，则它与之前的单词是同一种循环单词
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 第一行为单词个数n(1 ≤ n ≤ 50)
		ArrayList<String> list = new ArrayList<String>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			String s = sc.next(); // 输入并存储每行的单词。此处必须调用next（）方法，不能是nextLine（）方法
			if (!list.contains(s)) {
				count++;
				list.add(s);
				for (int j = 0; j < s.length() - 1; j++) {
					char last = s.charAt(s.length() - 1);
					s = s.substring(0, s.length() - 1);
					s = last + s;
					list.add(s);
					// 以下注释是另一种方法，把可能的循环单词加入list，
					// 思路：把要测试的单词后再重复下这个单词，如：picture ，变成 picturepicture
					// 感谢得闲半生的idea
					// StringBuffer string = new StringBuffer();
					// string.append(s);
					// string.append(s);
					// String another = string.substring(j, s.length() + j);
					// list.add(another);
				}
			}
		}
		sc.close();
		System.out.println(count);
	}

	/*
	 * 02 DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。
	 * 碱基互补配对原则：A和T是配对的，C和G是配对的
	 * 。如果两条碱基链长度是相同的并且每个位置的碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。
	 * 现在给出两条碱基链，允许在其中一条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功
	 */
	public static void dNA() {
		int n = 5;
		int count = 0;
		String s1 = null;
		String s2 = null;
		Scanner sc = new Scanner(System.in);
		s1 = sc.nextLine();
		s2 = sc.nextLine();

		sc.close();
		if (s1.length() == s2.length() && s1.length() != 0 && s2.length() != 0) {
			for (int i = 0; i < s1.length(); i++) {
				char a = s1.charAt(i);
				char b = s2.charAt(i);
				if (a == 'A' && b == 'T')
					count++;
				if (a == 'T' && b == 'A')
					count++;
				if (a == 'C' && b == 'G')
					count++;
				if (a == 'G' && b == 'C')
					count++;
			}
			System.out.println(count);
		}
	}

	// public static boolean isPair(char a, char b) {
	// if (a == 'A' && b == 'T')
	// return true;
	// if (a == 'T' && b == 'A')
	// return true;
	// if (a=='C' && b=='G')
	// return true;
	// if (a=='G' && b=='C')
	// return true;
	// return false;
	// }
	public static void findNumber() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> nList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			nList.add(sc.nextInt());
		}
		System.out.println("输入完毕...");
		sc.close();
		//排序
		Collections.sort(nList);
		for (int i = 0; i < nList.size(); i++) {
			if(i<nList.size()-1 &&(nList.get(i+1)-nList.get(i))!=1){
				System.out.println(nList.get(i));
			}
		}
	}
}