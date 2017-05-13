package Offer;

/**
 * threshold :极限
 * 记录机器人行走的范围,因为对题目的理解出了问题，所以这个问题并不能解决
 * Date: 2017-05-12 21:48:19 找到自己的错误，没有将题目的问题思考清除，机器人当左右上下都不能走的时候，机器人就存在"死住"某点的情况，所以自己开始的思路出错
 * 
 * 
 * Recode rebot's way,but the problem is i do error in unstand the problem.So this problem cann't solve
 * Date: 2017-05-12 21:49:43 I know what i'm wrong in the day,i make mistake in the way of robat go,he can't go when it's 
 * 		 up,down,left,right all can't go,so i can't throug the commit
 * @author Wang
 * 
 */
public class _31_MovingCount {
	public static int movingCount(int threshold, int rows, int cols) {
		//使用一个boolean类型的数组，用来当前坐标是否可以走
		boolean[] visited = new boolean[rows*cols];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		
		int countGrid = movingCountCore(threshold,rows,cols,0,0,visited);
		
		return countGrid;

	}

	private static int movingCountCore(int threshold, int rows, int cols,
			int i, int j, boolean[] visited) {
		int count = 0;
		if(check(threshold,rows,cols,i,j,visited)){
			visited[i*cols+j] = true;
			count = 1+
					//上下左右判断机器人的行走是否可行
					movingCountCore(threshold, rows, cols, i-1, j, visited)+
					movingCountCore(threshold, rows, cols, i, j-1, visited)+
					movingCountCore(threshold, rows, cols, i+1, j, visited)+
					movingCountCore(threshold, rows, cols, i, j+1, visited);
		}
		return count;
	}

	private static boolean check(int threshold, int rows, int cols, int i,
			int j, boolean[] visited) {
		//我错误就错在没有一个存放当前坐标是否可以走的数组
		if(i>=0 && j>=0 && i<rows && j<cols && getDigitSum(i)+getDigitSum(j)<=threshold && !visited[i*cols+j]){
			return true;
		}
		return false;
	}
	
	//转换坐标值的位数
	private static int getDigitSum(int num){
		int sum = 0;
		while (num>0) {
			sum+=num%10;
			num/=10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(movingCount(15, 1, 100));
	}

	
	
//	//这是一个错误的思路，只考虑到了大小，而没有考虑到机器人行走的步伐
//	public static boolean getProduct(int rows, int cols, int threshold) {
//		if((getDigitSum(rows)+getDigitSum(cols))<=threshold){
//			return true;
//		}
//		else{
//			return false;
//		}
//	}
	
}
