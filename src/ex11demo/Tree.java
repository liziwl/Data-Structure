package ex11demo;

public class Tree {

	private TreeNode tree[];
	private int num; //结点个数
	private int root; //根节点位置
	private int cap; //最大结点容量
	
	public Tree(int cap){
		tree = new TreeNode[cap];
		num = -1;
		root = -1;
		cap = cap;
	}
	
	//获取树的根结点
	public TreeNode getRoot(){
		if(root == -1)
			return null;
		else
			return tree[root];
	}
	
	
	public TreeNode getFirstChild(TreeNode node){
		ChildNode cld = node.getChildList();
		if(cld != null){
			return tree[cld.child()];
		}else
			return null;
	}

	//层序遍历树中每个结点
	public void LevelTraverse(){
		SeqQueue queue = new SeqQueue(20);
		TreeNode node = this.getRoot();
		if(node == null)
			System.out.println("The tree is empty");
		else{
			queue.enQueue(node);
			while(!queue.isEmpty()){
				node = queue.deQueue();
				System.out.print(node.getData()+" ");
				ChildNode cld = node.getChildList();
				while(cld != null){
					queue.enQueue(tree[cld.child()]);
					cld = cld.next();
				}
			}
		}
	}
	
	//先根遍历树
	public void RootFirstTraverse(TreeNode root){
		//if(root != null){
			System.out.print(root.getData()+" ");
			ChildNode cld = root.getChildList();
			while(cld != null){
				RootFirstTraverse(tree[cld.child()]);
				cld = cld.next();
			}
		//}
	}
	
	/*
	 * 创建树如下：
	 *            R
	 *   A        B  	   C
	 *D   E		  		   F
	 *					G  H  K
	 */
	public void Create(){
		TreeNode NodeR = new TreeNode('R',null);
		TreeNode NodeA = new TreeNode('A',null);
		TreeNode NodeB = new TreeNode('B',null);
		TreeNode NodeC = new TreeNode('C',null);
		TreeNode NodeD = new TreeNode('D',null);
		TreeNode NodeE = new TreeNode('E',null);
		TreeNode NodeF = new TreeNode('F',null);
		TreeNode NodeG = new TreeNode('G',null);
		TreeNode NodeH = new TreeNode('H',null);
		TreeNode NodeK = new TreeNode('K',null);
		tree[0] = NodeR;
		root = 0;
		num++;
		tree[1] = NodeA;
		tree[2] = NodeB;
		tree[3] = NodeC;
		tree[4] = NodeD;
		tree[5] = NodeE;
		tree[6] = NodeF;
		tree[7] = NodeG;
		tree[8] = NodeH;
		tree[9] = NodeK;
		num = num + 9;
		
		NodeR.setChildList(new ChildNode(1,new ChildNode(2, new ChildNode(3,null))));
		NodeA.setChildList(new ChildNode(4,new ChildNode(5,null)));
		NodeC.setChildList(new ChildNode(6,null));
		NodeF.setChildList(new ChildNode(7,new ChildNode(8, new ChildNode(9,null))));
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree(20);
		tree.Create();
		tree.LevelTraverse();
		System.out.println();
		tree.RootFirstTraverse(tree.getRoot());
	}

}
