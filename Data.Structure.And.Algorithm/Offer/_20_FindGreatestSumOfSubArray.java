package Offer;
/**
 * 输入一个整型数组，数组中有正数有负数，找出这个数组中连续的一个或者多个数组，求所有数组的最大值
 * 例如:{1,-2,3,-4,5} 可能出现的数组有很多，找到和最大的一个数组
 * 思路:就是从第一个开始和后面相加，当时当加的数为负数的时候，就抛弃这个开头 例如: 1 + (-2) = -1 <0所以抛弃这个开头从第三个开始
 * 	   找到一直是增加的时候就退出
 * @author Wang
 *
 */
public class _20_FindGreatestSumOfSubArray {
	private static int findGreatestSumOfSubArray(int[] array){
		if(array.length<=0 || array == null)return 0;
		else{
			//最大数组的开始位置
			int total = array[0];
			//最大数组和的值
			int maxSum = array[0];
			for (int i = 1; i < array.length; i++) {
				if(total>=0){
					total+=array[i];
				}
				else total = array[i];
				if(total>maxSum){
					maxSum = total;
				}
			}
			return maxSum;
		}
	}
	public static void main(String[] args) {
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(findGreatestSumOfSubArray(array));
	}
}
