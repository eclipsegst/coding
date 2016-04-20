/**
 * Author: Zhaolong Zhong
 * Date  : Mar 19, 2015 9:11:13 PM
 * Problem:
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the follwing triangle
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,3,8,1]
 * ]
 * 
 * The mimimum path sum from top to bottom is 13(i.e. 2 + 3 + 5 + 3 = 13).
 * Note: 5 is not adjacent to 1.
 */
package challenge;
import java.util.Arrays;
import java.util.List;


public class MinimumTotalTriangle {
  
  public static int minimumTotal(List<List<Integer>> triangle) {
    final int size = triangle.size();
    if (size == 0) return 0;
    
    int[] s = new int[size];
    int i = 0;
    for (int v : triangle.get(size - 1)) s[i++] = v;
    
    for (i = size - 2; i >= 0; i--) {
      List<Integer> step = triangle.get(i);
      for (int j = 0; j < step.size(); j++) {
        s[j] = Math.min(step.get(j) + s[j],  step.get(j) + s[j + 1]);
      }
    }
    return s[0];
  }
  
  public static void main(String[] args) {
    List<List<Integer>> triangle1 = Arrays.asList(
      Arrays.asList(2),
      Arrays.asList(3,4),
      Arrays.asList(6,5,7),
      Arrays.asList(4,1,8,3)
    );
    
    List<List<Integer>> triangle2 = Arrays.asList(
        Arrays.asList(2),
        Arrays.asList(3,4),
        Arrays.asList(6,5,7),
        Arrays.asList(4,3,8,1)
      );
    
    System.out.println(triangle1.size());
    
    System.out.println(minimumTotal(triangle1));
    
    System.out.println(minimumTotal(triangle2));
  }

}
