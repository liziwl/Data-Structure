package ex9;

public class Node {
	Node leftChild;
	Node rightChild;
	int Data;
	
	public Node(int value) {
		setData(value);
		setLeftChild(null);
		setRightChild(null);
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public int getData() {
		return Data;
	}

	public void setData(int data) {
		Data = data;
	}

}
