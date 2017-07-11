package ex9;

public class BinarySearchTree {
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BinarySearchTree(Node r) {
		setRoot(r);
	}
	
	public BinarySearchTree(int []seq){
		setRoot(new Node(seq[0]));
		for (int i = 1; i < seq.length; i++) {
			insertValue(seq[i]);
		}
	}
	
	public void printTree(Node r) {
		if (r == null)
			return;
		printTree(r.getLeftChild());
		System.out.printf("%s ", r.getData());
		printTree(r.getRightChild());
	}

	public boolean searchValue(int value, Node n) {
		if (n != null) {
			if (n.getData() == value) {
				return true;
			} 
			if (n.getData()>value) {
				return searchValue(value, n.getLeftChild());
			} else {
				return searchValue(value, n.getRightChild());
			}
		} else {
			return false;
		}
	}

	public Node searchValue(int value) {
		Node key = getRoot();
		while (key!=null) {
			if (key.getData()==value) {
				break;
			}
			if (key.getData()>value) {
				key=key.getLeftChild();
			}else {
				key=key.getRightChild();
			}
		}
		return key;
	}

	public void insertValue(int Value) {
		if (searchValue(Value, getRoot())) {
			System.err.println("插入非法");
		}else {
			Node key = getRoot();
			while (key!=null) {
				if (key.getData()>Value) {
					if(key.getLeftChild()!=null){
					key=key.getLeftChild();
					}else
						break;
				}else {
					if(key.getRightChild()!=null){
					key=key.getRightChild();
					}else 
						break;
				}
			}
			if (key.getData()>Value) {
				key.setLeftChild(new Node(Value));
			} else {
				key.setRightChild(new Node(Value));
			}
			
		}
	}

	public Node findMin(Node n) {
		Node key = n;
		while (key!=null) {
			if (key.getLeftChild()!=null) {
				key=key.getLeftChild();
			}
			else 
				break;
		}
		return key;
	}
	//迭代法删除节点
	public Node deleteNode2(int value){
		return deleteNode(value, root);
	}
	
	public Node deleteNode(int value,Node root) {
		if (root==null) {
			System.err.println("The tree is empty!");
			return root;
		}
		
		if(value<root.getData())
			root.setLeftChild(deleteNode(value,root.getLeftChild()));
		else if (value>root.getData())
			root.setRightChild(deleteNode(value, root.getRightChild()));
		else {
			if (root.getLeftChild()!=null&&root.getRightChild()!=null) {
				root.setData(findMin(root.getRightChild()).getData());
				root.setRightChild(deleteNode(root.getData(), root.getRightChild()));
			}else
				root=(root.getLeftChild()!=null)?root.getLeftChild():root.getRightChild();
		}
		return root;
	}
	
	//非迭代法删除节点
	public Node deleteNode(int value) {
		Node del = getRoot();
		Node parent=null;
		//定位节点
		while (del!=null) {
			if (del.getData()==value) {
				break;
			}
			if (del.getData()>value) {
				parent=del;
				del=del.getLeftChild();
			}else {
				parent=del;
				del=del.getRightChild();
			}
		}
		if (del==null) {
			return del;
		}else {
			//删除节点无子节点
			if (del.getLeftChild()==null&&del.getRightChild()==null) {
				if (parent.getLeftChild().getData()==del.getData()) {
					parent.setLeftChild(null);
				}else {
					parent.setRightChild(null);
				}
			}
			//删除节点只有left or right 节点
			else if (del.getLeftChild()==null||del.getRightChild()==null) {
				
				if (del.getLeftChild()!=null) {
					if (parent.getLeftChild().getData()==del.getData()) {
						parent.setLeftChild(del.getLeftChild());
						del.setLeftChild(null);
					} else {
						parent.setRightChild(del.getLeftChild());
						del.setLeftChild(null);
					}
				}else {
					if (parent.getLeftChild().getData()==del.getData()) {
						parent.setLeftChild(del.getRightChild());
						del.setRightChild(null);
					} else {
						parent.setRightChild(del.getRightChild());
						del.setRightChild(null);
					}
				}
			}
			//删除的节点的子节点都不为空(max of left or min of right)
			else {
				Node min=findMin(del.getRightChild());
				//min肯定没有左节点
				deleteNode(min.getData());
				min.setLeftChild(del.getLeftChild());
				del.setLeftChild(null);
				min.setRightChild(del.getRightChild());
				del.setRightChild(null);
				if (parent.getLeftChild().getData()==del.getData()) {
					parent.setLeftChild(min);
				}else
					parent.setRightChild(min);
				
			}
		}
		return del;
	}
	public static void main(String[] args) {
		BinarySearchTree a;
		int[] t={35, 17, 18, 15, 22, 60, 51, 88, 93};
		a=new BinarySearchTree(t);
		a.printTree(a.getRoot());
		
		System.out.println();
		a.deleteNode2(60);
		a.deleteNode(18);
		a.printTree(a.getRoot());
		
		
	}
}
