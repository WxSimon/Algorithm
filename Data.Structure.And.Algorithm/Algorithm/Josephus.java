package Algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 约瑟夫算法:
 * 描述:n个小孩围成一圈，从第一个开始报数：1，2，3，1,2,3,1,2,3,……每次报k的小孩退出
 *	问最后剩下的那个小孩，在以前n人里是第几个？？？
 * 
 * @author Wang
 *
 */
public class Josephus {
	 public static void main(String[] args){  
	        List<Integer> list = new LinkedList<Integer>();  
	        for(int i = 1; i <= 41; i ++){  
	            list.add(i);  
	        }  
	        int index = 2;//第一个报到3的小孩，索引是2  
	        while(list.size()> 1){  
	            list.remove(index);   
	            index = index - 1;//移除该位元素后，下次需要从该位开始遍历，故减1  
	            index = (index +3)%list.size();  
	        }  
	        System.out.println(list.get(0)); 
	  
	    }  
}
