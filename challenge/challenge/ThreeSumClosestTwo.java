/**
 * Author : Zhaolong Zhong
 * Date   : 2015 5:03:40 PM
 * Problem:
 * 
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that
 * each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Hint:
 * step 1: fixed end first
 * step 2: fixed start
 * step 3: move middle
 */
package challenge;
import java.util.Arrays;
public class ThreeSumClosestTwo {
  public static int threeSumClosest(int[] num, int target) {
    if(num.length < 3) return 0;
    Arrays.sort(num);
    int s = 0, e = num.length - 1;
    int closes = num[0] + num[1] + num[2];

    while (e > 0) {
        while (s < e) {
            int sum = num[s] + num[e];
            for (int i = s + 1; i < e; i++) {
                if (Math.abs(target -(num[i] + sum)) < Math.abs(target - closes)) {
                  closes = num[i] + sum;
                }
            }
            int same = num[s];
            while(s < e && num[s] == same) s++;
        }
        
        s = 0;
        int same = num[e];
        while(e > 0 && num[e] == same) e--;
    }

    return closes;
  }
  
  public static void main(String[] args) {
    int[] S = {-1, 2, 1, -4};
    System.out.println(threeSumClosest(S, 1));
  }
}
