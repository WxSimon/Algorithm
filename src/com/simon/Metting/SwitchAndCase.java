package com.simon.Metting;

/**
 * switch和case的研究
 * @author Wang
 *
 */
public class SwitchAndCase {
	
	
	/**
	 * Demo01:无其他情况
	 */
	public static void switchAndCaseDemo01(int x){
		switch (x) {
		case 1:
			System.out.println("Case1");
			break;
		case 2:
			System.out.println("Case2");
			break;
		case 3:
			System.out.println("Case3");
			break;
		default:
			System.out.println("default");
			break;
		}
	}
	/**
	 * Demo02:没有break的情况
	 */
	public static void switchAndCaseDemo02(int x){
		switch (x) {
		case 1:
			System.out.println("Case1");
		case 2:
			System.out.println("Case2");
		case 3:
			System.out.println("Case3");
		default:
			System.out.println("default");
		}
	}
	
	   public static int switchit(int x) {
	        int j=1;
	        switch (x) {
	        case 1:j++;
	        case 2:j++;
	        case 3:j++;
	        case 4:j++;
	        case 5:j++;
	        default:j++;
	        }
	        return j+x;
	    }
	
	public static void main(String[] args) {
//		switchAndCaseDemo01(1);	//System.out.print("Case1")
		//不带break的情况
//		switchAndCaseDemo02(2);	//System.out.print("Case2,Case3,default")
		System.out.println("Value:"+switchit(4)); 	// 8
		
		
	}
}
