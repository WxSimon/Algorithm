package Offer;
/**
 * 在一个字符串中，为了网络传输的方便，将字符串中的空格" "替换成为"%20"
 * 示例:"Hello World" 替换为:"Hello%20World"
 * @author Wang
 *
 */
public class _02_ReplaceSpace {
	/**
	 * 这种方法的思路就是 遍历字符串，当遇到" "的时候就直接替换为空格
	 * @param str
	 * @return
	 */
	public static String replaceSpace(StringBuffer str){
		if(str==null)return null;
		String sti = str.toString();
		char[] sc = sti.toCharArray();
		StringBuffer str1 = new StringBuffer();
		for (int i = 0; i < sc.length; i++) {
			if(sc[i]==' '){
				str1.append("%20");
			}
			else{
				str1.append(sc[i]);
			}
		}
		return str1.toString();
	}
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello World I Am");
		System.out.println(replaceSpace(sb));
	}
}
