package ex2;

public class LinkListTest {

	public static void main(String[] args) {
		Node n1=new Node("a");
		Node n2=new Node("b");
	    Node n3=new Node("c");
	    Node n4=new Node("d");
	    Node n5=new Node("e");
	    
	    LinkList list=new LinkList(n1);
	    list.AddNode(n2);
	    list.AddNode(n3);
	    list.AddNode(n4);
	    
	    list.printLink();//此时输出：a b c d
	    System.out.println(list.getLength());//此时输出：4
	    
	    list.insertAt(4, n5);
	    list.printLink();//此时输出：a b c e d
	    list.removeAt(2);
	    list.printLink();//此时输出：a c e d
	    
	    list.removeAt(4);
	    list.printLink();


	}

}
