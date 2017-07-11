package ex11demo;


public class ChildNode{
	private int child;
	private ChildNode next;
	
	public ChildNode(int child, ChildNode next){
		this.child = child;
		this.next = next;
	}
	
	public void setNext(ChildNode CL){
		this.next = CL;
	}
	
	public ChildNode next(){
		return this.next;
	}
	
	public int  child(){
		return this.child;
	}
	
}
