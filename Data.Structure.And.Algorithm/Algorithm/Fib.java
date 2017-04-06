package Algorithm;

public class Fib {
	/**
	 * 斐波拉契数列（递归）
	 * 
	 * 
	 * 月份 ： 1  2  3  4  5  6  7  8  9   10  11  12  13  14
	 * 数量：  1  1  2  3  5  8  13 21 34  55  89  144 233 377
	 * 
	 *			0  			  (n=0) 
	 * f(n) ==  1  			  (n=1)
	 * 			f(n-1)+f(n-2) (n>=2)
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(fib1(14));
	}

	private static int fib1(int i) {
		if(i<2){
			return i == 0 ? 0 : 1;
		}
		return fib1(i-1)+fib1(i-2);
	}

}
