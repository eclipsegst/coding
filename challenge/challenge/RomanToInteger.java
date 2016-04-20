/**
 * Author : Zhaolong Zhong
 * Date   : Feb 3, 2015 3:38:27 PM
 * 
 * Problem:
 * Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Roman numerals:
 * I V X  L  C   D   M
 * 1 5 10 50 100 500 1000
 * 
 */
package challenge;

public class RomanToInteger {
  static final int[]  N = { 1,   5,  10,  50,  100, 500, 1000};
  static final char[] C = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
  
  static int rtoi(char c) {
    return N[getIndex(c)];
  }
  
  static int getIndex(char c) {
    for(int i = 0; i < C.length; i++){
      if(C[i] == c) return i;
    }
    return -1;
  }
  
  public static int romanToInt(String s) {
    if(s.length() < 0 || s == null) return 0;
    char[] a = s.toCharArray();
    int sum = rtoi(a[0]);
    
    for(int i = 1; i < a.length; i++){
      sum += rtoi(a[i]);
      int index = getIndex(a[i]);
      int j = i - 1;
      while(j >= 0 && getIndex(a[j]) < index){
        sum -= rtoi(a[j--]) * 2;
      }
    }
    return sum;
  }
  
  public static void main(String[] args) {
    String s = "ILM";   // LIM = 949; ILM = 947; 
    System.out.println(romanToInt(s));
  }
}