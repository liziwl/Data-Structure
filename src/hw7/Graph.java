package hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
	private List<Vertex> vertexs;// 点集
	private int[][] edges;// 邻接矩阵
	private Queue<Vertex> unVisited;

	public Graph(List<Vertex> vertexs, int[][] edges) {
		this.vertexs = vertexs;
		this.edges = edges;
		initUnVisited();
	}

	// 搜索各顶点最短路径
	public void search() {
		while (!unVisited.isEmpty()) {
			Vertex vertex = unVisited.element();
			vertex.setMarked(true);// 顶点已经计算出最短路径，设置为"已访问"
			List<Vertex> neighbors = getNeighbors(vertex);// 获取所有"未访问"的邻居
			updatesDistance(vertex, neighbors);// 更新邻居的最短路径
			pop();
		}
		System.out.println("search over");
	}

	// 更新[所有]邻居的最短路径
	private void updatesDistance(Vertex vertex, List<Vertex> neighbors) {
		for (Vertex neighbor : neighbors) {
			updateDistance(vertex, neighbor);
		}
	}

	// 更新邻居的最短路径
	private void updateDistance(Vertex vertex, Vertex neighbor) {
		int distance = getDistance(vertex, neighbor) + vertex.getPath();
		if (distance < neighbor.getPath()) {
			neighbor.setPath(distance);
			neighbor.setPreVertex(vertex);
		}
	}

	// 初始化未访问顶点集合
	private void initUnVisited() {
		unVisited = new PriorityQueue<Vertex>();
		for (Vertex v : vertexs) {
			unVisited.add(v);
		}
	}

	// 从未访问顶点集合中删除已找到最短路径的节点
	private void pop() {
		unVisited.poll();
	}

	// 获取顶点到目标顶点的距离
	private int getDistance(Vertex source, Vertex destination) {
		int sourceIndex = vertexs.indexOf(source);
		int destIndex = vertexs.indexOf(destination);
		return edges[sourceIndex][destIndex];
	}

	// 获取顶点所有未访问的邻居
	private List<Vertex> getNeighbors(Vertex v) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		int position = vertexs.indexOf(v);
		Vertex neighbor = null;
		int distance;
		for (int i = 0; i < vertexs.size(); i++) {
			if (i == position) {
				// 顶点本身，跳过
				continue;
			}
			distance = edges[position][i]; // 到所有顶点的距离
			if (distance < Integer.MAX_VALUE) {
				// 是邻居(有路径可达)
				neighbor = getVertex(i);
				if (!neighbor.isMarked()) {
					// 如果邻居没有访问过，则加入list;
					neighbors.add(neighbor);
				}
			}
		}
		return neighbors;
	}

	// 根据顶点位置获取顶点
	private Vertex getVertex(int index) {
		return vertexs.get(index);
	}

	// 打印图
	public void printGraph() {
		int verNums = vertexs.size();
		for (int row = 0; row < verNums; row++) {
			for (int col = 0; col < verNums; col++) {
				if (Integer.MAX_VALUE == edges[row][col]) {
					System.out.print("X");
					System.out.print(" ");
					continue;
				}
				System.out.print(edges[row][col]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public void printVertex() {
		System.out.printf("%s\t%s\t%s\n", "Var", "Path length","Path");
		for (Vertex v : vertexs) {
			System.out.printf("%s\t%s\t\t%s\n", v.getName(), v.getPath(),Vertex.printPrePath(v));
		}
	}
}
