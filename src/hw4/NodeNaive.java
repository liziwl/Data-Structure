package hw4;

import java.util.ArrayList;

public class NodeNaive {
	private String data;
	ArrayList<NodeNaive> child;
	
	public NodeNaive(String d) {
		setData(d);
		child=new ArrayList<NodeNaive>();
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public NodeNaive[] getChild() {
		return child.toArray(new NodeNaive[child.size()]);
	}
	public void addChild(NodeNaive ele) {
		child.add(ele);
	}
	public boolean hasChild() {
		if (child.size()==0) {
			return false;
		} else
			return true;
	}
	
	public void DeepPrint(int depth) {
		NodeNaive key = this;
		print(key, depth);
		if (key.hasChild()) {
			for (NodeNaive node : key.getChild()) 
				node.DeepPrint(depth+1);
		}
	}

	public void DeepPrint() {
		DeepPrint(0);
	}

	public static void print(NodeNaive ele, int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.println(ele.getData());
	}
	
	public NodeFCNS Naive2FCNS() {
		NodeNaive key = this;
		NodeFCNS out = new NodeFCNS(key.getData());
		if (key.hasChild()) {
			for (NodeNaive nodeNaive : key.getChild()) {
				out.AddNodeAT(nodeNaive.Naive2FCNS());
			}
		}
		return out;
	}
	
	public static void main(String[] args) {
		NodeNaive a = new NodeNaive("A");
		NodeNaive b = new NodeNaive("B");
		NodeNaive c = new NodeNaive("C");
		NodeNaive d = new NodeNaive("D");
		NodeNaive e = new NodeNaive("E");
		NodeNaive f = new NodeNaive("F");
		NodeNaive g = new NodeNaive("G");
		NodeNaive h = new NodeNaive("H");
		NodeNaive i = new NodeNaive("I");
		NodeNaive j = new NodeNaive("J");
		NodeNaive k = new NodeNaive("K");
		NodeNaive l = new NodeNaive("L");
		NodeNaive m = new NodeNaive("M");
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		e.addChild(k);
		e.addChild(l);
		c.addChild(g);
		d.addChild(h);
		h.addChild(m);
		d.addChild(i);
		d.addChild(j);
		a.DeepPrint();
		a.Naive2FCNS().DeepPrint(9);;
	}
	
}
