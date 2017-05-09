package Offer;
/**
 * 二叉树的序列化和反序列化
 * @author Wang
 *
 */
public class _33_SerializeAndDeserialize {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	    public TreeNode(){}
	}
	public static String serialize(TreeNode root){
		String str = new String();
		if(root == null)return str;
		else{
			TreeNode currentNode = root;
			StringBuffer sb = new StringBuffer();
			serialize_01(currentNode,sb);
			return sb.toString();
		}
	}
	//二叉树的序列化
	private static void serialize_01(TreeNode currentNode, StringBuffer sb) {
		if(currentNode==null){
			sb.append("#,");
		}else{
			sb.append(currentNode.val);
			sb.append(",");
			serialize_01(currentNode.left, sb);
			serialize_01(currentNode.right, sb);
		}
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		System.out.println(serialize(t1));
		String str = serialize(t1);
		Deserialize(str);
	}
	//二叉树的反序列化
	private static TreeNode Deserialize(String str){
		TreeNode root = new TreeNode();
		if(str==null || str.length()<=0)return root;
		else{
			String[] strs = str.split(",");
			 return DeSerialize_01(strs);
		}
	}
	static int index =-1;
	//使用递归的方法来进行二叉树的反序列化
	private static TreeNode  DeSerialize_01(String[] strs) {
			index++;
			if(!strs[index].equals("#")){
				TreeNode root = new TreeNode();
				root.val = Integer.parseInt(strs[index]);
				root.left = DeSerialize_01(strs);
				root.right =DeSerialize_01(strs);
				return root;
			}
			return null;
	}
}
