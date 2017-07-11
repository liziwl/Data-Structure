package ex12;

import java.util.PriorityQueue;

public class EncodeHuffman {
	private PriorityQueue<Huffman> heap;
	private int[] count;

	public EncodeHuffman() {
		heap = new PriorityQueue<>();
		count = new int[256];
	}

	public EncodeHuffman(int[] count) {
		heap = new PriorityQueue<>();
		this.count = count;
		int length = count.length;
		// 构造最小堆
		for (int i = 0; i < length; i++) {
			if (count[i] != 0)
				heap.add(new Huffman((char) i, count[i]));
		}
		
		// 构造Huffman Tree
		int size= getSize(count);
		for (int i = 0; i < size-1; i++) {
			Huffman x = heap.poll();
			Huffman y = heap.poll();

			Huffman z = new Huffman();
			z.setLeft(x);
			z.setRight(y);

			if (x == null && y == null)
				z.setWeight(0);
			else if (x != null && y != null)
				z.setWeight(x.getWeight() + y.getWeight());
			else if (x == null && y != null)
				z.setWeight(y.getWeight());
			else // (x!=null&&y==null)
				z.setWeight(x.getWeight());
			heap.add(z);
		}

		// Huffman coding
		Huffman root = heap.peek();
		encoding(root);

	}

	private static int getSize(int[] count) {
		int c=0;
		for (int i = 0; i < count.length; i++) {
			if(count[i]!=0)
				c++;
		}
		return c;
	}

	public static int[] getCharFrequency(String text) {
		int[] c = new int[256];
		for (int i = 0; i < text.length(); i++) {
			c[(int) text.charAt(i)]++;
		}
		return c;
	}

	public static void encoding(Huffman huff) {
		if (huff == null)
			return;
		
		if (huff.getLeft() != null) {
			huff.getLeft().setCode(huff.getCode() + "0");
			encoding(huff.getLeft());
		}

		if (huff.getRight() != null) {
			huff.getRight().setCode(huff.getCode() + "1");
			encoding(huff.getRight());
		}

	}

	public void printHuffman() {
		System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character", "Frequency", "Code");
		Huffman root = heap.peek();
		printHuffman(root);
	}

	public void printHuffman(Huffman node) {
		if (node == null)
			return;
		if (node.getVar() != (char) Character.MIN_VALUE) {
			System.out.printf("%-15s%-15s%-15s%-15s\n", (int) node.getVar(), node.getVar(), node.getWeight(),
					node.getCode());
			printHuffman(node.getLeft());
			printHuffman(node.getRight());
		} else {
			printHuffman(node.getLeft());
			printHuffman(node.getRight());
		}
	}

	public static void main(String[] args) {
		String t = "I still have a dream. It is a dream deeply rooted in the American dream.";
		EncodeHuffman encode = new EncodeHuffman(getCharFrequency(t));
		encode.printHuffman();

	}
}
