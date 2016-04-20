/**
 * Author : Zhaolong Zhong
 * Date   : 2015 5:47:52 PM
 * Problem:
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters is just like on the telephone buttons.
 */
package challenge;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
  static final char[][] CHAR_MAP = {
    {},                     //0
    {},                     //1
    { 'a', 'b', 'c'},       //2
    { 'd', 'e', 'f'},       //3
    { 'g', 'h', 'i'},       //4
    { 'j', 'k', 'l'},       //5
    { 'm', 'n', 'o'},       //6
    { 'p', 'q', 'r', 's'},  //7
    { 't', 'u', 'v'},       //8
    { 'w', 'x', 'y', 'z'},  //9
  }; 
  
  static ArrayList<String> res;
  static char[] stack;
  
  static void find(char[] charArray, int p) {
    if (p == charArray.length) {
      res.add(new String(stack));
    } else {
      int num = (int) (charArray[p] - '0'); // digit
      for (char c : CHAR_MAP[num]) {
        stack[p] = c;
        find(charArray, p + 1);
      }
    }
  }
  
  public static List<String> letterCombinations(String digits) {
    res = new ArrayList<>();
    
    if (digits.equals("")) return res;
    
    stack = new char[digits.length()];
    
    find(digits.toCharArray(), 0);
    
    return res;
  }
  
  public static void main(String[] args) {
    String digits = "23";
    
    letterCombinations(digits).stream().forEach((string) -> {
      System.out.println(string);
    });
  }
}
