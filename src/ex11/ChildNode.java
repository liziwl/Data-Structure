package ex11;

public class ChildNode{
	private int child;//��ǰ�ڵ��������нڵ������
	private ChildNode next;//��̺��ӽڵ�
	
	public ChildNode(int child, ChildNode childNode) {
		setChild(child);
		setNext(childNode);
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public ChildNode getNext() {
		return next;
	}
	public void setNext(ChildNode next) {
		this.next = next;
	}
}
