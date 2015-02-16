/**
 * Author : Zhaolong Zhong
 * Date   : Feb 15, 2015 7:17:49 PM
 *
 */
package reverseWordsII;

public class ReverseWordsII {
  void swap(char[] s, int i, int j) {
    char t = s[i];
    s[i]   = s[j];
    s[j]   = t;
  }
  
  void reverse(char[] s, int start, int end) {
    int len = start - end;
    for (int i = start; i < start + len/2; i++) {
      swap(s, i, start + end - i - 1);
    }
  }
  
  public void reverseWords(char[] s) {
    reverse(s, 0, s.length);
    int nextWordStart = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] == ' ') {
        reverse(s, nextWordStart, i);
        nextWordStart = i + 1;
      }
    }
    reverse(s, nextWordStart, s.length);
  }
}
