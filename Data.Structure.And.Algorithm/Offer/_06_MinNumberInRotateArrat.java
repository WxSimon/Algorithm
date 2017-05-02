package Offer;


/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 这也是一个二分查找，定一个中间的标准进行查找
 * 示例 3 4 5 1 2 start 为0 value:3  end 为4 value:2 mid = 2 value:5
 * array[start] 3< array[mid] 5 start = mid = 2 mid =(2+4)/2 =3 value = 1
 * array[mid] 1< array[end] 2 end = mid =3 start = 2 mid - start = 1 找到了 mid = end = 3 找到的数值为array[3]=1
 *
 */
public class _06_MinNumberInRotateArrat {
	public static int minNumberInRotateArrat(int[] array){
		if(array.length==0)return 0;
		else{
			int start = 0;
			int end = array.length-1;
			int mid = start;
			
			while(array[start]>=array[end]){
				if(end - start ==1){
					mid = end;
					break;
				}
				mid = (start+end)/2;
				if(array[start] == array[end] && array[mid] == array[start]){
					return minInOrder(array, start, end);
				}
				//中间标记为前面的递增队列中,那么目标的数组在后面,将中间位置和前面的位置交换
				if(array[start]<= array[mid]){
					start = mid;
				}
				//中间标记的值比最后一个小，说明目标数组在前面，将后面的位置和中间的交换
				else if(array[mid]<= array[end]){
					end = mid;
				}
			}
			return array[mid];
		}
	}
	private static int minInOrder(int[] array,int start,int end){
		int result = array[start];
		for (int i = start+1; i <=end; ++i) {
			if(result>array[i]){
				result = array[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] a = {2,3,4,5,6,7,8,9,11,13,1};
		System.out.println(minNumberInRotateArrat(a));
	}		
}
