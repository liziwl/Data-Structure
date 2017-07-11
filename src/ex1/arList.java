package ex1;

import java.util.Arrays;

public class arList {
	public int MAXSIZE = 10; // ˳�����󳤶�
	Object[] elem = new Object[MAXSIZE];
	private int currentLength = 0; // ˳���ǰ����

	// ����˳���ǰ����
	public int currSize() {
		return currentLength;
	}

	// ���¿��ƴ�С
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
	// ���˳���
	public void clear() {
		for (int i = 0; i < currentLength; i++) {
			elem[i] = null;
		}
		currentLength = 0;
	}

	// �ж�˳����Ƿ�Ϊ�գ����򷵻�true�����򷵻�false
	public boolean isEmpty() {
		if (currentLength == 0)
			return true;
		else
			return false;
	}

	// ��ȡ˳����е�i��Ԫ��
	public Object get(int i) {
		return elem[i - 1];
	}

	// �Ƴ�˳����i��Ԫ�أ���i+1֮���Ԫ�ض�ǰ��һλ
	public void remove(int i) {
		for (int k = i - 1; k < currentLength; k++) {
			elem[k] = elem[k + 1];
		}
		currentLength--;
	}

	// ��˳���ĩλ���һ��Ԫ��
	public void insertElement(Object obj) {
		elem[currentLength] = obj;
		currentLength++;
	}

	// ��ӡ˳���
	public void printList() {
		System.out.print("[");
		for (int i = 0; i < currentLength; i++) {
			System.out.printf("%s", elem[i]);
			if (i != currentLength - 1)
				System.out.print(",");
		}
		System.out.println("]");
	}

	// ����˳�������
	public int maxSize() {
		return MAXSIZE;
	}

	// ��˳����i��λ�ò���һ��Ԫ��
	public void insertElenmentAT(int i, Object obj) {
		if (i <= 0 || i > currentLength) {
			System.out.print("����Ƿ���");
		} else {
			for (int k = currentLength; k > i - 1; k--) {
				elem[k] = elem[k - 1];
			}
			elem[i - 1] = obj;
			currentLength++;
		}
	}

	// ����kλ,����1
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

	// ����kλ,����2
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
