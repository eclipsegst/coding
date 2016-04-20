/**
 * Author: Zhaolong Zhong
 * Date  : Mar 7, 2015 6:47:34 PM
 * Problme: 1.5
 */
package crackcode;

// running time: O(n + k^2), n is the size or original string
// k is the number of character, for example, if s = "aabccdeeaa", k = 6
public class CompressString {
  public static String compressString(String str) {
    if (str.length() <= 0) return null;

    int count = 1;
    String res = "";
    char last = str.charAt(0);
    for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == last) {
            count ++;
        } else {
            res = res + last + count;
            last = str.charAt(i);
            count = 1;
        }
    }
    res = res + last + count;
    return res;
  }
  // running time: O(n), space: O(n)
  public static String compressBetter(String str) {
    if (str.length() <= 0 ) return null;
    int size = countCompress(str);
    if (size >= str.length()) {
      return str;
    }
    StringBuffer sb = new StringBuffer();
    int count = 1;
    char last = str.charAt(0);
    
    for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == last) {
            count++;
        } else {
            sb.append(last);
            sb.append(count++);
            last = str.charAt(i);
            count = 1;
        }
    }
    sb.append(last);
    sb.append(count);
    return sb.toString();
  }
  
  public static int countCompress(String str) {
    int size = 0;
    int count = 1;
    char last = str.charAt(0);
    for(int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == last) {
        count++;
      } else {
        size += 1 + String.valueOf(count).length();
        last = str.charAt(i);
        count = 1;
      }
    }
    size += 1 + String.valueOf(count).length();
    return size;
  }

  public static void main(String[] args) {
    String s = "aabccdeeaa";
    System.out.println(compressString(s));
    System.out.println(compressBetter(s));
  }
}
