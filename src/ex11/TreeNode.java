package ex11;

public class TreeNode{
	private char data; //数据域 存放A、B、C……
	private ChildNode ChildList;//孩子节点域
	
	public TreeNode(char d, ChildNode c) {
		setData(d);
		setChildList(c);
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public ChildNode getChildList() {
		return ChildList;
	}
	public void setChildList(ChildNode childList) {
		ChildList = childList;
	}
	
	
}
