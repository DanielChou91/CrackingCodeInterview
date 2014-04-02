package chapter9;

import java.util.List;
import java.util.ArrayList;

/* Find a path from one position to another on a chessboard,
 * there might be some blocks on the chessboard.
 * the funcion returns all valid paths. */

/* Another version is to judge if there's a path,
 * or in another word, as long as we find a path,
 * the function stops immediately. */
public class RobotFindPath {

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
			return (x == other.x && y == other.y);
		}

		@Override
		public int hashCode() {
			return 31 * x + 31 * y * y;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}

	int width;
	int height;

	public RobotFindPath(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public RobotFindPath() {
		this(0, 0);
	}

	/**
	 * DFS Algorithm to find path
	 * */
	public List<Point> findPathDFS(int width, int height, List<Point> blocks) {
		this.width = width;
		this.height = height;

		List<Point> path = new ArrayList<>();
		List<List<Point>>	allPath = new ArrayList<>();
		findPathDFS(0, 0, blocks, path, allPath);
		System.out.println(allPath);
		return path;
	}

	private boolean findPathDFS(int x, int y, List<Point> blocks,
			List<Point> path, List<List<Point>> set) {
		if (x == width && y == height) {
			path.add(new Point(x, y));
			set.add(path);
			return true;
		}
		if (x > width || y > height) {
			return false;
		}
		//
		if (!isBlock(x, y, blocks)) {
			path.add(new Point(x, y));
			/* this step is very important! */
			List<Point>	dup  =  new ArrayList<>(path);
			boolean b1 = findPathDFS(x + 1, y, blocks, path, set);
			boolean b2 = findPathDFS(x, y + 1, blocks, dup, set);
			if ( b1 || b2 ){
				return true;
			}
		}
		return false;
	}

	private boolean isBlock(int x, int y, List<Point> b) {
		// System.out.println( x + "," + y + ":" + b);
		return b.contains(new Point(x, y));
	}
}
