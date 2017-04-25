package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序， 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。 
 * 示例: 1 2 3 4 5 调整后为: 1 3 5 2 4
 * 思路:将奇数和偶数使用两个list存起来，然后再进行拼接
 * 
 */
public class Reorder {
	private static int[] reoder(int[] array) {
		if (array.length == 0)
			return null;
		else {
			int[] a = new int[array.length];
			List<Integer> list1 = new ArrayList<Integer>();
			List<Integer> list2 = new ArrayList<Integer>();
			for (int i = 0; i < array.length; i++) {
				// 偶数
				if (array[i] % 2 == 0) {
					list2.add(array[i]);
				}
				// 奇数
				else {
					list1.add(array[i]);
				}
			}
			for (int i = 0; i < list1.size(); i++) {
				a[i] = list1.get(i);
			}
			for (int i = 0; i < list2.size(); i++) {
				a[list1.size() + i] = list2.get(i);
			}
			return a;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = reoder(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(b[i]);
		}
	}
}
