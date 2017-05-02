package Offer;
/**
 * 斐波拉契数列,实践复杂度为O(n)的解法
 * @author Wang
 *
 */
public class _07_Fibonacci {
	//实践复杂度为n的指数的解法
	private static int fib1(int i) {
		if(i<2){
			return i == 0 ? 0 : 1;
		}
		return fib1(i-1)+fib1(i-2);
	}
	
	//实践复杂度为n的解法
	//将前面已经计算的值保存起来，避免重复计算
	private static long fib2(int i){
		int[] result = {0,1};
		if(i<2)return result[i];
		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fib = 0;
		for (int j = 2; j <= i; ++j) {
			fib = fibNMinusOne+fibNMinusTwo;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fib;
		}
		return fib;
	}
	
	public static void main(String[] args) {
		System.out.println(fib2(3));
	}
}
