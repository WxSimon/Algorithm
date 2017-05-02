package Offer;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 */
public class _08_NumberOf1 {
	public static int numberOf1(int n){
		int count =0;
		//将数值转换为二进制
		char[] ca = Integer.toBinaryString(n).toCharArray(); 
		System.out.println(ca);
		for (int i = 0; i < ca.length; i++) {
			if(ca[i]=='1'){
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(numberOf1(2));
	}
}
