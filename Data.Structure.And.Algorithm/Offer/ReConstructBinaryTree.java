package Offer;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 实现思路: 1  2  4  7  3  5  6  8 	前序遍历
 * 		  4  7  2  1  5  3  8  6            中序遍历
 * 可以得到根节点为1则在中序遍历中， 4 7 2 是属于左子树 5 3 8 6属于右子树
 * 
 * 然后在进行节点2的比较 4 7 都是属于左子树
 * 接着进行4的比较 7为右字树
 * 那么根节点左边的结构为:
 *           1
 *        2
 *     4     ^
 *  ^      7 
 * 接着判断右边 3,5为左子树，8  6为右子树
 * 接着是5 没啥判断的
 * 接着是6 8为6的左子树
 * 所以根节点的右边结构为
 * 			3
 * 		5       6
 * 			 8     ^
 * 
 * @author Wang
 *
 */
public class ReConstructBinaryTree {
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
	
    public static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre ,int [] in,int startIn,int endIn){
        if(startPre>endPre || startIn > endIn){
            return null;
        }
        else{
            TreeNode root = new TreeNode(pre[startPre]);
            for(int i=startIn;i<=endIn;i++){
                if(in[i] == pre[startPre]){
                	//递归调用,在中序遍历中处于节点左边的为左子树，处于节点右边的为右子树
                    root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                    root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                }
            }
            return root;
        }
    }
    public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = reConstructBinaryTree(pre, in);
	}
    
     public static class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
}
