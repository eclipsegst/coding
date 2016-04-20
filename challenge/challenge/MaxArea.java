/**
 * Author : Zhaolong Zhong
 * Date   : 2015 4:48:59 PM
 * Problem: Container With Most Water
 * Given n non-negative integers a1,a2,..., an, where each represents a point at coordinate(i, ai).
 * n vertical lines are drawn such that the two end points of line i is at (i,ai) and (i,0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * |       |
 * |   |---|
 * |   |---|  |
 * |___|---|__|________>x
 * 
 * Hint:
 * i = 0 -> end, j = end -> i,
 * Say j remains the same, discuss about area height(ha) when i moves to i + 1,
 * case 0: h[i] > h[j] && h[i + 1] < h[j], 
 *         ha_i   = MIN(h[i],h[j]) = h[j]
 *         ha_i+1 = MIN(h[i + 1], h[j]) = h[i + 1]
 *         ha -> smaller
 * case 1: h[i] > h[j] && h[i + 1] > h[j], ha -> same
 * case 2: h[i] < h[j] && h[i + 1] < h[j], ha -> smaller
 * case 3: h[i] < h[j] && h[i + 1] > h[j], ha -> bigger
 * Similarly, when i remains the same
 */
package challenge;

public class MaxArea {
  public int maxArea(int[] height) {
    if (height.length <= 1) return 0; // only less than two points
    
    int s = 0;
    int e = height.length - 1;
    int max = Integer.MIN_VALUE;
    
    while (s < e) {
      // the short part determines how much water can the container holds
      int c = Math.min(height[s],  height[e]) * (e - s); 
      if ( c > max) {
        max = c;
      }
      
      if (height[s] <= height[e]) {
        s++;
      } else {
        e--;
      }
    }
    
    return max;
  }
}
