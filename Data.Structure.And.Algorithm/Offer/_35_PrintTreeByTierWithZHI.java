package Offer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Offer._34_PrintTreeByTier.TreeNode;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。 但是是按照"之"字型进行遍历的 第一个是从左到右，第二个是从右到左
 * 思路:通过判断是否为偶数层，是偶数层的话那么就反向存入就可以了。
 * Time: 2017-05-15 11:15:05
 * Thinking:I have save it,so it's so easy ,i only need to judge it's double line or single,
 * when the tier is double i only need to add it into list by reverse
 */
public class _35_PrintTreeByTierWithZHI {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static ArrayList<ArrayList<Integer>> printTreeByTier(TreeNode root) {
		// 存放所有结果的List
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		// 存放每行结果的List
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		// 存放每行节点的Queue
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return resultList;
		else {
			// 将每一行都放到队列里面去
			queue.add(root);
			// 规定启示位置
			int start = 0;
			int end = 1;
			int tier = 1;
			while (!queue.isEmpty()) {
					TreeNode currentNode = queue.remove();
					start++;
					// 将该行的值保存
					tmpList.add(currentNode.val);
					if (currentNode.left != null) {
						queue.add(currentNode.left);
					}
					if (currentNode.right != null) {
						queue.add(currentNode.right);
					}
					// 遍历完队列之后将结果保存
					if (start == end) {
						start = 0;
						end = queue.size();
						//判断行数的奇偶，偶数就是从右到左
						if((tier%2)==0){
							resultList.add(reverse(tmpList));
						}
						else{
							resultList.add(tmpList);
						}
						
						tier++;
						tmpList = new ArrayList<Integer>();
					}
			}
			return resultList;
		}
	}
	public static ArrayList<Integer> reverse(ArrayList<Integer> list){
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i = list.size()-1; i >=0; i--) {
			list2.add(list.get(i));
		}
		return list2;
	}

	public static void main(String[] args) {
		/**
		 * 测试用到的数的结构为:	 1 
		 * 				  2 	3
		 * 			  	4  5  6
		 */
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		ArrayList<ArrayList<Integer>> resultList=printTreeByTier(t1);
		for (int i = 0; i < resultList.size(); i++) {
			
		}
	}

}
