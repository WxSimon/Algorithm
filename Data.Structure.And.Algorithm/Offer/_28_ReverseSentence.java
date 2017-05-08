package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 翻转一个字符串中所有字符
 * 示例:I am a Student 翻转为  Student a am I
 * @author Wang
 * reverse all worlds in a character string
 * example: String: I am a Student Result: Student  a am i
 * ***Thinking:
 * 			  * First Method is reverse all chars,and then reveres worlds one more
 *  		  * Second Method is save worlds in List,and then reverse the list,so this's method is easy
 *
 */
public class _28_ReverseSentence {
	public static String reverseSentence(String str) {
		String str1 = new String();
		if (str == null)
			return str1;
		else {
			char[] ch = reverse(str);
			// 将字符串中每个单词翻转
			String s = reverseWorld(String.valueOf(ch));
			return s;
		}
	}

	// 将字符串翻转
	private static char[] reverse(String str) {
		char[] ch = str.toCharArray();
		int start = 0;
		int end = ch.length - 1;
		// 将整个字符串翻转
		while (start < end) {
			char tem = ch[start];
			ch[start] = ch[end];
			ch[end] = tem;
			start++;
			end--;
		}
		return ch;
	}

	// 翻转每个单词,以空格为间隔
	public static String reverseWorld(String str) {
		StringBuffer sb = new StringBuffer();
		char[] ch = str.toCharArray();
		int start = 0;
		int end = ch.length - 1;
		while (start <= end) {
			int count = start;
			while (count <= end && ch[count] != ' ') {
				count++;
			}
				// 翻转从0 到count;
				String str1 = str.substring(start, count);
				sb.append(reverse(str1));
				if(count<=end){
					sb.append(" ");
				}
				start = count + 1;
		}
		return sb.toString();
	}

	//Method Two use List to save all world,
	//then make all world reverse
	//person to say,this is way is easy to understand
	public static String reverseSentence01(String str){
		String str1 = new String();
		if(str==null)return str1;
		else{
			List<String> list1 = new ArrayList<String>();
			StringBuffer sb = new StringBuffer();
			char[] ch = str.toCharArray();
			int p =0;
			//save all worlds into list
			for (int i = 0; i < ch.length; i++) {
				if(ch[i]==' '){
					String s1 = str.substring(p, i);
					list1.add(s1);
					p=i+1;
				}
				else if(i==ch.length-1){
					String s1 = str.substring(p, i+1);
					list1.add(s1);
					p=i+1;
				}
			}
			//reverse all worlds
			for (int i = list1.size()-1; i >=0; i--) {
				if(i!=0){
					str1 = str1+ list1.get(i)+" ";
					sb.append(list1.get(i));
					sb.append(' ');
				}
				else {
					str1 =str1+ list1.get(i);
				}
			}
			return str1;
		}
	}
	public static void main(String[] args) {
//		System.out.println(reverseSentence("I am a Student."));
		System.out.println(reverseSentence01("Hello World a a."));
	}
}
