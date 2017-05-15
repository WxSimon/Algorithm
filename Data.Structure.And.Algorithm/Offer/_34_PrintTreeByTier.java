package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 思路:通过队列的的特性来解决这个问题，将每一行的节点都放到队列里面去
 *
 */
public class _34_PrintTreeByTier {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public static ArrayList<ArrayList<Integer>> printTreeByTier(TreeNode root){
		//存放所有结果的List
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		//存放每行结果的List
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		//存放每行节点的Queue
		Queue<TreeNode> queue = new LinkedList<_34_PrintTreeByTier.TreeNode>();
		if(root==null)return resultList;
		else{
			//将每一行都放到队列里面去
			queue.add(root);
			//规定启示位置
			int start = 0;
			int end = 1;
			while(!queue.isEmpty()){ 
				TreeNode currentNode = queue.remove();
				start++;
				//将该行的值保存
				tmpList.add(currentNode.val);
				if(currentNode.left!=null){
					queue.add(currentNode.left);
				}
				if(currentNode.right!=null){
					queue.add(currentNode.right);
				}
				//遍历完队列之后将结果保存
				if(start==end){
					start=0;
					end = queue.size();
					resultList.add(tmpList);
					tmpList = new ArrayList<Integer>();
				}
			}
			return resultList;
		}
	}
	public static void main(String[] args) {
		/**
		 * 测试用到的数的结构为:
		 * 			1
		 * 		2		3
		 * 	4	    5  6
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
		printTreeByTier(t1);
	}
}
