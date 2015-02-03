/**
 * Author : Zhaolong Zhong
 * Date   : Feb 3, 2015 5:20:03 PM
 * 
 * Problem:
 * Longest Common Prefix
 * Write a function to find the longest common prefix string among an array of strings.
 * 
 */
package longestCommonPrefix;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if(strs.length == 0) return "";
    if(strs.length == 1) return strs[0];
    
    int p = 0;
    here:
    while(true){
      if(p >= strs[0].length()) break;
      char c = strs[0].charAt(p);
      for(String str : strs) {
        if(str.length() <= p || str.charAt(p) != c) break here; // or p++
      }
      p++;
    }
    return strs[0].substring(0, p);
  }
}
