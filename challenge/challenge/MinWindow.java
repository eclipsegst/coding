package challenge;
import java.util.HashMap;
/*
 * Date: 01/23/2015 02:13AM
 * Given a set T of characters and a string S, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 */

public class MinWindow {
  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(minWindow(s,t));
  }
  public static String minWindow(String s, String t) {
    if (s == null || s.length()==0)
      return "";
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i=0; i<t.length(); i++) {
      if (map.containsKey(t.charAt(i))) {
        map.put(t.charAt(i), map.get(t.charAt(i)+1));
      } else {
        map.put(t.charAt(i), 1);
      }
    }
    
    int left = 0;
    int count = 0;
    int minLen = s.length() + 1;
    int minStart = 0;
    for (int right=0; right < s.length(); right++) {
      if (map.containsKey(s.charAt(right))) {
        map.put(s.charAt(right),  map.get(s.charAt(right))-1);
        if (map.get(s.charAt(right))>=0) {
          count ++;
        }
        while (count == t.length()) {
          if (right-left+1 < minLen) {
            minLen = right-left+1;
            minStart = left;
          }
          if (map.containsKey(s.charAt(left))) {
            map.put(s.charAt(left), map.get(s.charAt(left))+1);
            if (map.get(s.charAt(left))>0) {
              count--;
            }
          }
          left ++;
        }
      }
    }
    if (minLen>s.length()) {
      return "";
    }
    return s.substring(minStart,minStart+minLen);
  }
}
