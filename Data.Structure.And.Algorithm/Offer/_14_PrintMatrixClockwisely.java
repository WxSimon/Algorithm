package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1  2  3  4 
 * 				  5  6  7  8 
 * 				  9  10 11  12 
 * 				  13 14 15 16 
 * 1->2->3->4->8->12->16->15->14->13->9->5->6->7->11->10
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 */
public class _14_PrintMatrixClockwisely {
	private static List<Integer> printMatrixClockwisely(int[][] a){
		List<Integer> result = new ArrayList<Integer>();
		int col =a[0].length;
		int row =a.length;
		if(a==null || row ==0 || col ==0)return null;
		int start =0;
		//根据规律得到的判断条件
		while(row>2*start && col >2*start){
			printNumber(a,col,row,start,result);
			start++;
		}
		return result;
	}

	private static void printNumber(int[][] a, int col, int row, int start,List result) {
		int endX = col -1 - start;
		int endY = row -1 -start;
		//从左到右打印
		 for (int i = start; i <=endX; i++) {
			 result.add(a[start][i]);
			System.out.print(a[start][i]);
		}
		 //从上到下打印
		if(start<endY){
			for (int i = start+1; i <= endY; i++) {
				result.add(a[i][endX]);
				System.out.print(a[i][endX]);
			}
		}
		//从右到左打印
		if(start<endX && start<endY){
			for (int i = endX-1; i >= start; i--) {
				result.add(a[endY][i]);
				System.out.print(a[endY][i]);
			}
		}
		//从下到上打印
		if(start<endX && start<endY-1){
			for (int i = endY-1; i >= start+1; i--) {
				result.add(a[i][start]);
				System.out.print(a[i][start]);
			}
		}
	}
	public static void main(String[] args) {
		int a[][] = new int[4][4];
		a[0][0] =1;
		a[0][1] =2;
		a[0][2] =3;
		a[0][3] =4;
		a[1][0] =5;
		a[1][1] =6;
		a[1][2] =7;
		a[1][3] =8;
		a[2][0] =9;
		a[2][1] =10;
		a[2][2] =11;
		a[2][3] =12;
		a[3][0] =13;
		a[3][1] =14;
		a[3][2] =15;
		a[3][3] =16;
		printMatrixClockwisely(a);
	}
}
