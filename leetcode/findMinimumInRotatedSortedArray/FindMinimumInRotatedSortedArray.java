/**
 * Author : Zhaolong Zhong
 * Date   : Feb 12, 2015 5:21:17 PM
 * Problem:
 * Find Minimum in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element. You may assume no duplicate exists in the array.
 */
package findMinimumInRotatedSortedArray;
import java.util.Arrays;
public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] num) {
    if (num.length == 1) return num[0];
    if (num.length == 2) return Math.min(num[0], num[1]);
    
    int l = 0;
    int r = num.length;
    int m = (l + r) / 2;
    
    // l < m < r
    
    if (num[l] < num[m] && num[m] < num[r - 1]) {
      return num[l];
    }
    
    // l < m > r
    if (num[l] < num[m] && num[m] > num[r - 1]) {
      return findMin(Arrays.copyOfRange(num, m, r));
    }
    
    // l > m < r
    return findMin(Arrays.copyOfRange(num, l, m + 1));
  }
}
