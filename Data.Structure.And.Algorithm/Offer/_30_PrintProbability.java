package Offer;
/**
 * 求n个骰子出现各种值的概率
 * @author Wang
 *
 */
public class _30_PrintProbability {
	//骰子的大小
	static int DICE_VALUE = 6;
	
	public static void printProbability(int n){
		if(n<1)return;
		else{
			//最大可能出现的数
			int maxSum = n*DICE_VALUE;
			int minSum = n;
			//可能出现数的个数
			int totalNum = (maxSum-minSum+1);
			//定义一个数组用来保存所有出现的值
			int[] probabilityNum = new int[totalNum];
			
				probailiyu(n,probabilityNum);
				
				
				//求DICE_VALUE的n次方
				int total = (int) Math.pow(DICE_VALUE, n);
				
				//输出概率
				for (int j = n; j <= maxSum; j++) {
					double ratio = (double)probabilityNum[j-n]/total;
					System.out.println("数值"+j+"出现的概率为:"+ratio);
				}
		}
		
	}

	private static void probailiyu(int n, int[] probabilityNum) {
		for (int i = 1; i <= DICE_VALUE; i++) {
			probabilityNum(n,n,i,probabilityNum);
		}
	}

	//使用递归的操作进行各个值出现次数的相加
	private static void probabilityNum(int n, int n2, int i,
			int[] probabilityNum) {
			if(n2==1){
				probabilityNum[i-n]++;
			}
			else{
				for (int j = 1; j <= DICE_VALUE; j++) {
					probabilityNum(n, n2-1, j+i, probabilityNum);
				}
			}
	}
	
	public static void main(String[] args) {
		printProbability(6);
		
	}

}
