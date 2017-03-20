## 排序算法总结（上）
> * 首先先给自己大三下学期定下一个小目标:找到暑假实习公司。  
> * 因为看了很多学长学姐写的面试经验，觉得数据结构和算法是必问的内容。想想自己对这方面的脑容量为零。   
> * 所以在正式面试之前好好恶补一下！！！

### 1.直接插入算法
* 思路： 默认前面的数据全部都是<b>已经排好</b>的，然后依次将后面的数据插入

* [1.直接插入算法](#直接插入算法)
    * [代码实现](#直接插入代码)
* [2.希尔排序](#希尔排序)
    * [代码实现](#希尔排序代码)
* [3.选择排序](#选择排序)
     * [代码实现](#选择排序代码)
* [4.堆排序](#堆排序)
    * [代码实现](#堆排序代码)
* [5.冒泡排序](#冒泡排序)
    * [代码实现](#冒泡排序代码)
* [6.快速排序](#快速排序)
     * [代码实现](#快速排序代码)    


### <h2 id="直接插入算法">1.直接插入算法<h2>
* 思路： 默认前面的数据全部都是<b>已经排好</b>的，然后依次将后面的数据插入到合适的位置
* 时间复杂度:O(n^2)
* 最佳复杂度：O(n)/已经全部排好

#### <h3 id="直接插入代码">代码实现：</h3>
``` java
    public static void insertSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
			// 注意[0,i-1]都是有序的。如果待插入元素比a[i-1]还大则无需再与[i-1]前面的元素进行比较了，反之则进入if语句
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
```
### <h2 id="希尔排序">2.希尔排序<h2>
* 思路：希尔排序就是将<b>插入排序</b>基础上的将原来的间隔由1变为：(n/2),(n/4),(n/8)...直到n=1;n为数组的长度
* 时间复杂度:O(n^1.3)


#### <h3 id="希尔排序代码">代码实现:</h3>
``` java
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
			dk /= 2; //不断减小间隔
		}
		System.out.println("");
		System.out.println("****2.希尔排序之后****:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}
```

### <h2 id="选择排序">3.选择排序<h2>
* 思路：每次都选择一个最大值放在最后面，选择一个最小值放在前面,(就是将当前的数和后面所有的数比较，找到一个最小的数进行交换)
* 时间复杂度：O(n^2)


#### <h3 id="选择排序代码">代码实现：</h3>
```java
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
```

到合适的位置
* 时间复杂度:O(n^2)
* 最佳复杂度：O(n)/已经全部排好

#### 代码实现：
``` java
    public static void insertSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
			// 注意[0,i-1]都是有序的。如果待插入元素比a[i-1]还大则无需再与[i-1]前面的元素进行比较了，反之则进入if语句
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
```
### 2.希尔排序
* 思路：希尔排序就是将<b>插入排序</b>基础上的将原来的间隔由1变为：(n/2),(n/4),(n/8)...直到n=1;n为数组的长度
* 时间复杂度:O(n^1.3)


#### 代码实现:
``` java
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
			dk /= 2; //不断减小间隔
		}
		System.out.println("");
		System.out.println("****2.希尔排序之后****:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}
```

### 3.选择排序
* 思路：每次都选择一个最大值放在最后面，选择一个最小值放在前面,(就是将当前的数和后面所有的数比较，找到一个最小的数进行交换)
* 时间复杂度：O(n^2)


#### 代码实现：
```java
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
```
<h2 id="堆排序">4.堆排序</h2>
* 思路：堆就是一个完全二叉树（小顶堆），
* 主要解决两个问题:
   * 如何将n个待排序的数构建成堆
   * 输出堆顶元素之后如何调整剩下的n-1个元素，使之成为新的堆
* 时间复杂度:O(nlogn)

<h3 id="堆排序代码">代码实现:</h3>
``` java
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
```

<h2 id="冒泡排序">5.冒泡排序</h2>
* 思路：就是不断的两两比较
* 时间复杂度:O(n^2)

<h3 id="冒泡排序代码">代码实现</h3>
``` java
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
```
<h2 id="快速排序">6.快速排序</h2>
* 思路：
    * 选择一个基准元素
    * 通过一次快排序将待排序数分为两个部分，一部分比基准数小，一部分比基准数大
    * 然后接着对这两部分进行相同的操作，直到序列有序
* 时间复杂度：O(nlogn)
* 空间复杂度: O(nlogn)
<h3 id="快速排序代码">快速排序代码</h3>
``` java
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
```
    

