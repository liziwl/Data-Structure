package hw4;

public class NodeFCNS {
	private String data;
	private NodeFCNS FirstChild;
	private NodeFCNS NextSibling;

	public NodeFCNS() {
		this("");
	}

	public NodeFCNS(String val) {
		setData(val);
		setFirstChild(null);
		setNextSibling(null);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public NodeFCNS getFirstChild() {
		return FirstChild;
	}

	public void setFirstChild(NodeFCNS firstChild) {
		FirstChild = firstChild;
	}

	public NodeFCNS getNextSibling() {
		return NextSibling;
	}

	public void setNextSibling(NodeFCNS nextSibling) {
		NextSibling = nextSibling;
	}

	public boolean hasChild() {
		if (getFirstChild() == null) {
			return false;
		} else
			return true;
	}

	public void AddNodeAT(NodeFCNS element) {
		NodeFCNS parent = this;
		NodeFCNS key = parent.getFirstChild();
		if (key == null) {
			parent.setFirstChild(element);
		} else {
			while (key.getNextSibling() != null) {
				key = key.getNextSibling();
			}
			key.setNextSibling(element);
		}
	}

	public void DeepPrint(int depth) {
		NodeFCNS key = this;
		print(key, depth);
		if (key.hasChild()) {
			NodeFCNS key2 = key.getFirstChild();
			do {
				key2.DeepPrint(depth + 1);
				key2 = key2.getNextSibling();
			} while (key2 != null);
		}
	}

	public void DeepPrint() {
		DeepPrint(0);
	}

	public static void print(NodeFCNS ele, int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.println(ele.getData());
	}

	public NodeNaive FCNS2Naive() {
		NodeFCNS key = this;
		NodeNaive out = new NodeNaive(key.getData());
		if (key.hasChild()) {
			NodeFCNS key2 = key.getFirstChild();
			do {
				out.addChild(key2.FCNS2Naive());
				key2 = key2.getNextSibling();
			} while (key2 != null);
		}
		return out;
	}

	public static void main(String[] args) {
		NodeFCNS a = new NodeFCNS("A");
		NodeFCNS b = new NodeFCNS("B");
		NodeFCNS c = new NodeFCNS("C");
		NodeFCNS d = new NodeFCNS("D");
		NodeFCNS e = new NodeFCNS("E");
		NodeFCNS f = new NodeFCNS("F");
		NodeFCNS g = new NodeFCNS("G");
		NodeFCNS h = new NodeFCNS("H");
		NodeFCNS i = new NodeFCNS("I");
		NodeFCNS j = new NodeFCNS("J");
		NodeFCNS k = new NodeFCNS("K");
		NodeFCNS l = new NodeFCNS("L");
		NodeFCNS m = new NodeFCNS("M");
		a.AddNodeAT(b);
		a.AddNodeAT(c);
		a.AddNodeAT(d);
		b.AddNodeAT(e);
		b.AddNodeAT(f);
		e.AddNodeAT(k);
		e.AddNodeAT(l);
		c.AddNodeAT(g);
		d.AddNodeAT(h);
		h.AddNodeAT(m);
		d.AddNodeAT(i);
		d.AddNodeAT(j);
		a.DeepPrint();
		a.FCNS2Naive().DeepPrint();

	}
}
