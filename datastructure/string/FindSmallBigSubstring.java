/**
 * Author: Zhaolong Zhong
 * Date  : 2015 5:26:35 AM
 */
package string;

import java.util.Scanner;

public class FindSmallBigSubstring {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    
    String str = stdin.next();
    int length = Integer.parseInt(stdin.next());
    
    String min = "z";
    String max = "A";
    String sub = "";
    
    for (int i = 0; i <= str.length() - length; i++) {
      sub = str.substring(i, i + length);
      if (min.compareTo(sub) > 0) {
        min = sub;
      }
      
      if (max.compareTo(sub) < 0) {
        max = sub;
      }
    }
    
    System.out.println(min);
    System.out.println(max);
    
  }
  
}
