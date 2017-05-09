package Offer;
/**
 * 给定一个数组和一个滑动窗口，求出在滑动窗口中的最大值
 * 例如:给定的数组为:{2,3,4,6,2,5,1} 滑动窗口的大小为 3 则各个滑动窗口中可能出现的值为:{2，3，4}，{3，4，6}，{4,6,2}，{6,2,5},{2,5,1}
 * 则输出的值为:4,6,6,6,5
 * 思路:首先定义一个在某数组中找到最大值的方法，然后再进行迭代比较
 * 注意:主要就是判断给定窗口的大小和数组的大小
 * Question:find the max number int a windows,
 * Example:Give you a array such as {2,3,4,6,2,5,1},the windows size is 3 ,So we can get the result 
 * {2，3，4}，{3，4，6}，{4,6,2}，{6,2,5},{2,5,1}
 * the result is :4,6,6,6,5
 * Thinking:First find the max in a array,then for the array find all max number,
 * Note:Judge the array size and give windows size;
 */
import java.util.ArrayList;
public class _32_MaxInWindows {
	public static ArrayList<Integer> maxInWindows(int[] num,int size){
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		if(num.length<size || size==0 || num == null || num.length<=0){
			return resultList;
		}
		else{
			for (int i = 0; i <= num.length-size; i++) {
				int[] tmp = new int[size];
				for (int j = i,k=0; j < tmp.length+i; j++,k++) {
					tmp[k] = num[j];
				}
				resultList.add(maxNumber(tmp));
			}
			return resultList;
		}
	}
	public static int maxNumber(int[] array){
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]>result){
				result = array[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] array = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> list = maxInWindows(array,3);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
