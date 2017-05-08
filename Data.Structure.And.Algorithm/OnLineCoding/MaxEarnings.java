package OnLineCoding;
/**
 * 就是和最大和数组一样的，但是这个是进行了两次。
 * 采用动态规划的方法来思考这道题目
 */
public class MaxEarnings {
	public static int maxEarnings(int[] array){
		if(array.length<=0 || array == null)return 0;
		else{
			int[][] total = new int[array.length][array.length];
			int maxEa = 0;
			int j = 0;
			for (int i = 0; i < array.length; i++) {
				for (int k = i+1; k < array.length; k++) {
					total[i][k] = array[k]-array[i];
				}
			}
			return 0;
		}
	}
	public static void main(String[] args) {
		int[] array = {3,8,5,1,7,8};
	}
	public static int[] findMax(int[][] target){
		if(target.length <=0 || target== null)return null;
		int max = target[0][0];
		int[] lo = new int[3];
		for (int i = 0; i < target.length; i++) {
			for (int j = 0; j < target.length; j++) {
				if(target[i][j]>max){
					max = target[i][j];
					lo[0] = i;
					lo[1] = j;
					lo[2] = max;
				}
			}
		}
		return lo;
	}
}
