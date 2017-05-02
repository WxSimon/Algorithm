package Offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。 求base的exponent次方
 * 思路:就是判断需要被乘积的数是是否为0的情况
 */
public class _22_Power {
	public static void main(String[] args) {
		System.out.println("乘积的值为:" + power(0, -2));
	}

	private static double power(double base, int exponent) {
		double result = 1;
		if (base == 0)
			return 0;
		else {
			// 指数大于 0的情况
			if (exponent < 0) {
				for (int i = 0; i < Math.abs(exponent); i++) {
					result *= base;
				}
				result = 1 / result;
			}
			// 指数小于0的情况
			else if (exponent > 0) {
				for (int i = 0; i < exponent; i++) {
					result *= base;
				}
			}
			return result;
		}
	}
}
