package hw5;

public class SearchTree {
	SearchTree leftChild;
	SearchTree rightChild;
	int Data;
	
	public SearchTree(int value) {
		setData(value);
		setLeftChild(null);
		setRightChild(null);
	}

	public SearchTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(SearchTree leftChild) {
		this.leftChild = leftChild;
	}

	public SearchTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(SearchTree rightChild) {
		this.rightChild = rightChild;
	}

	public int getData() {
		return Data;
	}

	public void setData(int data) {
		Data = data;
	}

}
