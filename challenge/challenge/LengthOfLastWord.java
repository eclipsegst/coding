/**
 * Author : Zhaolong Zhong
 * Date   : Feb 4, 2015 10:34:54 PM
 * Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note:
 * A word is defined as a character sequence consists of non-space characters only.
 * For exmaple,
 * Given s = "Hello World", return 5.
 */
package challenge;

public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    if(s == null) return 0;
    String[] strs = s.split(" +");
    if(strs.length <= 0) return 0;
    return strs[strs.length - 1].length();
  }
}
