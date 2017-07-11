package ex10;

public class BinaryHeap2 {
	/**
	 * void insert(int x) void deleteMin() sortHeap() sort()
	 */

	private int[] array;
	private int size;

	public BinaryHeap2(int seq[]) {
		this();
		// 保证不会出现下沉不到底情况
		if (seq.length < 20) {
			for (int i = 0; i < seq.length; i++)
				insert(seq[i]);
				size+=1;
			print();
		}else{
			System.out.println("Out of index");
		}
	}

	public BinaryHeap2() {
		array = new int[20];
		size = 0;
	}

	public void insert(int x) {
		if (size < 20) {
			array[size] = x;
			size++;
			sort();
		} else
			return;

	}

	public int deleteMin() {
		// switch array[0] and array[size-1]
		int temp = array[0];
		array[0] = array[size - 1];
		array[size - 1] = 0;
		size--;
		// from up to bottom 只能保证下沉到底
		for (int i = 0; i < size / 2 - 1;) {
			int j = (array[2 * i + 1] < array[2 * i + 2]) ? (2 * i + 1) : (2 * i + 2);
			if (array[i] < array[j])
				break;
			else {
				// switch
				int t = array[i];
				array[i] = array[j];
				array[j] = t;
				i = j;
			}
		}
		return temp;
	}

	// increasing order
	private void sort() {
		int index;
		// bottom to top 只能保证上浮到顶，不能保证下沉到底
		for (int j = size - 1; j > 0; j--) {
			for (int i = size - 1; i > 0; i = index) {
				index = (i - 1) / 2;
				if (array[i] < array[index]) {
					int temp = array[index];
					array[index] = array[i];
					array[i] = temp;
				}
			}
		}

		print();
	}

	// decreasing order
	public void sortHeap() {
		int t = size;
		while (size != 0)
			deleteMin();
		size = t;
		print();
	}

	public void print() {
		for (int i = 0; i < size; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] seq = { 45, 34, 76, 23, 30, 64, 47, 16, 20 };
		BinaryHeap2 h = new BinaryHeap2(seq);
		h.sortHeap();
		h.sortHeap();
	}
}
