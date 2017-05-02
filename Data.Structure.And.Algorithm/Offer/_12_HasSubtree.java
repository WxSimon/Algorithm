package Offer;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class _12_HasSubtree {
	//数的结构
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	private static boolean hasSubtree(TreeNode t1,TreeNode t2){
		boolean result = false;
		if(t1!=null && t2!=null){
			if(t1.val == t2.val){
				result = DoesTree1HaveTree2(t1,t2);
			}
			if(!result)result = hasSubtree(t1.left, t2);
			if(!result)result = hasSubtree(t1.right, t2);
		}
		return result;
	}

	private static boolean DoesTree1HaveTree2(TreeNode t1, TreeNode t2) {
		// TODO Auto-generated method stub
		if(t1==null)return false;
		if(t2==null)return true;
		if(t1.val != t2.val)return false;
		return DoesTree1HaveTree2(t1.left, t2.left) && DoesTree1HaveTree2(t1.right, t2.right);
	}
}
