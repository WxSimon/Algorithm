package Offer;

import java.util.HashMap;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class _25_FindFirstCommonNode {
	//节点
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	//第一种方法:采用map的特性，map的key只能是唯一的
	private static ListNode findFirstCommonNode_01(ListNode n1,ListNode  n2){
		if(n1==null || n2 ==null)return null;
		else{
			HashMap<ListNode, Integer> map = new HashMap<_25_FindFirstCommonNode.ListNode, Integer>();
			while(n1!=null){
				map.put(n1, null);
				n1 = n1.next;
			}
			while(n2!=null){
				if(map.containsKey(n2))return n2;
				else{
					n2 = n2.next;
				}
			}
			return null;
		}
	}
}
