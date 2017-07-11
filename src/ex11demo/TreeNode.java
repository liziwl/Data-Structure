package ex11demo;

public class TreeNode{
	private char data;
	private ChildNode ChildList;
	
	public TreeNode(char data, ChildNode CL){
		this.data = data;
		this.ChildList = CL;
	}
	
	public TreeNode(char data){
		this.data = data;
		this.ChildList = null;
	}
	
	public void setChildList(ChildNode CL){
		this.ChildList = CL;
	}
	
	public ChildNode getChildList(){
		return this.ChildList;
	}
	
	public char getData(){
		return this.data;
	}
	
	public void printCldList(){
		for(ChildNode Cld = this.ChildList; Cld != null; Cld = Cld.next()){
			System.out.print(Cld.child() + " ");
		}
		System.out.println();
	}
}