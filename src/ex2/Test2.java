package ex2;

public class Test2 {
	public static void main(String[] args) {
		LinkList list2=new LinkList(new Node("A"));
		list2.AddNode(new Node("D"));
		list2.AddNode(new Node("F"));
		list2.AddNode(new Node("M"));
		list2.AddNode(new Node("D"));
		list2.AddNode(new Node("G"));
		list2.printLink();
		
		list2.removeWhat("D");
		list2.printLink();
	}
}
