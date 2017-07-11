package ex2;

public class LinkList {
	private Node head = null;// 链表头节点
	private Node tail = null;// 链表尾节点
	private Node pointer = null;// 遍历链表的节点

	public LinkList(Node head) {
		this.head=new Node();
		this.head.LinkNext(head);
		tail = head;
	}
	// 在链表末尾添加节点
	public void AddNode(Node node) {
		tail.LinkNext(node);
		tail = tail.next();
	}
	// 返回链表长度
	public int getLength() {
		pointer=head.next();
		int length=0;
		while(pointer!=null){
			length+=1;
			pointer=pointer.next();
		}
		return length;
	}
	// 打印链表所有的元素
	public void printLink() {
		pointer=head.next();
		System.out.print("[");
		while(pointer!=null){
			System.out.print(pointer.getValue()+",");
			pointer=pointer.next();
		}
		System.out.print("]");
	}
	// 在链表指定位置插入节点
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
	// 在链表指定位置删除节点
	public void removeAt(int index) {
		pointer=head;
		int key=0;
		while(key!=index-1){
			key+=1;
			pointer=pointer.next();
		}
		pointer.LinkNext(pointer.next().next());
	}
	// 在链表删除指定内容
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
	private Object value;// 值
	private Node next;// 下一个节点

	public Node(Object value) {
		this.value = value;
	}
      public Node() {}
	// 获取下一个节点
	public Node next() {
		return this.next;
	}
      // 链接下一个节点
	public void LinkNext(Node next) {
		this.next = next;
	}
      // 设置当前节点的值
	public void setValue(Object value) {
		this.value = value;
	}
      // 获取当前节点的值
	public Object getValue() {
		return this.value;
	}
}
