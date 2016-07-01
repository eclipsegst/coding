package challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jul 1, 2016
 * 
 * Line Reflection
 * 
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 * 
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * 
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 * 
 * Follow up:
 * Could you do better than O(n2)?
 * 
 * Hint:
 * Find the smallest and largest x-value for all points.
 * If there is a line then it should be at y = (minX + maxX) / 2.
 * For each point, make sure that it has a reflected point in the opposite side.
 *
 * Reference:
 * https://leetcode.com/discuss/108319
 * https://leetcode.com/discuss/107675
 */
public class LineReflection {
	public boolean isReflected(int[][] points) {
        if (points == null || points.length < 2) {
        	return true;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        Set<String> set = new HashSet<String>();
        
        for (int[] p : points) {
        	max = Math.max(max, p[0]);
        	min = Math.min(min, p[0]);
        	String str = p[0] + "#" + p[1];
        	set.add(str);
        }
        
        int sum = max + min;
        
        for (int[] p : points) {
        	String str = (sum - p[0]) + "#" + p[1];
        	if (!set.contains(str)) {
        		return false;
        	}
        }
        
        return true;
    }
}
