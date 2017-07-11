package ex4;

public class SuqQueue {
	private int mSize;
	private int front;//队头元素
	private int rear;//队尾元素的下一个元素
	private int[] queue;
	
	public SuqQueue (int size) {
		mSize=size;
		queue=new int[size];
		front=0;
		rear=0;
	}
	
	public int size(){
		return mSize;
	}
	public boolean enQueue(int x) {
		if (isFull())
			return false;
		else{
			queue[rear]=x;
			rear=(rear+1)%mSize;
			return true;
		}
	}
	
	public int deQueue() {
		if (isEmpty())
			return 0;
		else{
			int out=queue[front];
			front=(front+1)%mSize;
			return out;
		}
	}
	
	public int peek(int x) {
		if (isEmpty())
			return 0;
		else{
			return queue[front];
		}
	}
	
	public boolean isEmpty() {
		if (rear==front)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if ((rear+1)%mSize==front)
			return true;
		else
			return false;
	}
	
	public void printQueue() {
		int index=front;
		System.out.print("[");
		while ((index+1)%mSize!=front) {
			System.out.print(queue[index]);
			index++;
			if ((index+1)%mSize!=front) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
	public static void main(String[] args) {
		SuqQueue Q=new SuqQueue(5);
		System.out.println(Q.isEmpty());
		Q.isEmpty();
		Q.enQueue(5);
		Q.enQueue(8);
		Q.enQueue(2);
		Q.enQueue(1);
		System.out.println(Q.isFull());
		
		Q.printQueue();
	}
}
