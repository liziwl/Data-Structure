package ex11demo;

public class SeqQueue {

	private int mSize;
	private int front;
	private int rear;
	private TreeNode[] queue;
	
	
	public SeqQueue(int size){
		this.mSize = size;
		queue = new TreeNode[size];
		front = 0;
		rear = 0;
	}


	
	public boolean enQueue(TreeNode x){
		if((rear + 1)% mSize == front) {
			System.out.println("����Ϊ��");
			return false;
		}
		else{
			queue[rear] = x;
			rear = (rear+1)% mSize;
			return true;
		}
	}
	
	public TreeNode deQueue(){
		if(rear == front) {
			System.out.println("����Ϊ��");
			return new TreeNode(' ');
		}
		else{
			TreeNode e = queue[front];
			front = (front+1)% mSize;
			return e;
		}
	}
	
	public int length(){
		return (mSize + rear - front) % mSize;
	}
	
	public TreeNode frontValue(){
		if(length() == 0){
			System.out.println("����Ϊ��");
			return new TreeNode(' ');
		}else
			return queue[front];
	}
	
	public boolean isFull(){
		if( length() == mSize-1)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty(){
		if( length() == 0)
			return true;
		else
			return false;
	}
	
	public void printQueue(){
		if(isEmpty())
			System.out.println("����Ϊ��");
		else{
			int i = front;
			do{
				System.out.print(queue[i]+" ");
				i = (i+1)%mSize;
			}while(i != rear);
			System.out.println();

		}
	}
	public static void main(String[] args) {
		SeqQueue Q = new SeqQueue(5);



	}

}
