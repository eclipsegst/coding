/**
 * Author : Zhaolong Zhong
 * Date   : Jan 31, 2015 5:22:51 PM
 * 
 * Problem:
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Notes:
 * - What constitutes a word?
 *   A sequence of no-space characters constitutes a word.
 * - Could the input string contain leading or trailing spaces?
 *   Yes. However, your reversed string should not contain leading or trailing spaces.
 * - How about multiple spaces between two words?
 *   Reduce them to a single space in the reversed string.
 */
package reverseWords;

public class ReverseWords {
  public static String reverseWords(String s) {
    String [] strs = s.trim().split(" +");
    if(strs.length == 0) return "";
    String res = "";
    for(int i = strs.length - 1; i > 0; i--){
      if(strs[i] != " "){
        res += strs[i] + " ";
      }
    }
    res += strs[0];
    return res;
  }
}
