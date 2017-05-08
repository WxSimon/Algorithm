package OnLineCoding;
/**
 * 二分查找第一个目标数
 */
import java.io.ObjectInputStream.GetField;

public class BinarySearch {
	 public static int getPos(int[] A, int n, int val) {
	        // write code here
	        if(n<=0 || A==null)return -1;
	        int start = 0;
	        int end = n-1;
	        int mid = 0;
	        while(start<end){
	            mid = (start+end)/2;
	           if(A[mid]>val){
	        	   end = mid-1;
	           }
	           else if(A[mid]<val){
	        	   start = mid+1;
	           }else{
	        	   end = mid;
	           }
	        }
	        if(A[end] == val) return end;
	        return -1;
	    }
	 public static void main(String[] args) {
		int[] array ={4,4,5,6};
		System.out.println("位置为:"+getPos(array, 4, 4));
	}
}
