package ex12;

public class Huffman implements Comparable<Huffman> {
	private char var;
	private int weight;
	private String code;
	private Huffman left;
	private Huffman right;
	
	public Huffman() {
		this((char) Character.MIN_CODE_POINT);
	}

	public Huffman(char v) {
		this(v, 0);
	}

	public Huffman(char v, int w) {
		setVar(v);
		setWeight(w);
		setCode("");
		setLeft(null);
		setRight(null);
	}

	@Override
	public int compareTo(Huffman o) {
		if (o.getWeight() == this.getWeight())
			return 0;
		else {
			if (o.getWeight() > this.getWeight()) {
				return -1; // 当前最小
			}
			return 1;
		}
	}

	public char getVar() {
		return var;
	}

	public void setVar(char var) {
		this.var = var;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Huffman getLeft() {
		return left;
	}

	public void setLeft(Huffman left) {
		this.left = left;
	}

	public Huffman getRight() {
		return right;
	}

	public void setRight(Huffman right) {
		this.right = right;
	}

}
