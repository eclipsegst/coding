/**
 * Author : Zhaolong Zhong
 * Date   : Jan 29, 2015 12:09:41 AM
 * 
 * Problem:
 * Related to quesiton Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
package challenge;

public class ExcelSheetColumnNumber {
  public static int titleToNumber(String s) {
    char[] c = s.toCharArray();
    int n = 0;
    int p = 1;
    for(int i = c.length - 1; i >= 0; i--){
      n += (c[i] - 'A' + 1) * p;
      p *= 26;
    }
    return n;
  }
  
  public static void main(String[] args) {
    String s = "AA";
    System.out.println(titleToNumber(s)); // 27
  }
}
