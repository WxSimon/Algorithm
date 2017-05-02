package Offer;
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 示例:{5,7,6,9,11,10,8}这个就是一个二叉树的后序遍历结果，因为8是根节点，所以5 7 6 <8是左子树  9 11 10 是右子树
 * 5 7 6 中 6是根节点，5<6 左节点， 7>6 右节点 后面同理
 * 思路:还是利用递归性，就是将数组划分为两个区域，一个是大于父节点的区域，一个是小于父节点的区域，现在就是要判断是否都满足
 *
 */
public class _18_VerifySquenceOfBST {
	private static boolean verifySquenceOfBST(int[] array){
		if(array == null || array.length ==0)return false;
		return isTreeBST(array,0,array.length-1);
	}

	private static boolean isTreeBST(int[] array, int start, int end) {
		if(start>=end)return true;
		int i= start;
		//这个循环是找到比更根节点小的位置
		for (; i < end; i++) {
			if (array[i]>array[end]) {
				break;
			}
		}
			//这个是找到根节点大的位置，这里的意思就是说：右子树的值必须都大于父节点
			for (int j2 = i; j2 < end; j2++) {
				if (array[j2]<array[end]) {
					return false;
				}
			}
		return isTreeBST(array, start, i-1) && isTreeBST(array, i, end-1);
	}
	public static void main(String[] args) {
		int[] array ={5,7,6,9,11,10,8};
		verifySquenceOfBST(array);
	}
}
