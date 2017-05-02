package Offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路:使用两个栈，其中一个栈用用来存放最小的一个元素，
 */
public class _15_StackWithMin {
	static Stack<Integer> s1 = new Stack<Integer>();		//数据栈
	static Stack<Integer> s2 = new Stack<Integer>();		//用来存放最小值的栈
	//存在两个栈，一个栈用来存放正常的数据，一个栈用来存放最小的数据，
	private static void push(int node){
		s1.push(node);
		if(s2.isEmpty() || s2.peek()>node){
			s2.push(node);
		}
		else{
			s2.push(s2.peek());
		}
	}
	private static void pop(){
		if(!s1.isEmpty() && !s2.isEmpty()){
			s1.pop();
			s2.pop();
		}
	}
	private static int top(){
		if(s1.isEmpty() || s2.isEmpty())return 0;
		else{
			return s2.peek();
		}
	}
	private static int min(){
		if(s1.isEmpty() || s2.isEmpty())return 0;
		else{
			return s2.peek();
		}
	}
}
