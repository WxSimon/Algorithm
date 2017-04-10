package Algorithm_Huffman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 哈夫曼编码算法
 * @author Wang
 *
 */
public class Huffman {
	
	/**
	 * 统计字符出现的概率
	 * @param charArray 输入的字符串
	 * @return
	 */
	public static Map<Character, Integer> statistics(char[] charArray){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : charArray) {
			Character character = new Character(c);
			if(map.containsKey(character)){
				map.put(character, map.get(character)+1);
			}
			else{
				map.put(character, 1);
			}
		}
		return map;
	}
	
	/**
	 * 构建完全二叉树
	 * @param statistics
	 * @param list
	 * @return
	 * 
	 * 构建树是Huffman编码算法的核心步骤。
	 * 思想是：
	 * 		把所有的字符挂到一颗完全二叉树的叶子节点，任何一个非页子节点的左节点出现频率不大于右节点。
	 * 算法为：
	 * 		把统计信息转为Node存放到一个优先级队列里面，每一次从队列里面弹出两个最小频率的节点，
	 * 		构建一个新的父Node(非叶子节点), 字符内容刚弹出来的两个节点字符内容之和，频率也是它们的和，
	 * 		最开始的弹出来的作为左子节点，后面一个作为右子节点，并且把刚构建的父节点放到队列里面。
	 * 		重复以上的动作N-1次，N为不同字符的个数(每一次队列里面个数减1)。
	 * 结束以上步骤，队列里面剩一个节点，弹出作为树的根节点
	 */
	public static Tree buildTree(Map<Character, Integer> statistics,List<Node> list){
		Character[] keys = statistics.keySet().toArray(new Character[0]);
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
		for (Character character : keys) {
			Node node = new Node();
			node.chars = character.toString();
			node.frequence = statistics.get(character);			//字符出现的概率
			priorityQueue.add(node);							//进栈
			list.add(node);
		}
		int size = priorityQueue.size();
		for (int i = 0; i < size-1; i++) {
			
			//弹出概率最小的两个节点
			Node node1 = priorityQueue.poll();					//出栈
			Node node2 = priorityQueue.poll();					//出栈
			
			//构建父节点
			Node sumNode = new Node();
			sumNode.chars = node1.chars+node2.chars;
			sumNode.frequence = node1.frequence+node2.frequence;
			
			sumNode.leftNode = node1;
			sumNode.rightNode = node2;
			
			node1.parent = sumNode;
			node2.parent = sumNode;
			
			priorityQueue.add(sumNode);
		}
		Tree tree = new Tree();
		tree.root = priorityQueue.poll();
		return tree;
	}
	
	//编码
	public static String encode(String originalStr,Map<Character,Integer> statistics){
		if(originalStr == null || originalStr.equals("")){
			return "";
		}
		char[] charArray = originalStr.toCharArray();
		List<Node> leafNodes = new ArrayList<Node>();
		buildTree(statistics, leafNodes);
		Map<Character,String> encodeInfo = buildEncodeInfo(leafNodes);
		StringBuffer buf = new StringBuffer();
		for (char c: charArray) {
			Character character = new Character(c);
			buf.append(encodeInfo.get(character));
		}
		return buf.toString();
	}
	//遍历二叉树，如果为左则前缀为0 右前缀为1
	private static Map<Character, String> buildEncodeInfo(List<Node> leafNodes) {
		Map<Character, String> codewords = new HashMap<Character, String>();
		for (Node node : leafNodes) {
			Character character = new Character(node.getChars().charAt(0));
			String codeword = "";
			Node currrentNode = node;
			do {
				if(currrentNode.isLeftChild()){
					codeword  = "0"+codeword;
				}
				else{
					codeword ="1"+codeword;
				}
				currrentNode = currrentNode.parent;
			} while (currrentNode.parent!=null);
			codewords.put(character, codeword);
		}
		
		return codewords;
	}
	
	//解码
	public static String decode(String binaryStr,Map<Character,Integer> statistics){
		if(binaryStr ==null && binaryStr.equals("")){
			return "";
		}
		char[] binaryCharArray = binaryStr.toCharArray();
		LinkedList<Character> binaryList = new LinkedList<Character>();
		int length = binaryCharArray.length;
		for (int i = 0; i < length; i++) {
			binaryList.addLast(new Character(binaryCharArray[i]));
		}
		List<Node> leafNodes = new ArrayList<Node>();
		Tree tree = buildTree(statistics, leafNodes);
		StringBuffer buf = new StringBuffer();
		while (binaryList.size()>0) {
			Node node = tree.root;
			do{
				Character c = binaryList.removeFirst();
				if(c.charValue() == '0'){
					node = node.leftNode;
				}
				else{
					node = node.rightNode;
				}
			}while(!node.isLeaf());
			buf.append(node.chars);
		}
		return buf.toString();
	}
	public static void main(String[] args) {
		String testString ="I LOVE JAVA AND CODEING MAKE ME HAPPLY";
		Map<Character, Integer> statistics = statistics(testString.toCharArray());
		String encodeStr = encode(testString, statistics);
		String decodeStr = decode(encodeStr, statistics);
		System.out.println(testString);
		System.out.println("EncodeString..."+encodeStr);
		System.out.println("DecodeString..."+decodeStr);
	}
}