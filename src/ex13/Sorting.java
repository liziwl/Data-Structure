package ex13;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorting {
	private static boolean less(int v, int w) {
		return v < w;
	}

	private static boolean large(int v, int w) {
		return v > w;
	}

	private static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static int[] Insertion(int[] s) {
		if (s == null || s.length < 2)
			return s;
		int[] out = s.clone();
		int N = out.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0 && less(out[j], out[j - 1]); j--)
				exch(out, j, j - 1);
		return out;
	}

	public static int[] Shell(int[] s) {
		if (s == null || s.length < 2)
			return s;
		int[] out = s.clone();
		int N = out.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;

		while (h >= 1) { // h-sort the array.
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(out[j], out[j - h]); j -= h)
					exch(out, j, j - h);
			}
			h = h / 3;
		}
		return out;
	}

	public static int[] Bubble(int[] s) {
		if (s == null || s.length < 2)
			return s;
		int[] out = s.clone();
		int N = out.length;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				if (large(out[j], out[j + 1]))
					exch(out, j, j + 1);
			}
		}
		return out;
	}

	public static void Quick(int[] arr) {
		Quick(arr, 0, arr.length - 1);
	}

	public static void Quick(int[] arr, int low, int high) {
		if (arr == null || arr.length < 2)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot < right
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			// When left is not less than pivot or right is not larger than
			// pivot.
			if (i <= j) {
				exch(arr, i, j);
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			Quick(arr, low, j);

		if (high > i)
			Quick(arr, i, high);
	}

	public static void Duplicate(int[] s) {
		Duplicate(s, 0, s.length - 1);
	}

	public static void Duplicate(int[] s, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, gt = hi;
		int v = s[lo];
		int i = lo;
		while (i <= gt) {
			if (s[i] < v)
				exch(s, lt++, i++);
			else if (s[i] > v)
				exch(s, i, gt--);
			else
				i++;
		}
		Duplicate(s, lo, lt - 1);
		Duplicate(s, gt + 1, hi);
	}

	public static int[] Heap(int[] s) {
		if (s == null || s.length < 2)
			return s;
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int N = s.length;
		int[] out = new int[N];
		for (int i = 0; i < N; i++) {
			heap.add(s[i]);
		}
		for (int i = 0; i < N; i++) {
			out[i] = heap.poll();
		}
		return out;
	}

	public static void Merging(int[] s) {
		int[] aux = new int[s.length];
		Merging(s, aux, 0, s.length - 1);
	}

	public static void Merging(int[] s, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		Merging(s, aux, lo, mid);
		Merging(s, aux, mid + 1, hi);
		merge(s, aux, lo, mid, hi);
	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);

		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}

		assert isSorted(a, lo, hi);
	}

	private static boolean isSorted(int[] a, int lo, int hi) {
		for (int i = lo; i < hi - 1; i++) {
			if (large(a[i], a[i + 1]))
				return false;
		}
		return true;
	}

	public static void Radix(int arr[]) {
		// Find the maximum number to know number of digits
		int m = getMax(arr);

		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, exp);
	}

	private static int getMax(int arr[]) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	private static void countSort(int arr[], int exp) {
		int output[] = new int[arr.length]; // output array
		int i;
		int count[] = new int[10];

		// Store count of occurrences in count[]
		for (i = 0; i < arr.length; i++)
			count[(arr[i] / exp) % 10]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = arr.length - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		arr = output;
	}

	public static void main(String[] args) {
		int[] t = { 49, 38, 65, 97, 76, 13, 27, 49 };
		System.out.println(Arrays.toString(t));
		System.out.println(Arrays.toString(Insertion(t)));
		System.out.println(Arrays.toString(Shell(t)));
		System.out.println(Arrays.toString(Bubble(t)));
		int[] quick = t.clone();
		Quick(quick);
		System.out.println(Arrays.toString(quick));
		System.out.println(Arrays.toString(Heap(t)));
		int[] mer = t.clone();
		Merging(mer);
		System.out.println(Arrays.toString(mer));

	}
}
