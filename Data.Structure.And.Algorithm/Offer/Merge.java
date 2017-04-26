package Offer;

import Offer.FindKthToTail.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 例如: List1: 1 3 5 7  List2: 2 4 6 8 合并之后: List3: 1 2 3 4 5 6 7 8
 * 思路:就是比较两个链表的值的大小
 */
public class Merge {
	//节点类
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	private static ListNode merge(ListNode L1,ListNode L2){
		//存在一个链表为空的情况
		if(L1 == null)return L2;
		else if(L2 == null)return L1;
		ListNode L3 = null;
		//比较两个值的大小
		if(L1.val > L2.val){
			L3 = L2;
			L3.next = merge(L1, L2.next);
		}else{
			L3 = L1;
			L3.next = merge(L1.next, L2);
		}return L3;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(6);
		ListNode l14 = new ListNode(8);
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		ListNode L3 = merge(l1, l11);
		System.out.println("");
	}
}
