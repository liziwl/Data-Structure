package hw3;

import java.util.LinkedList;
import java.util.Queue;

public class QueueofMaze {
	private int[][] maze;

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	};

	public QueueofMaze() {
		this(5, 0.7);
	}

	public QueueofMaze(int size) {
		this(size, 0.7);
	}

	public QueueofMaze(int size, double probability) {
		maze = new int[size][size];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				double flag = Math.random();
				if (flag < probability) {
					maze[i][j] = 0;// 通路
				} else
					maze[i][j] = 1;// 断路
			}
		}
	}

	public void print() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean accessible(Direction dir, Location loc) {
		boolean flag = false;
		int next = 1;
		int row = loc.getRow();
		int column = loc.getColumn();
		try {
			switch (dir) {
			case UP:
				next = maze[row - 1][column];
				break;
			case DOWN:
				next = maze[row + 1][column];
				break;
			case LEFT:
				next = maze[row][column - 1];
				break;
			case RIGHT:
				next = maze[row][column + 1];
				break;
			}
		} catch (Exception e) {
			next = 1;// 到达边界
		}
		switch (next) {
		case 0:// 通路
			flag = true;
			break;
		case 1:// 断路
			flag = false;
			break;
		case 2:// 走过
			flag = false;
			break;
		}
		return flag;
	}

	public Location move(Direction dir, Location loc) {
		Location temp = null;
		switch (dir) {
		case UP:
			temp = new Location(loc.getRow() - 1, loc.getColumn(), loc);
			break;
		case DOWN:
			temp = new Location(loc.getRow() + 1, loc.getColumn(), loc);
			break;
		case LEFT:
			temp = new Location(loc.getRow(), loc.getColumn() - 1, loc);
			break;
		case RIGHT:
			temp = new Location(loc.getRow(), loc.getColumn() + 1, loc);
			break;
		}
		return temp;
	}

	public static void main(String[] args) {
		int size = 8;
		QueueofMaze queue = new QueueofMaze(size);
		queue.print();
		Location rat = new Location(0, 0);
		Location end = new Location(size - 1, size - 1);
		queue.maze[end.getRow()][end.getColumn()] = 0;
		Queue<Location> route = new LinkedList<Location>();
		// 初始化
		route.offer(rat);
		queue.maze[rat.getRow()][rat.getColumn()] = 2;

		while (!route.isEmpty()) {
			rat = route.remove();
			queue.maze[rat.getRow()][rat.getColumn()] = 2;
			boolean flag = (rat.getRow() == end.getRow() && rat.getColumn() == end.getColumn());
			if (flag == true) {
				queue.maze[rat.getRow()][rat.getColumn()] = 6;
				queue.print();
				break;
			}
			if (queue.accessible(Direction.LEFT, rat))
				route.offer(queue.move(Direction.LEFT, rat));
			if (queue.accessible(Direction.DOWN, rat))
				route.offer(queue.move(Direction.DOWN, rat));
			if (queue.accessible(Direction.RIGHT, rat))
				route.offer(queue.move(Direction.RIGHT, rat));
			if (queue.accessible(Direction.UP, rat))
				route.offer(queue.move(Direction.UP, rat));
			queue.print();
		}

		boolean flag = (rat.getRow() == end.getRow() && rat.getColumn() == end.getColumn());
		// 显示轨迹
		do {
			queue.maze[rat.getRow()][rat.getColumn()] = 6;
			rat = rat.getPrecursor();
		} while (rat != null);
		queue.print();
		if (flag == true)
			System.out.println("Above is a step-by-step solution of this maze.");
		else
			System.err.println("This maze don't have a solution.");
	}
}