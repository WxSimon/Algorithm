package Algorithm;

import java.io.IOException;
import java.util.Scanner;

/**
 * 二叉树的创建和遍历 例如： A B C D ^ E ^
 * 
 * 输入为:ABD^^^CE^^^ *其中^代表“ ”(空格) 
 * 输出为: 
 * 	当前节点的值为:A 当前的层数为:1 
 * 	当前节点的值为:B 当前的层数为:2
 * 	当前节点的值为:D 当前的层数为:3 
 * 	当前节点的值为:C 当前的层数为:2 
 * 	当前节点的值为:E 当前的层数为:3
 * 
 * @author Wang
 * 
 */
public class BiTree {
	private static Scanner sc = new Scanner(System.in);
	private static BiTNode root = null;

	public static void main(String[] args) throws IOException {
		BiTNode bi = null;
		int level = 1;
		CreateBiTree(bi);
		
		preorderTraversal(root, level);
		inorderTraversal(bi, level);
		EpilogueTraversal(bi, level);
	}

	// 创建二叉树
	private static void CreateBiTree(BiTNode bi) throws IOException {
		char c = (char) sc.nextLine().getBytes()[0];
		if (' ' == c) {
			bi.setC(' ');
			bi = null;
		} else {
			// 创建根节点
			if (root == null) {
				root = new BiTNode();
				root.setC(c);
				CreateBiTree(root.lchild = new BiTNode());
				CreateBiTree(root.rchild = new BiTNode());
			} else {
				bi.setC(c);
				CreateBiTree(bi.lchild = new BiTNode());
				CreateBiTree(bi.rchild = new BiTNode());
			}
		}
	}

	// 前序遍历二叉树
	private static void preorderTraversal(BiTNode bi, int level) {
		if (bi != null && bi.getC() != ' ') {
			System.out.println("-----前序遍历---------");
			System.out.println("当前节点的值为:" + bi.getC() + "  当前的层数为:" + level);
			preorderTraversal(bi.lchild, level + 1);
			preorderTraversal(bi.rchild, level + 1);
		}
	}

	// 中序遍历二叉树
	private static void inorderTraversal(BiTNode bi, int level) {
		if (bi != null && bi.getC() != ' ') {
			System.out.println("-----中序遍历---------");
			preorderTraversal(bi.lchild, level + 1);
			System.out.println("当前节点的值为:" + bi.getC() + "  当前的层数为:" + level);
			preorderTraversal(bi.rchild, level + 1);
		}
	}

	// 后序遍历二叉树
	private static void EpilogueTraversal(BiTNode bi, int level) {
		if (bi != null && bi.getC() != ' ') {
			System.out.println("-----后序遍历---------");
			preorderTraversal(bi.lchild, level + 1);
			preorderTraversal(bi.rchild, level + 1);
			System.out.println("当前节点的值为:" + bi.getC() + "  当前的层数为:" + level);
		}
	}
}

class BiTNode {
	char c;
	BiTNode lchild;
	BiTNode rchild;

	public BiTNode() {
		lchild = null;
		rchild = null;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
}
