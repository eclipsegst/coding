/**
 * Author: Zhaolong Zhong
 * Date  : Mar 5, 2015 4:43:58 PM
 * Problem: 1.3
 * Given two strings, write a method to decide if one is permutation of the other.
 */
package chapter1arraysstrings;

import java.util.HashMap;

public class Permutation {
  // solution 1: HashMap
  static boolean isPermutation(String s0, String s1) {
    if (s0 == null && s1 == null) return true;
    if (s0 != null && s0.equals(s1)) return true; 
    if (s1 != null && s1.equals(s0)) return true;
    if (s0.length() != s1.length()) return false;
    
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s0.length(); i++) {
        char c = s0.charAt(i);
        if (map.keySet().contains(c))
        {
            map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
    }

    for (int j = 0; j < s1.length(); j++) {
        char c = s1.charAt(j);
        if (map.keySet().contains(c)) {
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    return true;
  }
  
  // solution 2: sort
  static String sort(String s) {
      char[] contents = s.toCharArray();
      java.util.Arrays.sort(contents);
      return new String(contents);
  }

  static boolean permutation(String s0, String s1) {
      if (s0.length() != s1.length()) {
          return false;
      }
      return sort(s0).equals(sort(s1));
  }
  
  // solution 3:
  // assume all characters in the string are ASCII
  static boolean permutationTwo(String s0, String s1) {
    if (s0.length() != s1.length()) return false;
    int[] letters = new int[256];
    char[] array = s0.toCharArray();
    for (char c : array) {
        letters[c]++;
    }
    for (int i = 0; i < s1.length(); i++) {
        char c = s1.charAt(i);
        if (--letters[c] < 0) {
            return false;
        }
    }
    return true;
}
  public static void main(String[] args) {
    String a = "abac";
    String b = "baca";
    System.out.println(isPermutation(a,b));
    System.out.println(permutation(a,b));
    System.out.println(permutationTwo(a,b));
  }
}
