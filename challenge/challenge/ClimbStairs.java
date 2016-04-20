/**
 * Author : Zhaolong Zhong
 * Date   : Jan 28, 2015 8:48:58 PM
 *
 * Problem:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top? 
 */
package challenge;

public class ClimbStairs {
  public static int climbStairs(int n) {
    int[] step = new int[Math.max(n + 1, 3)];
    
    step[0] = 0;
    step[1] = 1;
    step[2] = 2;
    
    for(int i = 3; i <= n; i++){
      step[i] = step[i - 1] + step[i - 2];
    }
    
    return step[n];
  }
  
  public static void main(String[] args) {
    int n = 4;
    System.out.println(climbStairs(n));
  }
}