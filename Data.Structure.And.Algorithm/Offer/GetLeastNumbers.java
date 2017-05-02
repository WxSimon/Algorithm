package Offer;
/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思路:新建一个集合，存放目标数字，然后依次在数组中找到一个数字替换初始集合中的最大的数字，
 * 示例:先存放四个数字4 5 1 6 最大的为6 然后找到2发现小于6所以将2存入集合，继续，然后5是最大的 接着和7相比
 */
import java.util.ArrayList;

public class GetLeastNumbers {
	private static ArrayList<Integer> getLeasNumber(int[] array,int k){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array.length<k || k<=0)return list;
		for (int i = 0; i < k; i++) {
			list.add(array[i]);
		}
		for (int i = k; i < array.length; i++) {
			int j = getMax(list);
			int temp = list.get(j);
			if(temp>array[i]){
				list.set(i, array[i]);
			}
		}
		return list;
	}
	//找到集合中最大的一个数的位置
	private static int getMax(ArrayList<Integer> list){
		int max = list.get(0);
		int j = 0;
		for (int i = 0; i < list.size(); i++) {
			if(max<list.get(i)){
				max = list.get(i);
				j= i;
			}
		}
		return j;
	}
	public static void main(String[] args) {
		int[] array = new int[1000];
		for (int i = 0; i < 1000; i++) {
			array[i] = i;
		}
		getLeasNumber(array, 4);
	}
}
