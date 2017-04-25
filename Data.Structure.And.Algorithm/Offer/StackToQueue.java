package Offer;

import java.util.Stack;


/**
 * 使用两个栈模拟一个队列
 * 栈:先进后出  示例: 1 2 3 输出 3 2 1
 * 队列:先进先出 示例: 1 2 3 输出 1 2 3  
 * 模拟出队列思路:因为栈是先进后出，所以可以使用两个栈一个负责存储，另一个负责模拟队列，假设存入的数据为 1 2 3
 * 存到stack1中为: 3 2 1 再将stack1中的数据存到stack2中就为1 2 3
 * @author Wang
 */
public class StackToQueue {
	 static Stack<Integer> stack1 = new Stack<Integer>();
	 static Stack<Integer> stack2 = new Stack<Integer>();
	 //进队列
	 private static void push(int node){
		 stack1.push(node);
	 }
	 //出队列
	 private static int pop(){
		 if(stack1.isEmpty() && stack2.isEmpty()){
			 throw new RuntimeException("Queue is Empty");
		 }
		 if(stack2.isEmpty()){
			 while(!stack1.isEmpty()){
				 stack2.push(stack1.pop());
			 }
		 }	 
		 return stack2.pop();
	 }
}
