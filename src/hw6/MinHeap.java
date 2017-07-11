package hw6;

import java.util.Arrays;

public class MinHeap {
	private int[] heap;
	private int currentSize;
	private int capacity = 5;

	public MinHeap() {
		heap = new int[capacity];
		currentSize = 0;
	}

	public MinHeap(int[] seq) {
		BuildHeap(seq);
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

	public void delete(int index) {
		try {
			heap[index] = heap[currentSize - 1];
			heap[currentSize - 1] = 0;
			currentSize -= 1;
			resize();
			percolateDown();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("³¬³ö¶Ñ·¶Î§");
		}

	}
	
	public void deleteMin() {
		delete(0);
	}

	public MinHeap BuildHeap(int[] seq) {
		MinHeap out = new MinHeap();
		for (int i = 0; i < seq.length; i++) {
			out.insert(seq[i]);
		}
		return out;
	}

	public void insert(int x) {
		resize();
		heap[currentSize] = x;
		currentSize += 1;
		percolateDown();
	}

	public void percolateDown() {
		for (int i = currentSize - 1; i >= 0; i--) {
			int j =i;
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

	public void DecreaseKey(int index, int step) {
		try {
			heap[index] = heap[index] - step;
			percolateDown();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("³¬³ö¶Ñ·¶Î§");
		}
	}

	public void IncreaseKey(int index, int step) {
		try {
			heap[index] = heap[index] + step;
			percolateDown();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("³¬³ö¶Ñ·¶Î§");
		}
	}

	public static void main(String[] args) {
		int[] t = { 45, 36, 18, 53, 72, 30, 48, 93, 15, 35 };
		MinHeap b = new MinHeap();
		b = b.BuildHeap(t);
		System.out.println(Arrays.toString(t));
		System.out.println(Arrays.toString(b.heap));
		b.deleteMin();
		System.out.println(Arrays.toString(b.heap));
		b.DecreaseKey(5, 19);
		System.out.println(Arrays.toString(b.heap));
	}
}
