package ex4;

public class PascalTriangle {
	private SuqQueue tri;
	
	public PascalTriangle(){
		this(5);
	}
	
	public PascalTriangle(int max){
		tri=new SuqQueue(max);
		tri.enQueue(0);
		tri.enQueue(1);
		tri.enQueue(1);
		tri.enQueue(0);
	}
	
	public SuqQueue next(){
		SuqQueue temp=new SuqQueue(tri.size()+1);
		temp.enQueue(0);
		int a=tri.deQueue();
		int b=tri.deQueue();
		while (!tri.isEmpty()) {
			int c=a+b;
			temp.enQueue(c);
			a=b;
			b=tri.deQueue();
		}
		temp.enQueue(1);
		temp.enQueue(0);
		return temp;
	}
	
	public void printTri() {
		tri.printQueue();
	}
	public static void main(String[] args) {
		PascalTriangle Triangle=new PascalTriangle();
		Triangle.printTri();
		for(int i=0;i<20;i++){
		Triangle.tri=Triangle.next();
		Triangle.printTri();
		}
	}
}
