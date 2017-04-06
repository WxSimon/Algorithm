package com.simon.Metting;

import java.text.DecimalFormat;

/**
 * i++和++i的区别
 * 
 * @author Wang
 * 
 */
public class I_Add_Add_i {
	public static void main(String[] args) {
		int i=0;
		int j=0;
		//i++先赋值后加1
		System.out.println("i++:"+i+++" j:"+(i+j)); 	//0  1
		int i1=0;
		int j1=0;
		//++i先加一后赋值
		System.out.println("++i1:"+(++i1)+" j:"+(i1+j1)); //1 1
		System.out.println(test(8, 3));
	}
	public static String test(double d1,double d2){
        double result = d1/d2;
        String s=  String.format("%.3f", result);
        return s;
    }
}
