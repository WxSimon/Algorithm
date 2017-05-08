package Offer;
/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
 * 例如 数组: 1 2 4 7 11 15 ,15 则输出为:4,11
 * 思路:因为数组是递归的，所以可以从第一个加上最后一个  即 1 +15 =16>15 则end-1 继续相加，但是当1+11<15的时候，就需要将start+1
 * 
 */
import java.util.ArrayList;

public class _26_FindNumbersWithSum {
	private static ArrayList<Integer> findNumbersWithSum(int[] array,int sum){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array.length<=0 || array==null)return list;
		else{
			int start =0;
			int end = array.length-1;
			while(start<end){
				//首尾相加进行判断
				int total =  array[start]+array[end];
				if(total>sum){
					end--;
				}
				else if(total<sum){
					start++;
				}
				else {
					list.add(array[start]);
					list.add(array[end]);
					break;
				}
			}
			return list;
		}
	}
	
	public static void main(String[] args) {
		int[] array ={1,2,4,7,11,15};
		findNumbersWithSum(array, 15);
	}
}
