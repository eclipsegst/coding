/**
 * Author: Zhaolong Zhong
 * Date  : 2015 4:50:21 AM
 */
package oop;

public class Adder extends Arithmetic {
  public int x = 0;
  public int y = 0;
  
  public int add(int a, int b) {
    x = a;
    y = b;
    return x + y;
  }
}
