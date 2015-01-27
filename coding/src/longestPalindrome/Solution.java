package longestPalindrome;

import java.util.Arrays;

/*
 * Date: 01/25/2015 23:08
 * 
 * Problem:
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring. 
 */
public class Solution {
  public static void main(String[] args) {
    //String s = "bacabacacab";
    String s = "aaaa";
    //System.out.println(longestPalindromeDP(s));
    //System.out.println(longestPalindromeSimple(s));   
    System.out.println(longestPalindrome(s));
  }
  public static String longestPalindromeDP(String s) {
    char[] str = s.toCharArray();
    int n = str.length;
    int longestBegin = 0;
    int max = 1;
    boolean table[][] = new boolean[1000][1000];
    java.util.Arrays.fill(table[0], false);
    java.util.Arrays.fill(table[1], false);
    for (int i=0; i<n; i++) {
      table[i][i] = true;
    }
    for (int i=0; i <n-1; i++) {
      if (str[i] == str[i+1]) {
        table[i][i+1] = true;
        longestBegin = i;
        max =2;
      }
    }
    for (int len = 3; len <= n; len++) {
      for (int i=0; i<n-len+1; i++) {
        int j = i+len-1;
        if (str[i] == str[j] && table[i+1][j-1]) {
          table[i][j] = true;
          longestBegin = i;
          max = len;
        }
      }
    }
    return s.substring(longestBegin,longestBegin+max);
  }
  public static String longestPalindromeSimple(String s) {
    char[] str = s.toCharArray();
    int n = str.length;
    if (n == 0) return "";
    String longest = s.substring(0,1);
    for (int i=0; i< n-1; i++) {
      String p1 = expandAroundCenter(s,i,i);
      if (p1.length() > longest.length())
        longest = p1;
      String p2 = expandAroundCenter(s,i,i+1);
      if (p2.length() > longest.length())
        longest = p2;
    }
    return longest;
  }
  public static String expandAroundCenter(String s, int c1, int c2) {
    int l = c1;
    int r = c2;
    char[] str = s.toCharArray();
    int n = str.length;
    while (l >= 0 && r <= n-1 && str[l] == str[r]) {
      l--;
      r++;
    }
      return s.substring(l+1, r);
  }
  public static String longestPalindrome (String s) {
    char[] S = s.toCharArray();
    if (s == null || s == "" || S.length == 0) return "";
    boolean T[][] = new boolean[S.length][S.length];
    int maxi = 0;
    int maxLen = 1;
    // len = 1
    Arrays.fill(T[0], true);
    //len = 2
    for (int i=0; i<S.length-1; i++) {
      if (S[i] == S[i+1]) {
        T[1][i] = true;
        maxi = i;
        maxLen = 2;
      }
    }
    // len >= 3
    for (int len=3; len<=S.length; len++) {
      for (int i=0; i< S.length - (len-1); i++) {
        if (T[len-1-2][i+1] && S[i] == S[i+len-1]) {
          T[len-1][i] = true;
          maxi = i;
          maxLen = len;
        }
      }
    }
    return s.substring(maxi, maxi + maxLen);
  }
}
