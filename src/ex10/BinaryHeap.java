package ex10;

import java.util.Arrays;

public class BinaryHeap {
	private int[] heap;
	private int currentSize;
	private int capacity = 5;

	public BinaryHeap(int[] seq, int type) {
		//typeֻ��������������һ�����췽��
		heap = seq.clone();
		currentSize = seq.length;
		capacity = currentSize;
		for (int i = currentSize / 2 - 1; i >= 0; i--) {
			// �����һ����Ҷ�ӽڵ㿪ʼ���������Ǵ�0��ʼ�ģ���ô����n/2-1
			// �������Ǵ�1��ʼ�ģ���ô���һ������Ҷ�ڵ����n/2
			int left = (i * 2 + 1 < currentSize) ? heap[i * 2 + 1] : -1;
			int right = (i * 2 + 2 < currentSize) ? heap[i * 2 + 2] : -1;
			if (left < right && left != -1) {
				if (heap[i] > left) {
					int temp = heap[i];
					heap[i] = left;
					heap[i * 2 + 1] = temp;
				}
			} else if (left > right && right != -1) {
				if (heap[i] > right) {
					int temp = heap[i];
					heap[i] = right;
					heap[i * 2 + 2] = temp;
				}
			}
		}
	}

	public void check() {

	}

	public BinaryHeap(int[] seq) {
		currentSize = 0;
		heap = new int[capacity];
		for (int i = 0; i < seq.length; i++) {
			insert(seq[i]);
		}
	}

	public void insert(int x) {
		resize();
		heap[currentSize] = x;
		currentSize += 1;
		percolateDown();
	}

	public void resize() {
		if (currentSize == capacity) {
			capacity = capacity * 2;
			heap = Arrays.copyOf(heap, capacity);
		} else if (currentSize < capacity / 4) {
			capacity = capacity / 4;
			heap = Arrays.copyOf(heap, capacity);
		}
	}

	public void percolateDown() {
		for (int i = currentSize - 1; i >= 0; i--) {
			int j = i;
			do {
				j = (j - 1) / 2;
				if (heap[j] > heap[i]) {
					int exchange = heap[j];
					heap[j] = heap[i];
					heap[i] = exchange;
				}
			} while (j != 0);
		}
	}

	public int deleteMin() {
		if (capacity == 0) {
			return -1;
		} else {
			int min = heap[0];
			heap[0] = heap[currentSize - 1];
			heap[currentSize - 1] = 0;
			currentSize -= 1;
			percolateDown();
			resize();
			return min;
		}
	}

	public int[] sortHeap() {
		int c = currentSize;
		int[] sort = new int[c];
		for (int i = 0; i < c; i++) {
			sort[c - 1 - i] = deleteMin();
		}
		return sort;
	}

	public static void main(String[] args) {
		int[] t = { 45, 36, 18, 53, 72, 30, 48, 93, 15, 35 };
		BinaryHeap b = new BinaryHeap(t, 1);
		System.out.println(Arrays.toString(t));
		System.out.println(Arrays.toString(b.heap));
		BinaryHeap c = new BinaryHeap(t);
		System.out.println(Arrays.toString(c.heap));
		b.insert(16);
		System.out.println(Arrays.toString(b.heap));
		b.deleteMin();
		System.out.println(Arrays.toString(b.heap));
		System.out.println(Arrays.toString(b.sortHeap()));

	}
}