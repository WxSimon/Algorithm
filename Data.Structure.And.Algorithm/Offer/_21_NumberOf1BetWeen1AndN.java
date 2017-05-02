package Offer;
/**
 * 输入一个整数，求从1到n这n个整数的十进制表示中出现1的次数
 * 例如:输入整数为12 则出现1的次数为5 为:1 10 11 12 出现的1为5此
 * 思路:从n开始递减，然后查找每个数字中包含1的次数
 *
 */
public class _21_NumberOf1BetWeen1AndN {
	private static int numberOf1BetWeen1AndN(int n){
		int count = 0;
		while(n>0){
			String str = String.valueOf(n);
			char[] c = str.toCharArray();
			for (int i = 0; i < c.length; i++) {
				//是否包含1
				if(c[i]=='1'){
					count++;
				}
			}
			n--;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(numberOf1BetWeen1AndN(12));
	}
}
