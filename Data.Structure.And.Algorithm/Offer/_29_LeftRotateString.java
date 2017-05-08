package Offer;
/**
 * 问题:左移n位的字符串
 * 例如:abcdefg 2 结果:cdefgab
 * 思路:直接截取n位的字符，然后进行拼接
 * 
 * Question:left rotate string by n
 * Example: String: abcdefg N =2 Result:cdefgab
 * Thinking:only to cut out n post char,and then joint to original string
 * 
 *
 */
public class _29_LeftRotateString {
	public static String leftRotateString(String str,int n){
		String result = new String();
		if(str==null || str.isEmpty() || str.length()<n)return result;
		else{
			//cut out n post char
			String tmp = str.substring(0, n);
			str = str.substring(n);
			//ToDo String joint
			result = str + tmp;
			return result;
		}
	}
	public static void main(String[] args) {
		System.out.println(leftRotateString("abcdefg", 2));
	}
}
