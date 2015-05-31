/**
 * Author: Zhaolong Zhong
 * Date  : 2015 5:02:40 AM
 */
package basic;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class BigInteger {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner stdin = new Scanner(new BufferedInputStream(System.in));

    java.math.BigInteger a = new java.math.BigInteger(stdin.next());
    java.math.BigInteger b = new java.math.BigInteger(stdin.next());
    
    java.math.BigInteger sum = java.math.BigInteger.valueOf(0);
    java.math.BigInteger mul = java.math.BigInteger.valueOf(0);
    

    sum = sum.add(a);
    sum = sum.add(b);
    mul = mul.add(a);
    mul = mul.multiply(b);
    System.out.println(sum);
    System.out.println(mul);
    
  }
}
