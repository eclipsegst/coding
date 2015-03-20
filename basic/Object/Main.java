/**
 * Author: Zhaolong Zhong
 * Date  : Mar 11, 2015 11:43:14 AM
 *
 */
package Object;

public class Main {
  public static void main(String[] args) {
    RectanglePlus r1 = new RectanglePlus();
    RectanglePlus r2 = new RectanglePlus();
    r1.width = 2;
    r1.height = 3;
    r2.width = 3;
    r2.height = 4;
    System.out.println(r2.isLargerThan(r1));
  }
}
