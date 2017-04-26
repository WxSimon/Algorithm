package Offer;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。 
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5 ·
 思路:就是一直进行左右子树的交换，但是交换的前提是必须存在左子树和右子树
 */
public class MirrorRecursively {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public static void mirrorRecursively(TreeNode root){
		//一直左右子树进行交换
		if(root == null)return;
		if(root.left == null && root.right == null)return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left!=null){
			mirrorRecursively(root.left);
		}
		if(root.right!=null){
			mirrorRecursively(root.right);
		}
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
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		mirrorRecursively(t1);
	}
}
