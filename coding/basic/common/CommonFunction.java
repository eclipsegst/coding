/**
 * Author: Zhaolong Zhong
 * Date  : Feb 5, 2015 4:21:46 PM
 *
 */
package common;

import java.util.Arrays;

public class CommonFunction {
  public static void main(String[] args) {
    /*
     * Conversion among Integer, Character and String
     */
    char c = 'z';
    String s = "abc"; 
    String [] str = {"a", "b", "c"};
    int len = s.length();// s cannot be null, or throw java.lang.NullPointerException
    System.out.println(len);
    System.out.println(s.charAt(1)); // 'b'
    System.out.println(Arrays.toString(str)); // return "[a,b,c]"
    
    System.out.println((int)c);
    // (int)'0' = 48, (int)'9' = 57, (int)'A' = 65, (int)'Z' = 90, (int)'a' = 97, (int)'z' = 122
    
    // Convert Character to String
    System.out.println(String.valueOf(c));// return "z"
    System.out.println(Character.toString(c));//return "z"
    System.out.println("xy" + c);// return "xyz"
    
    // Convert String to Character Array
    char[] charArray = s.toCharArray();
    System.out.println(Arrays.toString(charArray));
    // Convert String to Integer
    int n1 = Character.getNumericValue("ca5".charAt(1));// "cc5".charAt(1), return 10 
    System.out.println(n1);// return 5
    System.out.println(Integer.parseInt("123"));
    // Convert Integer to String 
    System.out.println(String.valueOf("6"));
    System.out.println(Integer.toString(6));
    
    // Convert Integer to Character
    System.out.println(Character.toChars(65)); //return 'A'
    // Convert Integer to binary string
    System.out.println(Integer.toBinaryString(11));//return "1011"
    /*
     * trim()
     * 
     * public String trim()
     * It returns a copy of this string with leading and trailing white space removed,
     * or this string if it has no leading or trailing white space.
     */
    s = "    ab c       d efg  ";
    System.out.println(s.trim());//"abc       d efg"
    
    /*
     * split()
     * 
     * public String[] split(String regex)
     * 
     */
    s = "    abc       d efg  ";
    str = s.split(" +"); // or s.split("\\s+"), s.split("\\s{7,}") split by 7 white space
    System.out.println(Arrays.toString(str));//[, abc, d, efg]
    s = "...ab.c..d......efg";
    str = s.split("\\.{2,}");// split with at list two ".", s.split("\\.+") split at least one "."
    System.out.println(Arrays.toString(str));//[, ab.c, d, efg]
    /*
     * Function in Arrays class
     */
    // Arrays.sort() and Array.fill()
    int[] nums = {-1, 1, 2, -1, -4};
    Arrays.sort(nums);// nums = [-4, -1, -1, 1, 2]
    System.out.println(Arrays.toString(nums)); // return "[-4, -1, -1, 1, 2]"
    
    int[] arrayOne = new int[10];
    Arrays.fill(arrayOne, 0);// arrayOne = {0,0,0,0,0,0,0,0,0,0}
    int[][] arrayTwo = new int[10][10];
    for(int[] row : arrayTwo) Arrays.fill(row, 0);
  }
}
