package ex7;

public class DLinkedList {
	DNode head; // 头结点
	int num; // 结点个数

	public DLinkedList() {
		head = new DNode(0, null, null);
		head.setPrior(head);
		head.setNext(head);
	}

	// 1、将node作为最后一个结点插入到链表中
	public void insertLast(DNode node) {
		node.setNext(head);
		node.setPrior(head);
		head.getPrior().setNext(node);
		node.getNext().setPrior(node);
	}

	// 2、将node插入到给定结点position之前
	public void insertBefore(DNode node, DNode pos) {
		node.setNext(pos);
		node.setPrior(pos.getPrior());
		pos.getPrior().setNext(node);
		pos.setPrior(node);
	}

	// 3、查找指定key值的结点
	public DNode search(int key) {
		DNode current = head;
		DNode out = null;
		do {
			if (current.getData() == key) {
				out = current;
				break;
			}
			current = current.getNext();
		} while (current != head);
		return out;
	}

	// 4、从链表中删除node结点
	public void remove(DNode node) {
		DNode current = head;
		do {
			if (current.getData() == node.getData()) {
				DNode next = current.getNext();
				current.getPrior().setNext(next);
				next.setPrior(current.getPrior());
				current.setNext(null);
				current.setPrior(null);
				current=next;
			} else
				current = current.getNext();
		} while (current != head);
	}

}
