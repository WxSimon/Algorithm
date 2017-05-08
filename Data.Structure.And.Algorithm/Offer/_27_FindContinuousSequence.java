package Offer;
/**
 * 输入一个整数，求出和为这个整数的连续整数 ,序列至少含有两个整数
 * 例如: 15  存在和为15的连续序列为:1+2+3+4+5  4+5+6 7+8 
 * 思路: 假设第一个数为 start:1 第二个数为 end:2 那么1+2<15 则将将end+1 扩大整数范围
 * 		1+2+3<15 继续增大范围 1+2+3+4<15 继续 1+2+3+4+5==15 满足条件算一个
 * 		继续增加范围1+2+3+4+5+6>15 然后增大start 的大小 2+3+4+5+6>16 继续
 * 		3+4+5+6>15 继续 4+5+6=15 增大end的范围 4+5+6+7>15 增大start的大小
 * 		5+6+7>17 继续 6+7<15 则增大end的范围 6+7+8>15 增大start的范围 7+8=15保存,判断结束
 */
import java.util.ArrayList;

public class _27_FindContinuousSequence {
	public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		if(sum<3)return resultList;
		else{
			int start = 1;
			int end = 2;
			int total = (sum+1)/2;//根据序列最少存在两个整数，那么最大值就必须小于或等于该数的一半
			int count = start +end;
			while(start<total){
				if(count == sum){
					addToResult(resultList, start, end);
				}
				while(count>sum && start<total){
					//超出的时候就增大前面的数
 					count-=start;
					start++;
					if(count==sum){
						addToResult(resultList, start, end);
					}
				}
				//扩大整数的范围
				end++;
				count+=end;
			}
			return resultList;
		}
	}
	
	public static void main(String[] args) {
		findContinuousSequence(15);
	}

	private static void addToResult(ArrayList<ArrayList<Integer>> resultList,
			int start, int end) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = start; i <=end; i++) {
			list.add(i);
		}
		resultList.add(list);
	}
}	
