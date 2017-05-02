package Offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序， 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）,就是判断出栈顺序是不是正确
 * 思路:如何下一个弹出的数字刚好是栈顶数字，那么直接弹出，如果下一个弹出的数字不在栈顶，我们把压栈序列没有入栈的数字放入辅助站，知道把下一个需要弹出的数字压入栈顶位置。
 * 
 */
public class _16_IsPopOrder {
	public static boolean isPopOrder(int[] a, int[] b) {
		if (a == null || b == null || a.length == 0 || b.length == 0
				|| a.length != b.length)
			return false;
		Stack<Integer> tmp = new Stack<Integer>();
		int i = 0;
		int j = 0;
		tmp.push(a[i++]);
		//就是一个一个的比较，比较是否存在合理出栈的情况
		while (j <= b.length - 1) {
			while (b[j] != tmp.peek()) {
				if (i == a.length)
					return false;
				tmp.push(a[i++]);
			}
			j++;
			tmp.pop();
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b ={4,5,3,2,1};
		isPopOrder(a, b);
	}
}
