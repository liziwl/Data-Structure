package ex11;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	private TreeNode tree[];//������ڵ��˳���
	private int num; //�ڵ����
	private int root; //���ڵ�λ������
	private int cap; //���ڵ�����
	
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
		//�������ڵ�
		Tree t =new Tree(20);
		TreeNode NodeA = new TreeNode('A',null);
		TreeNode NodeD = new TreeNode('D',null);
		TreeNode NodeE = new TreeNode('E',null);
		//�����ڵ��������ṹ��
		t.tree[0] = NodeA;
		t.tree[3] = NodeD;
		t.tree[5] = NodeE;
		//�����ӽڵ㣬���������������ڵ���ӽڵ�����
		NodeA.setChildList(new ChildNode(3,new ChildNode(5,null)));

	}

}
