package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zhaolong Zhong Jun 25, 2016
 */
public class FindKClosestPoints {

	private static class Point {
		private double x;
		private double y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
		
		public double distanceTo(Point origin) {
			return Math.sqrt((x - origin.getX()) * (x - origin.getX()) + (y - origin.getY()) * (y - origin.getY()));
		}
		
		public String toString() {
			return "x = " + x + ", y = " + y;
		}
	}
	// O(n * log k) for n total points and k closest points
	// since PriorityQueue is implemented by priority heap, log k for insertions and removals operation in queue 
	public Point[] findKClosestPoints(Point[] points, int k, final Point origin) {
		if (points == null || points.length == 0 || points.length < k) {
			return points;
		}
		
		Point[] result = new Point[k];
		
		PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				return b.distanceTo(origin) > a.distanceTo(origin) ? 1 : -1;
			}
		});
		
		for (Point point : points) {
			queue.offer(point);
			
			if (queue.size() > k) {
				queue.poll();
			}
		}
		
		for (int i = 0; i < k; i++) {
			if (!queue.isEmpty()) {
				result[i] = queue.poll();
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		FindKClosestPoints solution = new FindKClosestPoints();
		
		Point origin = new Point(0, 0);
		Point p1 = new Point(1, 1);
		Point p2 = new Point(2, 2);
		Point p3 = new Point(3, 3);
		Point p4 = new Point(4, 4);
		Point p5 = new Point(5, 5);
		
		Point p6 = new Point(-1, 1);
		Point p7 = new Point(1, -1);
		Point p8 = new Point(-1, -1);
		Point p9 = new Point(-2, -2);
		
		Point[] points = new Point[9];
		
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		points[3] = p4;
		points[4] = p5;
		points[5] = p6;
		points[6] = p7;
		points[7] = p8;
		points[8] = p9;
		
		Point[] result = solution.findKClosestPoints(points, 6, origin);
		
		for (Point point : result) {
			System.out.println(point.toString());
		}
	}
}
