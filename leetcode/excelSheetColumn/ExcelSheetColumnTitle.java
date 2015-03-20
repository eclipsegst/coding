/**
 * Author : Zhaolong Zhong
 * Date   : Jan 29, 2015 12:27:19 AM
 * 
 * Problem:
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 52 -> AZ
 * 53 -> BA
 * ...
 */
package excelSheetColumn;

public class ExcelSheetColumnTitle {
  public static String convertToTitle(int n) {
    if (n < 27) return (char) ('A' + (n - 1)) + "";
    if (n % 26 == 0) return convertToTitle(n / 26 -1) + 'Z';
    return convertToTitle(n / 26) + convertToTitle(n % 26);
  }
  
  public static void main(String[] args) {
    System.out.println(convertToTitle(52));  // AZ
    System.out.println((char)('A'+2));       // C
  }
}
