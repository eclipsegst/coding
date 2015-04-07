/**
 * Author : Zhaolong Zhong
 * Date   : 2015 2:46:22 PM
 * Problem:
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("a", "ab*a") → false, ab*a = aa
 * 
 * isMatch("aab", "c*a*b") → true, c* means 0 to multiple c, so we can ignore c*. 
 * a* can represent 0 to multiple a, so we can treat it as aa.
 * 
 * Assumption:
 * '.' and '*' only occurs in the second string.
 * 
 */
package regularexpressionmatching;

public class RegulareExpressionMatching {
  public static boolean isMatch(String s, String p) {
    // case 1
    if (p.length() == 0) {
        return s.length() == 0;
    }
    // case 2
    if (p.length() == 1) {
      // if the length of s is 0, return false
      if (s.length() < 1) {
          return false;
      } 
      // compare the first character, return false if they does not match
      else if (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)) {
        return false;
      } 
      // otherwise compare the rest of the string of s and p
      else {
        return isMatch(s.substring(1), p.substring(1));
      }
    } 
    
    // case 3, p.length() > 1
    if (p.charAt(1) != '*') {
      if (s.length() < 0) {
        return false;
      }
      // compare the first character
      else if (p.charAt(0) != s.charAt(0) && (p.charAt(0) != '.')) {
        return false;
      } else {
        return isMatch(s.substring(1), p.substring(1));
      }
    }
    else {
      // case when a* represent as nothing
      if (isMatch(s, p.substring(2))) {
        return true;
      } 
      // case when a* represent as a to a...a
      else {
        int i = -1;
        while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s.substring(i + 1), p.substring(2))) {
                return true;
            }
            
            i++;
        }
        
        return false;
      }
    }
  }
  
  public static void main(String[] args) {
//    String s = "a*b";
//    String p = "b";
    
    String s = "b";
    String p = "a*b";
    
    System.out.println(isMatch(s, p));
  }
}
