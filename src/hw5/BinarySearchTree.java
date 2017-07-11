package hw5;

public class BinarySearchTree {
	private SearchTree root;

	public BinarySearchTree() {
		setRoot(null);
	}
	
	public void makeEmpty() {
		setRoot(null);
	}
	
	public void printTree(SearchTree r) {
		if (r == null)
			return;
		printTree(r.getLeftChild());
		System.out.printf("%s ", r.getData());
		printTree(r.getRightChild());
	}

	public SearchTree Find(int value, SearchTree n) {
		if (n != null) {
			if (n.getData() == value) {
				return n;
			} 
			if (n.getData()>value) {
				return Find(value, n.getLeftChild());
			} else {
				return Find(value, n.getRightChild());
			}
		} else {
			return null;
		}
	}
	
	public SearchTree FindMin(SearchTree n) {
		if (n==null) {
			return n;
		} else {
			while (n.getLeftChild()!=null) {
				n=n.getLeftChild();
			}
			return n;
		}
	}
	
	public SearchTree FindMax(SearchTree n) {
		if (n==null) {
			return n;
		} else {
			while (n.getRightChild()!=null) {
				n=n.getRightChild();
			}
			return n;
		}
	}

	public boolean searchValue(int value, SearchTree n) {
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
	
	public SearchTree searchValue(int value) {
		SearchTree key = getRoot();
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

	public void Insert(int Value) {
		if (searchValue(Value, getRoot())) {
			System.err.println("����Ƿ�");
		}else {
			SearchTree key = getRoot();
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
				key.setLeftChild(new SearchTree(Value));
			} else {
				key.setRightChild(new SearchTree(Value));
			}
			
		}
	}

	public SearchTree findMin(SearchTree n) {
		SearchTree key = n;
		while (key!=null) {
			if (key.getLeftChild()!=null) {
				key=key.getLeftChild();
			}
			else 
				break;
		}
		return key;
	}

	public SearchTree Delete(int value) {
		SearchTree del = getRoot();
		SearchTree parent=null;
		//���Ҹ��ڵ�
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
			//ɾ���ڵ����ӽڵ�
			if (del.getLeftChild()==null&&del.getRightChild()==null) {
				if (parent.getLeftChild().getData()==del.getData()) {
					parent.setLeftChild(null);
				}else {
					parent.setRightChild(null);
				}
			}
			//ɾ���ڵ�ֻ��left or right �ڵ�
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
			//ɾ���Ľڵ���ӽڵ㶼��Ϊ��(max of left or min of right)
			else {
				SearchTree min=findMin(del.getRightChild());
				//min�϶�û����ڵ�
				Delete(min.getData());
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
	
	public SearchTree getRoot() {
		return root;
	}

	public void setRoot(SearchTree root) {
		this.root = root;
	}
	
	public BinarySearchTree(SearchTree r) {
		setRoot(r);
	}
	
	public BinarySearchTree(int []seq){
		setRoot(new SearchTree(seq[0]));
		for (int i = 1; i < seq.length; i++) {
			Insert(seq[i]);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree a;
		int[] t={35, 17, 18, 15, 22, 60, 51, 88, 93};
		a=new BinarySearchTree(t);
		a.printTree(a.getRoot());
		
		System.out.println();
		a.Delete(60);
		a.printTree(a.getRoot());
		
		
	}
}
