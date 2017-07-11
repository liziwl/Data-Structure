package ex7;

public class DLinkedList {
	DNode head; // ͷ���
	int num; // ������

	public DLinkedList() {
		head = new DNode(0, null, null);
		head.setPrior(head);
		head.setNext(head);
	}

	// 1����node��Ϊ���һ�������뵽������
	public void insertLast(DNode node) {
		node.setNext(head);
		node.setPrior(head);
		head.getPrior().setNext(node);
		node.getNext().setPrior(node);
	}

	// 2����node���뵽�������position֮ǰ
	public void insertBefore(DNode node, DNode pos) {
		node.setNext(pos);
		node.setPrior(pos.getPrior());
		pos.getPrior().setNext(node);
		pos.setPrior(node);
	}

	// 3������ָ��keyֵ�Ľ��
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

	// 4����������ɾ��node���
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
