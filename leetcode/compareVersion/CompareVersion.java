/**
 * Author : Zhaolong Zhong
 * Date   : Jan 29, 2015 5:46:16 PM
 * 
 * Problem:
 * Compare two version numbers version 1 and version2.
 * If version1 > version 2 return 1, if version 1 < version 2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */
package compareVersion;

import java.util.Arrays;

public class CompareVersion {
  static String padding(String s, int len) {
    if(s == null) s = "";
    char[] p = new char[len-s.length()];
    Arrays.fill(p, '0');
    return  new String(p) + s;
  }
  static int len(String s) {
    if(s == null) return 0;
    return s.length();
  }
  
  public static int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int m = Math.max(v1.length, v2.length);
    v1 = Arrays.copyOf(v1, m);
    v2 = Arrays.copyOf(v2, m);
    for(int i = 0; i < m; i++){
      String s1 = v1[i];
      String s2 = v2[i];
      int l = Math.max(len(s1),len(s2));
      s1 = padding(s1, l);
      s2 = padding(s2, l);
      for(int j = 0; j < l ;j++){
        if(s1.charAt(j) > s2.charAt(j)){
          return 1;
        } else if(s1.charAt(j) < s2.charAt(j)){
          return -1;
        }
      }
    }
    return 0;
  }
}