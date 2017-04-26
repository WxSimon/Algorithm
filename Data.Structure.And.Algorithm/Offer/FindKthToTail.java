package Offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 思路:首先我们需要查的是节点倒数的位置，所以一般需要遍历两次，一次是得到链表的长度，然后就可以得到需要查找的节点
 *     但是我们现在可以使用两个节点来解决这个问题，就是通过将两个节点的位置差距为K，那么当第一个节点到最后的时候，那么第二个节点就是距离最后一个K
 * 
 * @author Wang
 * 
 */
public class FindKthToTail {
	public static class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode() {
		}
	}

	private static ListNode findKthToTail(ListNode head, int k) {
		ListNode p1 = head;
		ListNode p2 = null;
		if (head == null || k == 0) {
			return null;
		} else {
			for (int i = 0; i < k - 1; i++) {
				//防止k的数值大于链表的长度
				if (p1.next != null) {
					p1 = p1.next;
				}
				//这种就是k大于链表的长度的情况
				else{
					return null;
				}
			}
			p2 = head;
			while (p1.next != null) {
				p1 = p1.next;
				p2 = p2.next;
			}
			return p2;
		}
	}
	//将一个链表反转,记录三个位置:p1:当前节点位置 p2:当前节点前面的一个点的位置(已经反转了)  p3:当前节点后面的一个位置
	private static ListNode flipListNode(ListNode head){
		ListNode p1 = head;
		ListNode p2 = null;
		ListNode p3 = null;
		if(head == null)return null;
		else{
			while(p1!=null){
				ListNode p4 = p1.next;
				if(p4==null)p2 = p1;
					p1.next = p3;
					p3 = p1;
					p1 = p4;
				
			}
			return p2;
		}
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		flipListNode(l1);
	}
}
