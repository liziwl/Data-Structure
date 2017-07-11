package hw7;

import java.util.Stack;

public class Vertex implements Comparable<Vertex> {
	private String name;//节点名称
	private int path;// 最短路径长度
	private Vertex preVertex;
	private boolean isMarked;// 节点是否已经出列(是否已经处理完毕)

	public Vertex(String name) {
		setName(name);
		setPath(Integer.MAX_VALUE);// 初始设置为无穷大
		setPreVertex(null);
		setMarked(false);
	}

	public Vertex(String name, int path) {
		setName(name);
		setPath(path);
		setPreVertex(null);
		setMarked(false);
	}

	@Override
	public int compareTo(Vertex ver) {
		return path < ver.path ? -1 : 1;
		// -1当前为最小，1当前不为最小
	}

	public int getPath() {
		return path;
	}

	public void setPath(int path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMarked() {
		return isMarked;
	}

	public void setMarked(boolean b) {
		isMarked = b;
	}

	public Vertex getPreVertex() {
		return preVertex;
	}

	public void setPreVertex(Vertex preVertex) {
		this.preVertex = preVertex;
	}
	
	public static String printPrePath(Vertex v) {
		if (v==null) {
			return null;
		}
		Stack<Vertex> serial =new Stack<Vertex>();
		do {
			serial.push(v);
			v=v.getPreVertex();
		} while (v!=null);
		
		StringBuffer stringBuffer= new StringBuffer();
		while (!serial.isEmpty()) {
			stringBuffer.append(serial.pop().getName()+"->");
		}
		stringBuffer.append("End");
		return stringBuffer.toString();
	}

}