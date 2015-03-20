/**
 *  Author: Zhaolong Zhong
 *  Date  : Mar 2, 2015 3:45:28 PM
 *  
 *  Problem: Fibonacci Number
 *  Recursion Solution:
 *  T(n) = T(n - 1) + T(n - 2) + C
 *  T(0) = T(1) = 1
 *  T(n - 1) is about equal to, but actually greater than, T(n - 2)
 *  T(n) = 2T(n - 2) + C    , k = 1 -> lower bound
 *       = 4T(n - 4) + 3C   , k = 2         
 *       = 8T(n - 6) + 7C   , k = 3
 *       = 2^k * T(n - 2k) + (2^k - 1) * C  , k = n/2 when n - 2k = 0
 *       = 2^(n/2) * T(0) + (2^(n/2) - 1) * C
 *       = (1 + C) * 2^(n/2) - C
 *       lower bound is about 2^(n/2) 
 *  Similarly,
 *  T(n) = 2(n - 1) + C ->upper bound
 *       = 2^n * T(0) + (2^n - 1) * C
 *       = (1 + C) * 2^n - C
 *       upper bound is about 2^n
 *  Time complexity: O(2^n)
 *  
 *  Iterative Solution:
 *  Since we save the previous two number, the assignment cost a constant time,
 *  the total time is the sum of each assignment and sum of the previous two numbers.
 *  Time complexity: O(n)     
 */
package chapter_8_recursion;

public class Fibonacci {
  // recursion solution, time complexity: O(2^n)
  static int  fiboRec(int n) {
    if (n < 0) {
      return -1;    // error condition
    } else if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fiboRec(n - 1) + fiboRec(n - 2);
    }
  }
  
  // iteration solution, time complexity: O(n), space complexity: O(1)
  static int fiboIte(int n) {
    if (n < 0) {
      return -1;
    } else if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      int a = 0;
      int b = 1;
      for (int i = 2; i <= n; i++) {
        int c = a + b;
        a = b;
        b = c;
      }
      return b;
    }
  }
  
  public static void main(String[] args) {
    System.out.println(Fibonacci.fiboRec(6));
    System.out.println(Fibonacci.fiboIte(6));
  }
}
