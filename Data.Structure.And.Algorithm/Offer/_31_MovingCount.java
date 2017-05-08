package Offer;

/**
 * threshold :极限
 * 记录机器人行走的范围,因为对题目的理解出了问题，所以这个问题并不能解决
 * Recode rebot's way,but the problem is i do error in unstand the problem.So this problem cann't solve
 * @author Wang
 * 
 */
public class _31_MovingCount {
	public static int movingCount(int threshold, int rows, int cols) {
		int countGrid = 0;
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= cols; j++) {
				if (getProduct(i, j, threshold)) {
					countGrid++;
				}
			}
		}
		return countGrid;

	}

	public static void main(String[] args) {
		System.out.println(movingCount(5, 10, 10));
	}

	public static boolean getProduct(int rows, int cols, int threshold) {
		int count = 0;
		String row = String.valueOf(rows);
		char[] r = row.toCharArray();
		String col = String.valueOf(cols);
		char[] c = col.toCharArray();

		if ((rows%10)==0 ) {
			count += rows;
		} else {
			for (int i = 0; i < r.length; i++) {
				count += Integer.parseInt(String.valueOf(r[i]));
			}
		}
		if ((cols%10)==0) {
			count += cols;
		} else {
			for (int i = 0; i < c.length; i++) {
				count += Integer.parseInt(String.valueOf(c[i]));
			}
		}
		if (count > threshold)
			return false;
		else {
			return true;
		}
	}
}
