package ex5;

import java.util.Iterator;
import java.util.LinkedList;

public class StackofList {
	private LinkedList<Node> stack;
	private Node top;
	
	public StackofList() {
		stack=new LinkedList<Node>();
		top=null;
	}
	public void push(Node in) {
		stack.addFirst(in);
		top=in;
	}
	public Node pop() {
		Node out =stack.removeFirst();
		top=stack.peekFirst();
		return out;
	}
	public Node top() {
		return top;
	}
	public boolean isEmpty() {
		boolean flag=stack.isEmpty();
		return flag;
	}
	public void printStack() {
		System.out.print("Top to bottom:");
		Iterator<Node> iterator=stack.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().getValue()+" ");
		}
	}
	public static void main(String[] args) {
		StackofList st= new StackofList();
		st.push(new Node('a'));
		st.push(new Node('b'));
		st.push(new Node('c'));
		st.printStack();
		
	}
}
