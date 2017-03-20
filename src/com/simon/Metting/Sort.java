package com.simon.Metting;

/**
 * 八大排序算法集合和理解
 * 
 * @author Wang
 * 
 */
public class Sort {

	/**
	 * 1.直接插入 默认前面的数据是已经排好的，然后依次把后面的数据插入到合适的位置 时间复杂度:O(n^2)
	 * 最佳复杂度：O（n）：已经排好的，最差复杂度:O(n^2):倒序
	 */

	public static void insertSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {// 注意[0,i-1]都是有序的。如果待插入元素比a[i-1]还大则无需再与[i-1]前面的元素进行比较了，反之则进入if语句
				int temp = a[i];
				int j;
				for (j = i - 1; j >= 0 && a[j] > temp; j--) {
					a[j + 1] = a[j];// 把比temp大或相等的元素全部往后移动一个位置
				}
				a[j + 1] = temp;// 把待排序的元素temp插入腾出位置的(j+1)
			}
		}
		System.out.println("");
		System.out.println("****1.直接排序之后****:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}

	}

	/**
	 * 2.希尔排序 先将需要排序的一组记录按照某一个增量d分成若干个子序列，每组记录的下表相差d，对每组的全部元素进行直接插入排序
	 * 然后用一个较小的增量(d/2)对之进行分组，在每组中进行直接插入排序，继续不断缩小增量直到为1，最后使用直接排入排序完成排序
	 * 简单理解：假设n=10 dk = 5 第一次就是 a[0] a[5];a[1] a[6];a[2] a[7];a[3] a[8];a[4]
	 * a[9]进行直接插入排序 第二次n=2 就是a[0] a[2],a[1] a[3],a[2] a[4],a[3] a[5],a[4]
	 * a[6],a[5] a[7],a[6] a[8],a[7] a[9]进行直接插入排序 时间复杂度：O(n^1.3)
	 */
	public static void shellInsertSort(int a[], int n, int dk) {
		if (n < 2)
			return;
		for (int i = dk; i < n; i++) {
			if (a[i - dk] > a[i]) {
				int key = a[i];
				int j;
				for (j = i - dk; j >= 0 && a[j] > key; j -= dk) {
					a[j + dk] = a[j];
				}
				a[j + dk] = key;
			}
		}
	}

	public static void shellSort(int a[]) {
		int n = a.length;
		int dk = n / 2;
		while (dk >= 1) {
			shellInsertSort(a, n, dk);
			dk /= 2;
		}
		System.out.println("");
		System.out.println("****2.希尔排序之后****:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	/**
	 * 3.选择排序 每次都选择一个最大值放在最后面，选择一个最小值放在最前面 时间复杂度:O(n^2)
	 */
	public static void selectSort(int a[]) {
		if (a.length < 2)
			return;
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				// 将当前的和后面的进行对比,找出一个比当前还要小的然后和当前的进行互换位置
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = 0;
				temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
		System.out.println("");
		System.out.println("****3.选择排序之后:****");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	/**
	 * 4.堆排序 时间复杂度：O(nlogn) 建立堆的复杂度为O(n),只建立一次
	 */
	private static class HeapSort {
		public HeapSort(int a[]) {
			buildMaxHeapify(a);
			heapSort(a);
			System.out.println("");
			System.out.println("****4.堆排序之后:****");
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + ",");
			}
		}

		// 构建初始最大堆
		// 假设长度为8 那么
		// 第一个父节点就是a[3] 左结点为:a[7]
		// 第二个父节点为:a[1] 左节点为:a[3] 右结点为:a[4]
		// 第三份父节点为:a[2] 左节点为:a[5] 右结点为:a[6]

		public static void buildMaxHeapify(int a[]) {
			System.out.println("字符串的长度为:" + a.length);
			int startIndex = getParentIndex(a.length - 1);
			for (int i = startIndex; i >= 0; i--) {
				maxHeapify(a, a.length, i);
			}
		}

		/**
		 * 
		 * @param a
		 *            数组
		 * @param length
		 *            数据长度
		 * @param index
		 *            当前的父节点
		 */
		private static void maxHeapify(int[] a, int length, int index) {
			// 与当前左右结点进行比较
			int left = getChildLeftIndex(index);
			int right = getChildRightIndex(index);

			// 进行左右节点值的对比
			int largest = index;
			if (left < length && a[left] > a[index]) {
				largest = left;
			}
			if (right < length && a[right] > a[largest]) {
				largest = right;
			}
			if (largest != index) {
				int temp = a[index];
				a[index] = a[largest];
				a[largest] = temp;
				// 整理节点
				maxHeapify(a, length, largest);
			}
		}

		// 父节点的位置
		private static int getParentIndex(int i) {
			return i / 2;
		}

		// 左孩子的位置
		private static int getChildLeftIndex(int index) {
			return index * 2 + 1;
		}

		// 右孩子的位置
		private static int getChildRightIndex(int index) {
			return index * 2 + 2;
		}

		/**
		 * 这个函数的含义就是： 将排好的最大堆的堆顶和最后一个交换再进行最大堆排序 排序：最大值放在末尾，再次进行排序
		 * 
		 * @param a
		 */
		public static void heapSort(int a[]) {
			for (int i = a.length - 1; i > 0; i--) {
				int temp = a[0];
				a[0] = a[i];
				a[i] = temp;
				maxHeapify(a, i, 0);
			}
		}
	}

	/**
	 * 5.冒泡排序 两两交换，每次找出剩下元素中的最大值 时间复杂度O(n^2)
	 */
	private static class BubbleSort {

		//简单的冒泡排序
		public static void bubbleSort_A(int a[]) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length-i- 1; j++) {
					if (a[j] > a[j + 1]) {
						Swap(a, j, j + 1);
					}
				}
			}
		}
		
		//改进的冒泡，添加了标记
		public static void bubbleSort_B(int a[]){
			int n = a.length-1;
			while(n>0){
				int pos = 0;
				for (int i = 0; i < n; i++) {
					if(a[i]>a[i+1]){
						pos = i;
						Swap(a, i, i+1);
					}
				}
				n = pos;
			}
		}
	}
	
	
	/**
	 * 6.快速排序
	 * 时间复杂度:O(nlogn)
	 * 空间复杂度:O(nlogn)
	 */

	private static class QuickSort{
		public static void quickSort(int a[],int low,int high){
			if(low<high){
				int privotLoc = partition(a,low,high);
				quickSort(a, low, privotLoc-1);
				quickSort(a, privotLoc+1, high);
			}
		}
		
		private static int partition(int[] a, int low, int high) {
			int privotKey = a[low];
			while(low<high){
				while(low<high && a[high]>=privotKey)--high;//从后半部分向前扫描
				a[low] = a[high];
				while(low<high && a[low]<=privotKey)++low; //从前部分扫描
				a[high] = a[low];
			}
			a[high] = privotKey;
			return low;
		}
	}

	/**
	 * 7.归并排序
	 * @param args
	 */
	private static class MergerSort{
		
		public static void mergerSort(int a[],int left,int right){
			if(left>=right)return;
			int mid = (left+right)/2;
			mergerSort(a, left, mid);
			mergerSort(a, mid+1, right);
			merger(a,left,mid,right);
		}

		private static void merger(int[] a, int left, int mid, int right) {
			int tempArr[] = new int[a.length];
			int center = mid+1;
			int third = left;
			int tmp = left;
			while(left<=mid && center<=right){
				if(a[left]<=a[center]){
					tempArr[third++] = a[left++];
				}
				else {
					tempArr[third++] = a[center++];
				}
			}
	        while (center <= right) {  
	        	tempArr[third++] = a[center++];  
	        }  
	        while (left <= mid) {  
	        	tempArr[third++] = a[left++];  
	        }  
	        // 将临时数组中的内容拷贝回原数组中  
	        // （原left-right范围的内容被复制回原数组）  
	        while (tmp <= right) {  
	            a[tmp] = tempArr[tmp++];  
	        } 
		}
	}
	
	
	
	public static void main(String[] args) {
//		 int a[] ={9,8,7,6,4,5,2,1};
		int a[] = createRundom();
		System.out.println("排序之前:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		// //1.测试直接插入算法
		// insertSort(a);
		//
		// //2.测试希尔排序
		// shellSort(a);
		//
		// //3.测试选择排序
		// selectSort(a);

		// 4.测试堆排序
		// new HeapSort(a);

		// 5.测试冒泡排序
		// *1.
		BubbleSort.bubbleSort_A(a);
//		BubbleSort.bubbleSort_B(a);
		
		//6.测试快速排序
//		QuickSort.quickSort(a, 0, a.length-1);
		
		//7.测试归并排序
//		MergerSort.mergerSort(a, 0, a.length-1);
		
		System.out.println("");
//		System.out.println("****7.归并排序之后:****");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		
	}
	
	
	/**
	 * 生成随机字符串
	 * 
	 * @return
	 */
	private static int[] createRundom() {
		int length = (int) (Math.random() * 20 + 5);
		int a[] = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = (int) (Math.random() * 100 + 1);
		}
		return a;
	}

	// 交换
	public static int[] Swap(int a[], int i, int j) {
		int temp = 0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}
	
}
