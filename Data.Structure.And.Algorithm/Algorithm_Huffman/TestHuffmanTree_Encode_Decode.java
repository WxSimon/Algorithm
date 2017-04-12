package Algorithm_Huffman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TestHuffmanTree_Encode_Decode {

	// 节点类
	public static class Node implements Comparable<Node> {
		String data;
		double weight;
		Node leftChild;
		Node rightChild;
		Node parent;

		public boolean isLeftChild() {
			return parent != null && this == parent.leftChild;
		}

		public Node() {

		}

		public Node(String data, double weight) {
			this.data = data;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", weight=" + weight + "]";
		}
		//队列排序依据
		public int compareTo(Node o) {
			//按照weight的降序在队列中排序
			return (int) (weight - o.weight);
		}

		public boolean isLeaf() {
			return data.length() == 1;
		}
	}

	private static List<Node> leafNodes;
	/**
	 * 统计字符出现的次数，保存为一个map类型
	 * @param charArray
	 * @return
	 */
	public static Map<Character, Integer> statistics(char[] charArray) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : charArray) {
			Character character = new Character(c);
			if (map.containsKey(character)) {
				map.put(character, map.get(character) + 1);
			} else {
				map.put(character, 1);
			}
		}
		return map;
	}

	/**
	 * 将保存的map类型的保存为List链表
	 * @param maps
	 * @return
	 */
	public static List<Node> statisticsProbability(Map<Character, Integer> maps) {
		List<Node> list = new ArrayList<TestHuffmanTree_Encode_Decode.Node>();
		for (Map.Entry<Character, Integer> map : maps.entrySet()) {
			Node node = new Node(map.getKey().toString(), map.getValue());
			list.add(node);
		}
		return list;
	}

	// 构建哈夫曼二叉树，通过priorityQueue对列进行排序和构建
	public static Node createTree(List<Node> nodes) {
		// quickSort(nodes);
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
		for (int i = 0; i < nodes.size(); i++) {
			priorityQueue.add(nodes.get(i));
		}
		int size = priorityQueue.size();
		for (int i = 0; i < size - 1; i++) {

			// 弹出概率最小的两个节点
			Node node1 = priorityQueue.poll(); // 出栈，		* priorityQueue.poll()获取并且移除队列的头
			Node node2 = priorityQueue.poll(); // 出栈

			// 构建父节点
			Node sumNode = new Node(node1.data + node2.data, node1.weight
					+ node2.weight);

			sumNode.leftChild = node1;
			sumNode.rightChild = node2;

			node1.parent = sumNode;
			node2.parent = sumNode;

			priorityQueue.add(sumNode);		//priorityQueue.add<E>将指定元素插入到次优先级队列
		}
		Node node = new Node();
		node = priorityQueue.poll();
		return node;
	}

	// 编码
	public static String encode(String originalStr) {
		if (originalStr == null || originalStr.equals("")) {
			return "";
		}
		char[] charArray = originalStr.toCharArray();
		leafNodes = statisticsProbability(statistics(charArray));
		createTree(leafNodes);

		Map<Character, String> encodeInfo = buildEncodeInfo(leafNodes);
		StringBuffer buf = new StringBuffer();
		for (char c : charArray) {
			Character character = new Character(c);
			buf.append(encodeInfo.get(character));
		}
		return buf.toString();
	}

	// 遍历二叉树，如果为左则前缀为0 右前缀为1
	private static Map<Character, String> buildEncodeInfo(List<Node> leafNodes) {
		Map<Character, String> codewords = new HashMap<Character, String>();
		for (Node node : leafNodes) {
			Character character = new Character(node.data.charAt(0));
			String codeword = "";
			Node currrentNode = node;
			do {
				if (currrentNode.isLeftChild()) {
					codeword = "0" + codeword;
				} else {
					codeword = "1" + codeword;
				}
				currrentNode = currrentNode.parent;
			} while (currrentNode.parent != null);
			codewords.put(character, codeword);
		}
		return codewords;
	}

	// 解码
	public static String decode(String binaryStr) {
		if (binaryStr == null && binaryStr.equals("")) {
			return "";
		}
		char[] binaryCharArray = binaryStr.toCharArray();
		LinkedList<Character> binaryList = new LinkedList<Character>();
		int length = binaryCharArray.length;
		for (int i = 0; i < length; i++) {
			binaryList.addLast(new Character(binaryCharArray[i]));
		}
		Node tree = createTree(leafNodes);
		StringBuffer buf = new StringBuffer();
		while (binaryList.size() > 0) {
			Node node = tree;
			do {
				Character c = binaryList.removeFirst();
				if (c.charValue() == '0') {
					node = node.leftChild;
				} else {
					node = node.rightChild;
				}
			} while (!node.isLeaf());
			buf.append(node.data);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		String testString = "I LOVE JAVA AND CODEING MAKE ME HAPPLY";
		System.out.println("String: " + testString);
		String encodeStr = encode(testString);
		System.out.println("Encode: " + encode(testString));
		String decodeStr = decode(encodeStr);
		System.out.println("Decode: " + decodeStr);
	}
}
