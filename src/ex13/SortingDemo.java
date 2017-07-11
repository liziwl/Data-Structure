package ex13;

public class SortingDemo {
	/*
	 * 插入排序
	 * 参数：
	 * A[]:待排序数组
	 */
	public static void InsertionSort(int A[]){
		for(int i = 1; i < A.length; i++){
			if(A[i] < A[i-1]){
				int tmp = A[i];
				int j;
				for(j = i-1; j >= 0 && tmp < A[j] ; j--){
					A[j+1] = A[j];
				}
				A[j+1] = tmp;
			}
		}
	}

	/*
	 * 希尔排序：增量值设置为每次缩小一半
	 * 参数：
	 * A[]:待排序数组
	 * N:初始增量值
	 */
	public static void ShellSort(int A[], int N){
		int i,j,increment;
		for(increment = N; increment > 0; increment /= 2){ //增量值初始为N，之后每次减半
			for(i = increment; i < A.length; i++){
				if(A[i] < A[i-increment]){
					int tmp = A[i];
					for(j = i-increment; j>=0 && tmp < A[j]; j -= increment)
						A[j+increment] = A[j];
					A[j+increment] = tmp;
				}
			}
		}
	}
	
	/*
	 * 冒泡排序
	 * 参数：
	 * A[]:待排序数组
	 */
	public static void BubbleSort(int A[]){
		int n = A.length;
		int temp;
		boolean flag = true;;
		for(int i = 1; i <= n-1; i++){
			flag = true;
			for(int j = 0; j <= n-i-1; j++){//相邻元素作比较
				if(A[j] > A[j+1]){
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					flag = false;
				}
			}
			if(flag)
				break;
		}
	}
	
	/*
	 * 快速排序
	 * 参数：
	 * A[]:待排序数组
	 */
    public static void QuickSort(int[] A) {  
        QSort(A, 0, A.length - 1);  
    }  
	/*
	 * 快速排序递归过程：对A[low...high]进行快速排序
	 */
    private static void QSort(int[] A, int low, int high) {  
    	if(low < high){ //low >= high时递归终止
            int pivotloc = Partition(A, low, high);  
            QSort(A, low, pivotloc - 1);  //对左边子序列进行快排
          	QSort(A, pivotloc + 1, high); //对右边子序列进行快排 
    	}
    }  
	/*
	 * 快排一趟划分过程：将A[low...high]划分为两个子序列，返回值为一趟划分后枢轴(pivotkey)的位置
	 */
    private static int Partition(int[] A, int low, int high) {  
        int pivotkey = A[low];  
        while(low < high){
        	while((low < high) && A[high] >= pivotkey)
        		high--;
        	A[low] = A[high];
        	while((low < high) && A[low] <= pivotkey)
        		low++;
        	A[high] = A[low];
        }
        A[low] = pivotkey;
        return low;  
    }  
	
	/*
	 * 归并排序
	 * 参数：
	 * A[]:待排序数组
	 */ 
    public static void MergeSort(int[] A) {  
        mSort(A, 0, A.length - 1);  
    }  
  
	/*
	 * 归并排序递归过程：对A[low...high]进行快速排序
	 */
    public static void mSort(int[] A, int left, int right) {  
        if (left >= right)  
            return;  
        // 找出中间索引  
        int center = (left + right) / 2;  
        // 对左边数组进行递归  
        mSort(A, left, center);  
        // 对右边数组进行递归  
        mSort(A, center + 1, right);  
        // 合并  
        merge(A, left, center, right);  
    }  
    
    //一趟归并函数
    public static void merge(int[] A, int left, int center, int right) {  
        // 临时数组  
        int[] tmpA = new int[A.length];  
        int rindex = center + 1;    // 右数组第一个元素索引  
        int tindex = left;          // 记录临时数组的索引  
        int lindex = left;          // 缓存左数组第一个元素的索引  
        while (lindex <= center && rindex <= right) {  
            // 从两个数组中取出最小的放入临时数组  
            if (A[lindex] <= A[rindex]) {  
                tmpA[tindex++] = A[lindex++];  
            } else {  
                tmpA[tindex++] = A[rindex++];  
            }  
        }  
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）  
        while (rindex <= right) {  
            tmpA[tindex++] = A[rindex++];  
        }  
        while (lindex <= center) {  
            tmpA[tindex++] = A[lindex++];  
        }  
        // 将临时数组中的内容拷贝回原数组中  
        while (left <= right) {  
            A[left] = tmpA[left++];  
        }  
    } 
    
	/*
	 * 基数排序
	 * 参数：
	 * A[]:待排序数组
	 * radix:基数，即关键字的取值个数
	 * d:关键字位数，对于两位整数，有个数数字和十位数字两个关键字，即d=2
	 */ 
    public static void RadixSort(int[] A, int radix, int d) {  
        // 缓存数组  
        int[] tmp = new int[A.length];  
        // buckets用于记录待排序元素的信息  
        int[] buckets = new int[radix];  
  
        int rate = 1;
        for (int i = 0; i < d; i++) {  
  
        	for(int p = 0; p < radix; p++)
        		buckets[p] = 0;
            // 将data中的元素完全复制到tmp数组中  
            for(int l = 0; l < A.length; l++){
            	tmp[l] = A[l];
            }
  
            // 计算每个待排序数据的关键字 ，统计取值为各关键字的元素个数
            for (int j = 0; j < A.length; j++) {  
                int subKey = (tmp[j] / rate) % radix;  
                buckets[subKey]++;  
            }  
  
            for (int j = 1; j < radix; j++) {  
                buckets[j] = buckets[j] + buckets[j - 1];  
            }  
  
            // 按本轮关键字对指定的数据进行排序  
            for (int m = A.length - 1; m >= 0; m--) {  
                int subKey = (tmp[m] / rate) % radix;  
                A[--buckets[subKey]] = tmp[m];  
            }  
            rate *= radix;  
        }  
    } 
    
    
    
	public static void main(String[] args) {
		int[] A = {5, 3, 8, 4, 7, 6, 10, 17, 12, 11};
		//InsertionSort(A);
		//ShellSort(A,5);
		//BubbleSort(A);
		QuickSort(A);
		//MergeSort(A);
		//RadixSort(A,10,2);
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
	}

}
