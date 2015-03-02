/**
 * Author: Zhaolong Zhong
 * Date  : Feb 6, 2015 5:30:53 PM
 *
 */
package timeComplexity;

public class Logarithmic {
  static void chopString(String s) {
    if (s.equals(null) || s.equals("")) {
      return;
    }
    
    int len = s.length() / 2;
    
    if (len > 0) {
      System.out.println(s.substring(0, len));
      chopString(s.substring(0, len));
    }
  }
  
  public static void main(String[] args) {
    String s = "abcdefghijklmn";
    chopString(s);
  }
}
