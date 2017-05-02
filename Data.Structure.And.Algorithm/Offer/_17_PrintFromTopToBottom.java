package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 		8
 * 	 6     10
 * 5   7  9   11
 * 结果:8 6 10 5 7 9 11
 * 思路:就是使用一个队列，将节点的左右子树的节点都保存起来
 *
 */
public class _17_PrintFromTopToBottom {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public static ArrayList<Integer> printFromTopToBottom(TreeNode root){
		if(root==null)return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.peek();
			result.add(queue.poll().val);
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(6);
		TreeNode t3 = new TreeNode(10);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(9);
		TreeNode t7 = new TreeNode(11);
		t1.left = t2;
		t1.right = t3;
		t2.left =t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		printFromTopToBottom(t1);
	}

}
