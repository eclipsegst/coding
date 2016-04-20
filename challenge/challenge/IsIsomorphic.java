/**
 * Author : Zhaolong Zhong
 * Date   : 2015 11:26:52 AM
 * Problem:
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 */
package challenge;

public class IsIsomorphic {
  public static boolean isIsomorphic(String s, String t) {
    char[] S = s.toCharArray();
    char[] T = t.toCharArray();
    
    if (S.length != T.length) return false;
    
    return isIsomorphic(S, T) && isIsomorphic(T, S);
  }
  
  private static boolean isIsomorphic(char[] S, char[] T) {
    char[] map = new char[256];
    for (int i = 0; i < S.length; i++) {
      if (map[(int)S[i]] == 0) {
        map[S[i]] = T[i];
      } else {
        if (map[(int)S[i]] != T[i]) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    String s = "egg";
    String t = "add";
    System.out.println(isIsomorphic(s,t));
  }
}
