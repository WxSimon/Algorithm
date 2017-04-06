package Algorithm;
//汉罗塔问题
public class HanRomTower {
	
	/**
	 * 有三根杆子A，B，C。A杆上有N个(N>1)穿孔圆盘，盘的尺寸由下到上依次变小。要求按下列规则将所有圆盘移至C杆：
	 *	1.每次只能移动一个圆盘；
	 *  2.大盘不能叠在小盘上面。
	 */
	static int i=0;
	public static void main(String[] args) {
		int n=10;
		char x ='X';
		char y ='Y';
		char z ='Z';
		move(n,x,y,z);
		System.out.println("总步数:"+i);
	}
	
	//将n个盘子从x借助y一移到z
	private static void move(int n, char x, char y, char z) {
		if(1 == n){
			System.out.println(x+"-->"+z);
			i++;
		}
		else{
			//先将n-1个从x借助z移到y
			move(n-1,x,z,y);
			System.out.println(x+"-->"+z);
			i++;
			//再将n-1个从y借助x移到z
			move(n-1,y,x,z);
		}
	}

		
}