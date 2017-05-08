package OnLineCoding;
/**
 * 查找第一个出现的字符
 */
import java.util.HashMap;

public class FindFirstChar {
	public static char findFirstChar(String str){
		if(str.length()<=0 || str == null)return (Character) null;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if(!map.containsKey(cs[i])){
				map.put(cs[i], null);
			}else{
				return cs[i];
			}
		}
		return (Character) null;
	}
	public static void main(String[] args) {
		String s = "Hello";
		System.out.println(findFirstChar(s));
	}
}
