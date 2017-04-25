package Offer;
import java.util.ArrayList;
/**
 * 输入一个链表从尾到头打印出来
 * 示例: 1 2 3 4
 * 输出: 4 3 2 1
 * 思路: 使用堆的先进后出来进行从尾到头的打印 Stack.push()输入 Stack.pop()除去首元素的输出
 */
import java.util.Stack;

public class PrintListFromTailToHead {
	
	 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        Stack<ListNode> stack = new Stack<ListNode>();
	        if(listNode==null)return list;
	        else{
	       		ListNode currentNode = listNode;
	        	while(currentNode!=null){
	        		//存
	                stack.push(currentNode);
	            	currentNode = currentNode.next;
	        }
	            while(!stack.isEmpty()){
	            	//取
	                list.add(stack.pop().val);
	            }
	        return list;
	        }
	    }
	
	/**
	 * 节点类
	 * @author Wang
	 *
	 */
	 public class ListNode {
	        int val;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
	    }
}

   
