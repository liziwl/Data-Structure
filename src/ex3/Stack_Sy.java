package ex3;

public class Stack_Sy {
	protected int capacity;// �����ʵ������
	protected char[] S;// ��������
	protected int top = -1;// ջ��Ԫ�ص�λ��
	// ��ָ����������ջ����

	public Stack_Sy(int cap) {
		capacity = cap;
		S = new char[capacity];
	}

	// ����ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return (top < 0);
	}

	public int getSize() {
		return top;
	}
	// ��ջ
	public void push(char obj) throws Exception{
		if(getSize()==capacity){
			throw new Exception("���⣺ջ���");}
		S[++top]=obj;
	}

	// ȡջ��Ԫ��
	public char top() throws Exception {
		if(isEmpty())
			throw new Exception("���⣺ջ��");
		return S[top];
	}

	// ��ջ
	public char pop() throws Exception {
		char elem;
		if(isEmpty())
			throw new Exception("���⣺ջ��");
		elem=S[top];
		top--;
		return elem;
	}
}