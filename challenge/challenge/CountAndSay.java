/**
 * Author: Zhaolong Zhong
 * Date  : Mar 14, 2015 3:10:09 PM
 *
 */
package challenge;

public class CountAndSay {
  public static String countAndSay(String s) {
    StringBuilder sb = new StringBuilder("");
    char last = s.charAt(0);
    int i = 1, count = 1;
    while (i < s.length()) {
        if (last == s.charAt(i)) {
            count++;
        } else {
            sb.append(count);
            sb.append(last);
            last = s.charAt(i);
            count = 1;
        }
        i++;
    }
    sb.append(count);
    sb.append(last);
    return sb.toString();
  }
  
  public static String countAndSay(int n) {
    String init = "1";
    for (int i = 0; i < n - 1; i++) {
      init = countAndSay(init);
    }
    return init;
  }
  
  public static void main(String[] args) {
    System.out.println(countAndSay(3));
  }
}
