package challenge;
/*
 * Date: 01/25/2015 21:56
 * 
 * Problem:
 * Reverse digits of an integer.
 * For example, x = 123, return 321; x = -123, return -321
 */
public class ReverseDigitsOfInteger {
  public static void main(String[] args) {
//    int x = -123;
    int x = 1534236469;
    System.out.println(reverse(x));
  }
  public static int reverse(int x) {
    if (x == Integer.MIN_VALUE) return 0;
    if (x < 0) return -reverse(-x);
    int y = 0;
    do {
      // if (y * 10 + x % 10 > Integer.MAX_VALUE) does not work for the case int x = 1534236469;
      if (y > (Integer.MAX_VALUE - x%10)/10) {
        return 0;
      }
      y = y * 10 + x % 10;
      x /= 10;
    } while (x > 0);
    return y;
  }
}
