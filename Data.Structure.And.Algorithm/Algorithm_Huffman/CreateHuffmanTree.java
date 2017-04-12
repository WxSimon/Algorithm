package Algorithm_Huffman;

import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

/**
 * 构建哈夫曼树 
 * @author Wang
 *
 */
public class CreateHuffmanTree {
	//节点类
	public static class Node<E>{
		E data;
		double weight;
		Node leftChild;
		Node rightChild;
		public Node(E data,double weight){
			this.data = data;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", weight=" + weight + "]";
		}
	}
	
	//构建哈夫曼二叉树
	public static Node createTree(List<Node> nodes){
		while(nodes.size()>1){
			quickSort(nodes);
			Node left = nodes.get(nodes.size()-1);
			Node right = nodes.get(nodes.size()-2);
			Node parent =new Node(null,left.weight+right.weight);
			
			parent.leftChild = left;
			parent.rightChild = right;
			nodes.remove(nodes.size()-1);
			nodes.remove(nodes.size()-1);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	
	
	/**
	 * 快速排序
	 * @param nodes
	 */
	private static void quickSort(List<Node> nodes) {
		subSort(nodes, 0, nodes.size()-1);
	}

	/**
	 *	快速排序 对节点进行排序 
	 * @param nodes
	 * @param statr
	 * @param end
	 */
	private static void subSort(List<Node> nodes,int statr,int end){
		if(statr < end){
			Node base = nodes.get(statr);
			int i = statr;
			int j = end+1;
			while(true){
				while(i<end && nodes.get(++i).weight>=base.weight);
				while(j>statr && nodes.get(--j).weight<=base.weight);
				if(i<j){
					swap(nodes,i,j);
				}else{
					break;
				}
			}
			swap(nodes, statr, j);
			subSort(nodes, statr, j-1);
			subSort(nodes, j+1, end);
		}
	}

	private static void swap(List<Node> nodes, int i, int j) {
		Node temp;
		temp = nodes.get(i);
		nodes.set(i, nodes.get(j));
		nodes.set(j, temp);
	}
	
	/**
	 * 遍历树
	 */
	public static List<Node> breadthFirst(Node node){
		Queue<Node> queue = new ArrayDeque<CreateHuffmanTree.Node>();
		List<Node> list = new ArrayList<Node>();
		if(node!=null){
			queue.offer(node);
		}
		while(!queue.isEmpty()){
			list.add(queue.peek());
			Node p = queue.poll();
			if(p.leftChild!=null){
				queue.offer(p.leftChild);
			}
			if(p.rightChild!=null){
				queue.offer(p.rightChild);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<Node> list = new ArrayList<Node>();
		Node A = new Node('A', 10.0);
		Node B = new Node('B', 21.0);
		Node C = new Node('C', 121.0);
		Node D = new Node('D', 22.0);
		Node E = new Node('E', 13.0);
		Node F = new Node('F', 15.0);
		Node G = new Node('G', 16.0);
		list.add(A);
		list.add(B);
		list.add(C);
		list.add(D);
		list.add(E);
		list.add(F);
		list.add(G);
		Node root = createTree(list);
		System.out.println(breadthFirst(root));
		
	}
}
