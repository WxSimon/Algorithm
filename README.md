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

