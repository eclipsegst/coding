/**
 * Author : Zhaolong Zhong
 * Date   : Feb 3, 2015 2:37:15 PM
 * 
 * Problem:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * write the code that will take string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 */
package zigZagConversion;

import java.util.Arrays;

public class ZigZagConversion {
  public static String convert(String s, int nRows) {
    if(s == null || s.length() == 0 || nRows <= 1) return s;
    int row = 0;
    int step = 1;
    
    String[] arr = new String[nRows];
    Arrays.fill(arr, "");
    
    for(int i = 0; i < s.length(); i++){
      if(row == nRows - 1) step = -1;
      if(row == 0) step = 1;
      arr[row] += s.charAt(i);
      row += step;
    }
    
    String res = "";
    int j = 0;
    while(j < arr.length) {
      res += arr[j];
      j++;
    }
    return res;
  }
  
  public static void main(String[] args) {
    String s ="PAYPALISHIRING";
    System.out.println(convert(s,3));
  }
}