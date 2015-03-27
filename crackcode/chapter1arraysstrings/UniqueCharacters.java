/**
 *  Author : Zhaolong Zhong
 *  Date   : Mar 2, 2015 9:04:34 PM
 *  
 *  Problem: 1.1
 *  Implement an algorithm to determine if a string has all unique characters.
 *  What if you can not use addition data structures?
 *  
 */
package chapter1arraysstrings;
import java.util.HashMap;
public class UniqueCharacters {
  // time complexity: O(n^2); space complexity: O(n)
  static boolean hasUniqueCharsBrute(String s) {
    if(s == null || s.isEmpty()) return false;
    for (int i = 0; i < s.length() - 1; i++) {
      for (int j = i + 1; j < s.length(); j++) {
        if(s.charAt(i) == s.charAt(j)) return false;
      }
    }
    return true;
  }
  
  // time complexity: O(n); space complexity O(n)
  static boolean hasUniqueCharsHash(String s) {
    if(s == null || s.isEmpty()) return false;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      if(map.keySet().contains(s.charAt(i))) {
        return false;
      } else {
        map.put(s.charAt(i),  0);
      }
    }
    return true;
  }
  
  // assume char set is ASCII(128 in standard ASCII and 256 in extended ASCII)
  // time complexity is O(n), where n is the length of the string, and space complexity is O(n);
  static boolean isUniqueChars2(String str) {
    boolean[] charSet = new boolean[256];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if(charSet[val]) return false;
      charSet[val] = true;
    }
    return true;
  }
  
  // assume the string is only lower case 'a' through 'z'
  // the signed left shift operator "<<" shifts a bit pattern to the left. 
  static boolean isUniqueChars(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) return false;
      checker |= (1 << val);
    }
    return true;
  }
  
  public static void main(String[] args) {
    String test1 = "abcd";
    String test2 = "abacd";
    // hash
    System.out.println(hasUniqueCharsHash(test1));
    System.out.println(hasUniqueCharsHash(test2));
    // brute force
    System.out.println(hasUniqueCharsBrute(test1));
    System.out.println(hasUniqueCharsBrute(test2));
    
    System.out.println(isUniqueChars(test1));
    System.out.println(isUniqueChars(test2));
    
    int i = 4;
    System.out.println(i >> 1); // prints 2, since shift right is equal to divide by 2
    System.out.println(i << 1); // prints 8, since shift left is equal to multiply by 2
    
    int j = -4;
    System.out.println(j >> 1); // prints -2
    System.out.println(j << 1); // prints -8
    // generally speaking i << k is equivalent to i * (2^k), while i >> k is equivalent to i/(2^k)
    // make sure you do not overflow your data type
    // another example - shift the bits
    // 101 = 5
    // if shifting out the right "1", 101 -> 10 = 2
    // if shifting the other way, 101 -> 1010 = 10
    
    // the bitwise & operator performs a bitwise AND operation.
    // the bitwise ^ operator performs a bitwise exclusive OR operation.
    // the bitwise | operator performs a bitwise inclusive OR operation. a|b is equivalent to a = (a | b)
    
    int m0 = 1, m1 = 1, m2 = 1;
    System.out.println(m0 |= 2); // prints 3
    System.out.println(m1 &= 2); // prints 0
    System.out.println(m2 ^= 2); // prints 3
    System.out.println();
    int n0 = 2, n1 = 2, n2 = 2;
    System.out.println(n0 |= 2); // prints 2
    System.out.println(n1 &= 2); // prints 2
    System.out.println(n2 ^= 2); // prints 0
  }

}
