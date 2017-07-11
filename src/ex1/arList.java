package ex1;

import java.util.Arrays;

public class arList {
	public int MAXSIZE = 10; // 顺序表最大长度
	Object[] elem = new Object[MAXSIZE];
	private int currentLength = 0; // 顺序表当前长度

	// 返回顺序表当前长度
	public int currSize() {
		return currentLength;
	}

	// 重新控制大小
	public void reSize() {
		if (currentLength==MAXSIZE) {
			MAXSIZE=MAXSIZE*2;
			elem=Arrays.copyOf(elem, MAXSIZE);
		}
		if (currentLength<MAXSIZE/4) {
			MAXSIZE=MAXSIZE/2;
			elem=Arrays.copyOf(elem, MAXSIZE);
		}
	}
	// 清空顺序表
	public void clear() {
		for (int i = 0; i < currentLength; i++) {
			elem[i] = null;
		}
		currentLength = 0;
	}

	// 判断顺序表是否为空，空则返回true，否则返回false
	public boolean isEmpty() {
		if (currentLength == 0)
			return true;
		else
			return false;
	}

	// 获取顺序表中第i个元素
	public Object get(int i) {
		return elem[i - 1];
	}

	// 移除顺序表第i个元素，第i+1之后的元素都前移一位
	public void remove(int i) {
		for (int k = i - 1; k < currentLength; k++) {
			elem[k] = elem[k + 1];
		}
		currentLength--;
	}

	// 在顺序表末位添加一个元素
	public void insertElement(Object obj) {
		elem[currentLength] = obj;
		currentLength++;
	}

	// 打印顺序表
	public void printList() {
		System.out.print("[");
		for (int i = 0; i < currentLength; i++) {
			System.out.printf("%s", elem[i]);
			if (i != currentLength - 1)
				System.out.print(",");
		}
		System.out.println("]");
	}

	// 返回顺序表容量
	public int maxSize() {
		return MAXSIZE;
	}

	// 在顺序表第i个位置插入一个元素
	public void insertElenmentAT(int i, Object obj) {
		if (i <= 0 || i > currentLength) {
			System.out.print("插入非法。");
		} else {
			for (int k = currentLength; k > i - 1; k--) {
				elem[k] = elem[k - 1];
			}
			elem[i - 1] = obj;
			currentLength++;
		}
	}

	// 右移k位,方法1
	public void moveRight1(int k) {
		int temp = k % currentLength;
		Object[] tempList = new Object[MAXSIZE];
		for (int i = 0; i < temp; i++) {
			tempList[i] = elem[currentLength - temp + i];
		}
		for (int i = temp; i < currentLength; i++) {
			tempList[i] = elem[i - temp];
		}
		elem=tempList;
	}

	// 右移k位,方法2
	public void moveRight2(int k) {
		int times = k % currentLength;
		for (int count = 0; count < times; count++) {
			Object temp = elem[currentLength - 1];
			for (int i = currentLength - 1; i > 0; i--) {
				elem[i] = elem[i - 1];
			}
			elem[0] = temp;
		}
	}
}
