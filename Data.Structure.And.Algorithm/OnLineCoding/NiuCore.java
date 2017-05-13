package OnLineCoding;

public class NiuCore {
	private static final String MESSAGE="taobao";
	public static void main(String[] args) {
		//byte 的大小为-128 到-128所以a超出了内存，所以就取反
//		short a = 128;
//		byte b = (byte) a;
//		System.out.println("a"+a+",b"+b);
		
//		Integer var1 = new Integer(1);
//		int var2 = new Integer(1);
//		change(var2);
//		System.out.println(var1+" "+var2);
//		int i =1;
//		float j =2;
//		System.out.println(i/j);
		
		//s1的地址和MESSAGE的地址相同
		String s1 = "tao"+"bao";
		String s2 = "tao";
		String s3 = "bao";
		System.out.println(s1==MESSAGE);
		System.out.println((s1+s2)==MESSAGE);
		
	}
	private static void change(Integer i){
		i = 2;
	}
}
