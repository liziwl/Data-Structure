package ex3;

public class Stack_Int {
	protected int capacity;// �����ʵ������
	protected int[] S;// ��������
	protected int top = -1;// ջ��Ԫ�ص�λ��
	// ��ָ����������ջ����

	public Stack_Int(int cap) {
		capacity = cap;
		S = new int[capacity];
	}

	// ����ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return (top < 0);
	}

	public int getSize() {
		return top;
	}
	// ��ջ
	public void push(int obj) throws Exception{
		if(getSize()==capacity)
			throw new Exception("���⣺ջ���");
		S[++top]=obj;
	}

	// ȡջ��Ԫ��
	public int top() throws Exception {
		if(isEmpty())
			throw new Exception("���⣺ջ��");
		return S[top];
	}

	// ��ջ
	public int pop() throws Exception {
		int elem;
		if(isEmpty())
			throw new Exception("���⣺ջ��");
		elem=S[top];
		top--;
		return elem;
	}
}