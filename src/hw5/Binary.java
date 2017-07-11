package hw5;

import java.util.Stack;

public class Binary {
	private Node root;// 根节点

	public Binary() {
		root = null;
	}

	public Binary(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	//前序递归
	public void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.printf("%s ", node.getData());
		preOrderTraverse(node.getLeftChild());
		preOrderTraverse(node.getRightChild());
	}
	//中序递归
	public void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.getLeftChild());
		System.out.printf("%s ", node.getData());
		inOrderTraverse(node.getRightChild());
	}
	//后序递归
	public void postOrderTraverse(Node node) {
		if (node == null)
			return;
		postOrderTraverse(node.getLeftChild());
		postOrderTraverse(node.getRightChild());
		System.out.printf("%s ", node.getData());
	}
	//中序非递归
	public void inOrderTraverse2(Node node) {
		Stack<Node> st=new Stack<Node>();
		Node temp = node;
		while (!st.isEmpty() || temp != null) {
			while (temp != null) {
				st.push(temp);
				temp = temp.getLeftChild();
			}
			if (!st.isEmpty()) {
				temp = st.pop();
				System.out.printf("%s ", temp.getData());
				temp = temp.getRightChild();
			}
		}
	}
	//前序非递归
	public void preOrderTraverse2(Node node) {
		Stack<Node> st=new Stack<Node>();
		Node temp = node;
		while (!st.isEmpty() || temp != null) {
			while (temp != null) {
				System.out.printf("%s ", temp.getData());
				st.push(temp);
				temp = temp.getLeftChild();
			}
			if (!st.isEmpty()) {
				temp = st.pop();
				temp = temp.getRightChild();
			}
		}
	}
	//后序非递归
	public void postOrderTraverse2(Node node) {
		Stack<Node> st=new Stack<Node>();
		Node curr = node;
		Node pre = null;
		st.push(curr);
		while (!st.isEmpty()) {
			curr = st.peek();
			if ((curr.getLeftChild() == null && curr.getRightChild() == null)
					|| (pre != null && (pre == curr.getLeftChild() || pre == curr.getRightChild()))) {
				System.out.printf("%s ", curr.getData());
				st.pop();
				pre = curr;
			} else {
				if (curr.getRightChild() != null)
					st.push(curr.getRightChild());
				if (curr.getLeftChild() != null)
					st.push(curr.getLeftChild());
			}
		}
	}

	public static void main(String[] args) {
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		Node e = new Node('E');
		Node f = new Node('F');
		Node g = new Node('G');
		Node h = new Node('H');
		Node i = new Node('I');
		Node j = new Node('J');
		Node l = new Node('L');

		a.setLeftChild(b);
		a.setRightChild(c);
		b.setLeftChild(d);
		b.setRightChild(e);
		d.setLeftChild(h);
		d.setRightChild(i);
		e.setLeftChild(j);
		c.setLeftChild(f);
		c.setRightChild(g);
		f.setLeftChild(l);

		Binary tree = new Binary(a);
		tree.preOrderTraverse(a);
		System.out.println();
		tree.inOrderTraverse(a);
		System.out.println();
		tree.postOrderTraverse(a);
		System.out.println();

		tree.preOrderTraverse2(a);
		System.out.println();
		tree.inOrderTraverse2(a);
		System.out.println();
		tree.postOrderTraverse2(a);
		System.out.println();

	}
}