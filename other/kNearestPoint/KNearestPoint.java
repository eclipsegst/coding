package kNearestPoint;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zhaolong Zhong Nov 23, 2015
 * Time: O(nlog(k)), Space: O(k)
 */
class Point {
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class KNearestPoint {
	public static Point[] getKNearestPoint(Point[] points, Point origin, int k) {
		Point[] res = new Point[k];
		
		PriorityQueue<Point> queue = new PriorityQueue<Point> (k, new Comparator<Point> () {
			@Override
			public int compare(Point a, Point b) {
				return (int) (getDistance(a, origin) - getDistance(b, origin));
			}
		}); 
		
		for (int i = 0; i < points.length; i++) {
			queue.offer(points[i]);
			if (queue.size() > k)
				queue.poll();
		}
		
		int j = 0;
		while (!queue.isEmpty()) {
			res[j++] = queue.poll();
		}
		
		return res;
	}
	
	private static double getDistance(Point a, Point b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
}
