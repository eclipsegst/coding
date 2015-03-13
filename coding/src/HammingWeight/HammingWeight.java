/**
 * Author: Zhaolong Zhong
 * Date  : Mar 13, 2015 5:48:25 PM
 *
 */
package HammingWeight;

public class HammingWeight {
  public static int hammingWeight(int n) {
    String s = Integer.toBinaryString(n);
    int c = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
          c++;
      }
    }

    return c;
  }
  
  public static void main(String[] args) {
    int n = 11;
    System.out.println(hammingWeight(n));
  }
}
