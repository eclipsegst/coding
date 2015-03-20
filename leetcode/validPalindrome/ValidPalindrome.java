/**
 * Author : Zhaolong Zhong
 * Date   : Feb 3, 2015 9:12:28 PM
 * 
 * Problem:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interiew.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
package validPalindrome;

public class ValidPalindrome {
  boolean valid(char[] c, int i){
    return !(('A' <= c[i] && c[i] <= 'Z')
           ||('a' <= c[i] && c[i] <= 'z')
           ||('0' <= c[i] && c[i] <= '9'));
  }
  
  public boolean isPalindrome(String s) {
    if(s == null) return true;
    char[] c = s.toLowerCase().toCharArray();
    int i = 0; 
    int j = c.length - 1;
    while(i < j){
      while((i < j) && valid(c, i)) i++;
      while((i < j) && valid(c, j)) j--;
      if(c[i] != c[j]) return false;
      i++;
      j--;
    }
    return true;
  }
}
