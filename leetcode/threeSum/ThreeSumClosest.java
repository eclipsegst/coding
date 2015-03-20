package threeSum;

import java.util.Arrays;

/*
 * Date: 01/26/2015 20:50
 * 
 * Problem:
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1, 2, 1, -4}.
 * The sum that  is closest to the target is 2. (-1 + 2 + 1= 2).
 */
public class ThreeSumClosest {
  public static void main(String[] args) {
    int[] s = {-1, 2, 1, -4};
    System.out.println(threeSumClosest(s, 2));
  }
  public static int threeSumClosest(int[] num, int target) {
    if (num.length < 3) return 0;
    Arrays.sort(num);
    int mid = 0;
    int last = num.length - 1;
    int closest = num[0] + num[1] + num[2];
    while (mid > 0) {
      while (mid < last) {
        int sum = num[mid];
        sum += num[last];
        for (int i = mid + 1; i < last; i++) {
          if (Math.abs(target - (num[i] + sum)) < Math.abs(target - closest)) {
            closest = num[i] + sum;
          }
        }
        int old = num[mid];
        while ( mid < last && num[mid] == old) mid++;
      }
      mid = 0;
      int old = num[mid];
      while (mid > 0 && num[mid] == old) mid--;
    }
    return closest;
  }
}
