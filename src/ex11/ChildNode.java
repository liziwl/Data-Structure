package ex11;

public class ChildNode{
	private int child;//当前节点所在树中节点的索引
	private ChildNode next;//后继孩子节点
	
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
