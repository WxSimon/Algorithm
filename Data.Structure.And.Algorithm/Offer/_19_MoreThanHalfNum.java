package Offer;

import java.util.HashMap;
import java.util.Map;

/**数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 思路:就是使用一个map类型，用来保存当前的值和出现的次数
 */
public class _19_MoreThanHalfNum {
	public static int moreThanHalfNum(int[] array){
		if(array==null && array.length==0)return 0;
		int result = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i])+1);
			}else{
				map.put(array[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()>=(array.length/2)){
				result = entry.getKey();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,2,2,2,5,4,2};
		System.out.println(moreThanHalfNum(array));
	}
}
