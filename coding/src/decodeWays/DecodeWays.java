/**
 * Author: Zhaolong Zhong
 * Date  : Jan 28, 2015 3:32:29 PM
 * 
 * Problem:
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L"(12).
 * The number of ways decoding "12" is 2.
 */
package decodeWays;

public class DecodeWays {
  public static int numDecodings(String s) {
    char[] c = s.toCharArray();
    int n = c.length;
    
    if (n == 0) return 0;
    
    int[] step = new int[Math.max(n + 1, 3)];
    step[0] = 1;
    step[1] = 0;
    
    if (c[0] != '0') step[1] = 1;  // n = 1
    
    for(int i = 2; i <= n; i++) {  // n >= 2
      step[i] = 0;
      if (c[i - 1] != '0') step[i] += step[i - 1];
      if (c[i - 2] != '0') {
        if ((c[i - 2] - '0') * 10 + c[i - 1] - '0' <= 26)
          step[i] += step[i - 2];
      }
    }
    return step[n];
  }
  public static void main(String[] args) {
    String s = "1211";
    System.out.println(numDecodings(s)); // 3
  }
}