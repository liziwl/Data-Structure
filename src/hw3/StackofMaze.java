package hw3;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackofMaze {
	private int[][] maze;

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	};

	public StackofMaze() {
		this(5, 0.7);
	}

	public StackofMaze(int size) {
		this(size, 0.7);
	}

	public StackofMaze(int size, double probability) {
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
			temp = new Location(loc.getRow() - 1, loc.getColumn());
			break;
		case DOWN:
			temp = new Location(loc.getRow() + 1, loc.getColumn());
			break;
		case LEFT:
			temp = new Location(loc.getRow(), loc.getColumn() - 1);
			break;
		case RIGHT:
			temp = new Location(loc.getRow(), loc.getColumn() + 1);
			break;
		}
		return temp;
	}

	public static void main(String[] args) {
		int size = 8;
		StackofMaze m = new StackofMaze(size);
		m.print();
		Location rat = new Location(0, 0);
		Location end = new Location(size - 1, size - 1);
		m.maze[end.getRow()][end.getColumn()] = 0;
		Stack<Location> route = new Stack<Location>();
		// 初始化
		route.push(rat);
		m.maze[rat.getRow()][rat.getColumn()] = 2;
		Direction vector = Direction.DOWN;
		try {
			// 判断
			while (rat.getRow() != end.getRow() || rat.getColumn() != end.getColumn()) {
				if (m.accessible(vector, rat)) {
					rat = m.move(vector, rat);
					route.push(rat);
					m.maze[rat.getRow()][rat.getColumn()] = 2;
					m.print();
				} else {
					if (m.accessible(Direction.LEFT, rat)) {
						vector = Direction.LEFT;
						route.push(rat);
					} else if (m.accessible(Direction.RIGHT, rat)) {
						vector = Direction.RIGHT;
						route.push(rat);
					} else if (m.accessible(Direction.DOWN, rat)) {
						vector = Direction.DOWN;
						route.push(rat);
					} else if (m.accessible(Direction.UP, rat)) {
						vector = Direction.UP;
						route.push(rat);
					} else {
						rat = route.pop();
					}
				}
			}
			m.print();

			// 显示轨迹
			do {
				m.maze[rat.getRow()][rat.getColumn()] = 6;
				rat = route.pop();
			} while (!route.isEmpty());
			m.maze[rat.getRow()][rat.getColumn()] = 6;
			m.print();
			System.out.println("Above is a step-by-step solution of this maze.");
		} catch (EmptyStackException e) {
			System.err.println("This maze don't have a solution.");
		}
	}
}
