/**
 * Author : Zhaolong Zhong
 * Date   : Feb 4, 2015 6:23:35 PM
 * 
 * Problem:
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 */
package strStr;

public class StrStr {
  public static int strStr(String haystack, String needle) {
    int h = haystack.length();
    int n = needle.length();
    if(haystack == null && needle == null || haystack =="" && needle == "" || h > 0 && needle =="") return 0;
    if(h <= 0 || n <= 0|| needle.length() > haystack.length()) return -1;
    
    int m = h - n;
    if(m == 0) {
        if(haystack.equals(needle)) return 0;
    }
    for(int i = 0; i < h; i++){
      for(int j =0; j < n; j++){
        if(i+j < h){
          if(haystack.charAt(i+j) != needle.charAt(j)) break;
        }
        if(j + 1 == n) return i;
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    System.out.println(strStr("mississippi","pi"));
  }
}
