/**
 * Author : Zhaolong Zhong
 * Date   : Feb 8, 2015 9:24:37 PM
 * Fibonacci number
 */
package fibonacci;

public class Fibonacci {
  // time complexity: O(2^n)
  public static long fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
  }
  
  // time complexity: O(n)
  public static long fibLinear(int n) {
    if (n <= 1) return n;
    long temp = 0, pre = 0, res = 1;
    for (int i = 0; i < n; i++) {
      temp = pre;
      pre = res;
      res += temp;
    }
    return pre;
  }
  
  public static void main(String[] args) {
    System.out.println(fib(4));
    System.out.println(fibLinear(4));
  }
}
