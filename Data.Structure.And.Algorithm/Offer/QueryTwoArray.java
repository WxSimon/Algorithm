package Offer;
/**
 * 在一组二维有序数组中查找到目标值:
 * 1 2 3 4
 * 2 3 4 5
 * 3 5 7 8
 * 4 6 8 9
 * 有序数组定义:从左到右数值依次增加，从上到下数值依次增加
 * 思路:由于数组是有序的，所以可以先从最大的一行的第一个入手
 * 假设查找的数值为：5
 * array[3][0] = 4>5 所以判断失败接着判断array[3][0] = 4<5 判断成功 则i+1 = 1;接着判断
 * array[3][1] = 6>5 所以结束判断，len-1 = 2;接着判断
 * array[2][1] = 5 =5 返回true
 * 
 * @author Wang
 *
 */
public class QueryTwoArray {
	//保存找到的位置信息
	static int[] loca = new int[2];
	
	/**
	 * 这个方法是从左下角开始查找
	 * @param array
	 * @param target
	 * @return
	 */
	public static boolean findTarget(int[][] array,int target){
		int len = array.length;
		System.out.println("二维数组的长度为:"+len);
		int i=0;
		while(i<array[0].length  && len>=0){
			if(array[len-1][i]>target){
				len--;
			}else if(array[len-1][i]<target){
				i++;
			}else{
				loca[0] = len;
				loca[1] = i+1;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 这个方法是从右上角开始查找
	 * @param array
	 * @param target
	 * @return
	 */
	public static boolean findTarget_01(int[][] array,int target){
		int len = array.length;
		int wid = array[0].length;
		System.out.println("数组长度为:"+len);
		int i=0;
		while(i<array.length && len>=0){
			if(array[i][wid-1]>target){
				wid--;
			}
			else if(array[i][wid-1]<target){
				i++;
			}
			else{
				loca[0] = i+1;
				loca[1] = wid;
				return true;
			}
		}
		return false;
	}
	//创建目标二维数组
	public static int[][] createArray(int x,int y){
		int[][] a = new int[x][y];
		int m=0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				a[i][j] = m;
				m++;
			}
		}
		return a;
	}
	public static void main(String[] args) {
		if(findTarget_01(createArray(5, 6), 100)){
			System.out.println("找到了!");
			System.out.println("位置为:"+"X:"+loca[0]+" Y:"+loca[1]);
		}
		else{
			System.out.println("没有找到!");
		}
	}
	
}
