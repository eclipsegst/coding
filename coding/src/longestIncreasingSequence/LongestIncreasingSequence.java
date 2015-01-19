package longestIncreasingSequence;

import java.util.Arrays;

/*
 * Date: 01/18/2015 23:00
 * 
 * Dynamic Programming
 * Fibonacci: 0 1 1 2 3 5 8 13 21 34 55 89 144 
 * 
 * Problem:
 * Find the longest increasing(increasing means one step) sequence in an integer matrix in 4 directions
 * (up down left right), return the sequence
 * For exmaple:
 * {[1,2,3,4],
 *  [8,7,6,5]}
 * The output should be [1,2,3,4,5,6,7,8]
 * 
 * Hints: DP instead of DFS
 * opt[i][j] = max{ opt[i+1][j], opt[i-1][j], opt[i][j+1], opt[i][j-1]} + 1
 * 
 */
public class LongestIncreasingSequence {
  public static void main(String[] args) {
    System.out.println("Fibonacci");
    for(int i=0; i<13; i++) {
      System.out.print(fibonacci(i) + " ");
    }
    System.out.println("\n" + "Fibonacci DP");
    for(int i=0; i<13; i++) {
      System.out.print(fibonacciDP(i) + " ");
    }
  }
  
  
  /*run time: O(2^n)*/
  private static int fibonacci(int x) {
    if (x==0 || x == 1) {
      return x;
    }else{
      return fibonacci(x-1) + fibonacci(x-2);
    }
  }
  
  /*run time: O(n) with DP, just cache the result of each step*/
  static int[] fib = new int[100];
  public static int fibonacciDP(int x){
    if (x==0 || x==1) {
      return x;
    }
    if (fib[x]!=0) {
      return fib[x];
    }
    fib[x] = fibonacciDP(x-1) + fibonacciDP(x-2);
    return fib[x];
  }
}
