package power;

public class Power {
  public static void main(String[] args) {
    System.out.println(myPowder(0,0));
  }
  
  public static double myPowder(double x, double y) {
    double res = 0;
    if (x == 0 && y != 0) return 0.0;
    if (y==0) return 1.0;
    if (y==1) return (double)x;
    if (y==2) return (double)x * x;
    if (y>2) {
      if (y%2 == 0) {
        res = Math.pow(x*x, y/2);
      } else {
        res = Math.pow(x*x, y/2)*x;
      }
    }
    return res;
  }
}
