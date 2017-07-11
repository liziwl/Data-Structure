package ex11;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	private TreeNode tree[];//存放树节点的顺序表
	private int num; //节点个数
	private int root; //根节点位置索引
	private int cap; //最大节点容量
	
	public Tree(int cap){
		tree = new TreeNode[cap];
		num = -1;
		root = -1;
		this.cap = cap;
	}
	
	public void levelTraversal(int rt) {
		LinkedList<TreeNode> queue;
		if (tree[rt]==null) {
			return;
		}else {
			queue =new LinkedList<TreeNode>();
			queue.addLast(tree[rt]);
		}
		
	}
	
	public static void main(String[] args) {
		//创建树节点
		Tree t =new Tree(20);
		TreeNode NodeA = new TreeNode('A',null);
		TreeNode NodeD = new TreeNode('D',null);
		TreeNode NodeE = new TreeNode('E',null);
		//将树节点存放在树结构中
		t.tree[0] = NodeA;
		t.tree[3] = NodeD;
		t.tree[5] = NodeE;
		//创建子节点，并将其连接在树节点的子节点域上
		NodeA.setChildList(new ChildNode(3,new ChildNode(5,null)));

	}

}
