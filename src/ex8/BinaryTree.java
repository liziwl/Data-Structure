package ex8;

public class BinaryTree {
	private Node root;// ���ڵ�

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	//������ȱ���
	public void BreadthFirstTraverse() {
		Sequeue_Node seq = new Sequeue_Node(100);
		seq.enQueue(this.getRoot());
		while (!seq.isEmpty()) {
			Node temp = seq.deQueue();
			System.out.printf("%s ", temp.getData());
			if (temp.getLeftChild() != null)
				seq.enQueue(temp.getLeftChild());
			if (temp.getRightChild() != null)
				seq.enQueue(temp.getRightChild());
		}
	}
	
	//ǰ���ݹ�
	public void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.printf("%s ", node.getData());
		preOrderTraverse(node.getLeftChild());
		preOrderTraverse(node.getRightChild());
	}
	
	//�и��ݹ�
	public void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.getLeftChild());
		System.out.printf("%s ", node.getData());
		inOrderTraverse(node.getRightChild());
	}
	
	//����ݹ�
	public void postOrderTraverse(Node node) {
		if (node == null)
			return;
		postOrderTraverse(node.getLeftChild());
		postOrderTraverse(node.getRightChild());
		System.out.printf("%s ", node.getData());
	}
	//�и��ǵݹ�
	public void inOrderTraverse2(Node node) {
		Stack_Node st = new Stack_Node(100);
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
	//ǰ���ǵݹ�
	public void preOrderTraverse2(Node node) {
		Stack_Node st = new Stack_Node(100);
		Node temp = node;
		while (!st.isEmpty() || temp != null) {
			while (temp != null) {
				System.out.printf("%s ", temp.getData());
				st.push(temp);
				temp = temp.getLeftChild();
			}
			if (!st.isEmpty()) {
				temp = st.pop().getRightChild();
			}
		}
	}
	//����ǵݹ�
	public void postOrderTraverse2(Node node) {
		Stack_Node st = new Stack_Node(100);
		Node curr = node;
		Node pre = null;
		st.push(curr);
		while (!st.isEmpty()) {
			curr = st.top();
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

		BinaryTree tree = new BinaryTree(a);
		tree.BreadthFirstTraverse();
		System.out.println();
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