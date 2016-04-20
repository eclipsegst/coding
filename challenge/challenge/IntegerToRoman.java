/**
 * Author : Zhaolong Zhong
 * Date   : Feb 3, 2015 4:59:41 PM
 * 
 * Problem:
 * Integer to Roman
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Roman numerals:
 * I V X  L  C   D   M
 * 1 5 10 50 100 500 1000
 * 
 */
package challenge;

public class IntegerToRoman {
  public String intToRoman(int num) {
    int [] N   = {1,   4,    5,    9,   10,  40,   50,  90,   100, 400,  500, 900, 1000};
    String[] C = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    String res = "";
    for(int i = 12; num!= 0; i--){
      while(num >= N[i]){
        num -= N[i];
        res += C[i];
      }
    }
    return res;
  }
}