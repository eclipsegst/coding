/**
 * Author: Zhaolong Zhong
 * Date  : 2015 6:28:39 AM
 */
package basic;

import java.util.Scanner;

public class DataTypes {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner stdin = new Scanner(System.in);
    int n = Integer.parseInt(stdin.next());
    for (int i = 0; i < n; i++) {
      String s = stdin.next();
      try { 
        @SuppressWarnings("unused")
        Byte by = Byte.parseByte(s);
        System.out.println(s + " can be fitted in:");
        System.out.println("* byte");
        System.out.println("* short");
        System.out.println("* int");
        System.out.println("* long");
      } catch  (NumberFormatException e) {
        try { 
          @SuppressWarnings("unused")
          short sh = Short.parseShort(s);
          System.out.println(s + " can be fitted in:");
          System.out.println("* short");
          System.out.println("* int");
          System.out.println("* long");
        } catch (NumberFormatException e0) {
          try { 
            @SuppressWarnings("unused")
            int in = Integer.parseInt(s);
            System.out.println(s + " can be fitted in:");
            System.out.println("* int");
            System.out.println("* long");
          } catch (NumberFormatException e1) {
            try { 
              @SuppressWarnings("unused")
              Long lo = Long.parseLong(s);
              System.out.println(s + " can be fitted in:");
              System.out.println("* long");
            } catch (NumberFormatException e2) {
              System.out.println(s + " can't be fitted anywhere.");
            }
          }
        }
      }
    }
  }
}
