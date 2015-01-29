/**
 * Author : Zhaolong Zhong
 * Date   : Jan 28, 2015 10:48:27 PM
 *
 * Problem:
 * Given an integer n, return the number of trailing zeroes in n!
 * Note: Your solution should be in logarithmic time complexity.
 * Hint: A trailing zero is made of factor 2 and factor 5
 */
package factorialTrailingZeroes;

public class FactorialTrailingZeroes {
  public static void main(String[] args) {
    int n = 1808548329;;
    System.out.println(trailingZeroes(n));
  }
  
  public static int trailingZeroes(int n) {
    int sum=0;
    int tmp=0;
    while(n / 5 > 0)
    {
        tmp = n / 5;
        sum += tmp;
        n = tmp;
    }
    return sum;
  }
  // this solution will get run time limit
  public static int trailingZeroes2(int n) {
    int count = 0;
    int c2 = 0;
    int c5 = 0;
    for(int i=1; i <= n; i++){
      int m = i;
      while(m % 2 == 0){
        c2++;
        m /= 2;
      }
      
      while(m % 5 == 0){
        c5++;
        m /= 5;
      }
      
      int c = Math.min(c2, c5);
      count += c;
      c2 -= c;
      c5 -= c;
    }
    return count;
  }
}
