package clhw;

public class MyBinaryInsertionSort {
	public static void main(String[] args) {
		// 待排序的数组
		int[] array = { 1, 0, 2, 5, 3, 4, 9, 8, 10, 6, 7 };
		binaryInsertSort(array);
		// 显示排序后的结果。
		System.out.print("排序后： ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	// Binary Insertion Sort method
	private static void binaryInsertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int low = 0;
			int high = i - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (temp < array[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			for (int j = i; j >= low + 1; j--) {
				array[j] = array[j - 1];
			}
			array[low] = temp;
		}
	}
}