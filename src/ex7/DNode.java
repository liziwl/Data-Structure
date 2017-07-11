package ex7;

public class DNode {

	private int data;
	private DNode prior;
	private DNode next;

	public DNode(int data, DNode prev, DNode next) {
		this.data = data;
		this.prior = prev;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DNode getPrior() {
		return prior;
	}

	public void setPrior(DNode prior) {
		this.prior = prior;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}
}