package lengthoflongestsubstring;
/*
 * Date: 01/25/2015 19:00
 * 
 * Problem:
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 */
public class LengthOfLongestSubstring {
  public static int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    char[] str = s.toCharArray();
    if (str.length == 0) {
      return 0;
    }
    int max = 1;
    int start = 0;
    
    for (int i = 1; i<str.length; i++) {
      for (int j =i - 1; j >= start; j--) {
        if (str[i] == str[j]) {
          start = j + 1;
          break;
        }
      }
      max = Math.max(max,  i - start + 1);
    }
    return max;
  }
  
  public static void main(String[] args){
    String s0 = "";
    String s1 = "abcabcbb";
    String s2 = "bbbbb";
    System.out.println(lengthOfLongestSubstring(s0));// 0
    System.out.println(lengthOfLongestSubstring(s1));// 3
    System.out.println(lengthOfLongestSubstring(s2));// 1
  }
}
