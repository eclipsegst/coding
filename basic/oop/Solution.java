/**
 * Author: Zhaolong Zhong
 * Date  : 2015 4:51:34 AM
 */
package oop;

public class Solution {
  public static void main(String []argh){
    Adder X=new Adder();
    System.out.println("My superclass is: "+X.getClass().getSuperclass().getName());    
    System.out.print(X.add(10,32)+" "+X.add(10,3)+" "+X.add(10,10)+"\n");

  }
}
