package challenge;
/*
 * Date: 2015-01-27 22:45
 * Problem:
 * Implement pow(x, n)
 * 
 */
public class Pow {
  public static void main(String[] args) {
    System.out.println(pow(2,4));
  }
  
  public static double pow(double x, int n) {
    if (n == 0) return 1;
    
    double s = pow(x, n/2);
    
    if ( n % 2 == 0) {
      return s * s;
    } else if ( n > 0) {
      return s * s * x;
    } else {
      return s * s / x;
    }
  }
}