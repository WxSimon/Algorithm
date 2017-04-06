package DataStruture;

import org.junit.Test;

//链表
public class LinkList {
	public Node head;	//头节点
	public Node current;
	
	
	//链表中添加数据
	public void add(int data){
		if(head == null){
			//头节点赋值
			head = new Node(data);
			current =  head;
		}
		else{
			current.next = new Node(data); 	
			current = current.next;		//将当前的索引向后移一位
		}
	}
	//从头节点开始遍历链表
	public void print(Node head){
		if(head == null){
			return ;
		}
		current = head;
		while(current!=null){
			System.out.print(current.data+" ");
			current = current.next;
		}
	}
	//获取链表长度
	public int getLength(){
		int lenght =0;
		if(head == null)return 0;
		current = head;
		while(current!=null){
			lenght++; 
			current = current.next;
		}
		return lenght;
		
	}
	
	//删除第几个节点
	public Boolean delete(int n){
		if(n > getLength()){
 			return false;
		}
 		current = head;
  		for (int i = 1; i < n-1; i++) {
          			current = current.next;
		}
		Node node = new Node() ;
		node = current.next;
		node.data = current.data;
		current.next = node.next;
		return true;		
	}
	
	public Node mergeLinkList(Node head1, Node head2){
		if(head1 == null && head2 == null){
			return null;
		}
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		
		Node head;
		Node current;
		if(head1.data<head2.data){
			head = head1;
			current = head;
			head1 = head1.next;
		}
		else{
			head = head2;
			current = head;
			head2 = head2.next;
		}
		while(head1!=null && head2!=null){
			if(head1.data<head2.data){
				current.next = head1;
				current = current.next;
				head1 = head1.next;
			}
			else{
				current.next = head2;
				current = current.next;
				head2 = head2.next;
			}
		}
		if(head1!=null){
			current.next = head1;
			
		}
		if(head2!=null){
			current.next = head2;			
		}
		return head;
		
	}
	
	
	
	public static void test(int n){
		LinkList list1 = new LinkList();
		for (int i = 1; i <= n; i++) {
			list1.add(i);
		}
		list1.print(list1.head);
		LinkList list2 = new LinkList();
		for (int i = 2; i <10 ; i=i+2) {
			list2.add(i);
		}
		System.out.println();
		list2.print(list2.head);
		
		System.out.println();
		Node headMerge = list1.mergeLinkList(list1.head,list2.head);
		LinkList l = new LinkList();
		l.print(headMerge);
		
		
//  		list1.delete(1);
//		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		test(10);		
	}
}


/**
 * 节点
 * @author Wang
 *
 */
class Node{
	//数据
	int data;
	//指向下一个
	Node next;
	public Node(int data){
		this.data = data;
	}
	public Node(){
		
	}
}
