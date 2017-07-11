package ex2;

public class LinkList {
	private Node head = null;// ����ͷ�ڵ�
	private Node tail = null;// ����β�ڵ�
	private Node pointer = null;// ��������Ľڵ�

	public LinkList(Node head) {
		this.head=new Node();
		this.head.LinkNext(head);
		tail = head;
	}
	// ������ĩβ��ӽڵ�
	public void AddNode(Node node) {
		tail.LinkNext(node);
		tail = tail.next();
	}
	// ����������
	public int getLength() {
		pointer=head.next();
		int length=0;
		while(pointer!=null){
			length+=1;
			pointer=pointer.next();
		}
		return length;
	}
	// ��ӡ�������е�Ԫ��
	public void printLink() {
		pointer=head.next();
		System.out.print("[");
		while(pointer!=null){
			System.out.print(pointer.getValue()+",");
			pointer=pointer.next();
		}
		System.out.print("]");
	}
	// ������ָ��λ�ò���ڵ�
	public void insertAt(int index, Node node) {
		pointer=head;
		int key=0;
		while(key!=index-1){
			key+=1;
			pointer=pointer.next();
		}
		node.LinkNext(pointer.next());
		pointer.LinkNext(node);
	}
	// ������ָ��λ��ɾ���ڵ�
	public void removeAt(int index) {
		pointer=head;
		int key=0;
		while(key!=index-1){
			key+=1;
			pointer=pointer.next();
		}
		pointer.LinkNext(pointer.next().next());
	}
	// ������ɾ��ָ������
		public void removeWhat(String text) {
			pointer=head.next();
			Node temp =head;
			while(pointer!=null){
				if (pointer.getValue()==text)
				{
					temp.LinkNext(temp.next().next());
					pointer=temp.next();
				}
				temp=temp.next();
				pointer=pointer.next();
			}
		}
}


class Node {
	private Object value;// ֵ
	private Node next;// ��һ���ڵ�

	public Node(Object value) {
		this.value = value;
	}
      public Node() {}
	// ��ȡ��һ���ڵ�
	public Node next() {
		return this.next;
	}
      // ������һ���ڵ�
	public void LinkNext(Node next) {
		this.next = next;
	}
      // ���õ�ǰ�ڵ��ֵ
	public void setValue(Object value) {
		this.value = value;
	}
      // ��ȡ��ǰ�ڵ��ֵ
	public Object getValue() {
		return this.value;
	}
}
