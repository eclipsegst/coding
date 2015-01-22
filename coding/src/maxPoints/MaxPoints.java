package maxPoints;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/*
 * Date: 01/21/2015 20:30
 * Problem:
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 */
class Point {
  int x;
  int y;
  Point() {
    x = 0;
    y = 0;
  }
  Point(int a, int b) {
    x = a;
    y = b;
  }
}

public class MaxPoints {
  public static void main(String[] args) {
    Point p0 = new Point();
    Point p1 = new Point(1,1);
    Point p2 = new Point(2,2);
    Point p3 = new Point(3,3);
    Point p4 = new Point(1,2);
    Point p5 = new Point(2,4);
    Point p6 = new Point(3,6);
    Point p7 = new Point(4,8);
    
    Point [] arr = {p0,p1,p2,p3,p4,p5,p6,p7};
    
    int res = maxPoints (arr);
    System.out.println(res);
    
  }
  
  public static int maxPoints(Point [] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    int max = 0;
    HashMap<Double, Integer> map = new HashMap<Double, Integer>();
    for (int i=0; i<points.length; i++) {
      map.clear();
      map.put((double)Integer.MIN_VALUE,1);
      int dup = 0;
      for (int j=i+1; j<points.length; j++) {
        if (points[j].x == points[i].x && points[j].y == points[i].y){
          dup++;
          continue;
        }
        
        double key = points[j].x - points[i].x == 0? Integer.MAX_VALUE:0.0 + (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
        if (map.containsKey(key)) {
          map.put(key, map.get(key) + 1);
        } else {
          map.put(key, 2);
        }
      }
      
      for (int temp : map.values()) {
        if (temp + dup > max) {
          max = temp + dup;
        }
      }
    }
    
    return max;
  }
}
