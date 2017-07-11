package ex5;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueofList {
	private LinkedList<Node> queue;
	private Node front;
	private Node rear;

	public QueueofList() {
		queue = new LinkedList<Node>();
		front = null;
		rear = null;
	}

	public void enQueue(Node in) {
		if (queue.isEmpty()) {
			front = rear = in;
			queue.add(in);
		}else {
			rear=in;
			queue.add(in);
		}
	}
	
	public Node deQueue() {
		Node out =null;
		if (front==null) {
			System.err.println("Queue is empty.");
		}else if (front==rear) {
			out=front;
			front=null;
			rear=null;
			queue.removeFirst();
		}else {
			out=queue.removeFirst();
		}
		return out;
	}
	public Node getHead() {
		Node out=queue.peek();
		return out;
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	public void printQueue() {
			System.out.print("Front to rear:");
			Iterator<Node> iterator=queue.iterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next().getValue()+" ");
			}
	}
	public static void main(String[] args) {
		QueueofList qu= new QueueofList();
		qu.enQueue(new Node('a'));
		qu.enQueue(new Node('b'));
		qu.enQueue(new Node('c'));
		qu.printQueue();
		
	}
}
