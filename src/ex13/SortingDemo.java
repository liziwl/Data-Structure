package ex13;

public class SortingDemo {
	/*
	 * ��������
	 * ������
	 * A[]:����������
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
	 * ϣ����������ֵ����Ϊÿ����Сһ��
	 * ������
	 * A[]:����������
	 * N:��ʼ����ֵ
	 */
	public static void ShellSort(int A[], int N){
		int i,j,increment;
		for(increment = N; increment > 0; increment /= 2){ //����ֵ��ʼΪN��֮��ÿ�μ���
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
	 * ð������
	 * ������
	 * A[]:����������
	 */
	public static void BubbleSort(int A[]){
		int n = A.length;
		int temp;
		boolean flag = true;;
		for(int i = 1; i <= n-1; i++){
			flag = true;
			for(int j = 0; j <= n-i-1; j++){//����Ԫ�����Ƚ�
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
	 * ��������
	 * ������
	 * A[]:����������
	 */
    public static void QuickSort(int[] A) {  
        QSort(A, 0, A.length - 1);  
    }  
	/*
	 * ��������ݹ���̣���A[low...high]���п�������
	 */
    private static void QSort(int[] A, int low, int high) {  
    	if(low < high){ //low >= highʱ�ݹ���ֹ
            int pivotloc = Partition(A, low, high);  
            QSort(A, low, pivotloc - 1);  //����������н��п���
          	QSort(A, pivotloc + 1, high); //���ұ������н��п��� 
    	}
    }  
	/*
	 * ����һ�˻��ֹ��̣���A[low...high]����Ϊ���������У�����ֵΪһ�˻��ֺ�����(pivotkey)��λ��
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
	 * �鲢����
	 * ������
	 * A[]:����������
	 */ 
    public static void MergeSort(int[] A) {  
        mSort(A, 0, A.length - 1);  
    }  
  
	/*
	 * �鲢����ݹ���̣���A[low...high]���п�������
	 */
    public static void mSort(int[] A, int left, int right) {  
        if (left >= right)  
            return;  
        // �ҳ��м�����  
        int center = (left + right) / 2;  
        // �����������еݹ�  
        mSort(A, left, center);  
        // ���ұ�������еݹ�  
        mSort(A, center + 1, right);  
        // �ϲ�  
        merge(A, left, center, right);  
    }  
    
    //һ�˹鲢����
    public static void merge(int[] A, int left, int center, int right) {  
        // ��ʱ����  
        int[] tmpA = new int[A.length];  
        int rindex = center + 1;    // �������һ��Ԫ������  
        int tindex = left;          // ��¼��ʱ���������  
        int lindex = left;          // �����������һ��Ԫ�ص�����  
        while (lindex <= center && rindex <= right) {  
            // ������������ȡ����С�ķ�����ʱ����  
            if (A[lindex] <= A[rindex]) {  
                tmpA[tindex++] = A[lindex++];  
            } else {  
                tmpA[tindex++] = A[rindex++];  
            }  
        }  
        // ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����  
        while (rindex <= right) {  
            tmpA[tindex++] = A[rindex++];  
        }  
        while (lindex <= center) {  
            tmpA[tindex++] = A[lindex++];  
        }  
        // ����ʱ�����е����ݿ�����ԭ������  
        while (left <= right) {  
            A[left] = tmpA[left++];  
        }  
    } 
    
	/*
	 * ��������
	 * ������
	 * A[]:����������
	 * radix:���������ؼ��ֵ�ȡֵ����
	 * d:�ؼ���λ����������λ�������и������ֺ�ʮλ���������ؼ��֣���d=2
	 */ 
    public static void RadixSort(int[] A, int radix, int d) {  
        // ��������  
        int[] tmp = new int[A.length];  
        // buckets���ڼ�¼������Ԫ�ص���Ϣ  
        int[] buckets = new int[radix];  
  
        int rate = 1;
        for (int i = 0; i < d; i++) {  
  
        	for(int p = 0; p < radix; p++)
        		buckets[p] = 0;
            // ��data�е�Ԫ����ȫ���Ƶ�tmp������  
            for(int l = 0; l < A.length; l++){
            	tmp[l] = A[l];
            }
  
            // ����ÿ�����������ݵĹؼ��� ��ͳ��ȡֵΪ���ؼ��ֵ�Ԫ�ظ���
            for (int j = 0; j < A.length; j++) {  
                int subKey = (tmp[j] / rate) % radix;  
                buckets[subKey]++;  
            }  
  
            for (int j = 1; j < radix; j++) {  
                buckets[j] = buckets[j] + buckets[j - 1];  
            }  
  
            // �����ֹؼ��ֶ�ָ�������ݽ�������  
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
