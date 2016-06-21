package a;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Valid Anagram
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
        	return false;
        }
        
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        
        // each character has a unique index cs[i] - 'a'
        // so we need an array with size 26 to count each character
        int[] map = new int[26];
        int count = 0; // count unique characters
        
        for (int i = 0; i < cs.length; i++) {
        	// if a character appears for the first time, we increase the count of unique characters.
        	// or we only increase the totally number of a character
        	if (++map[cs[i] - 'a'] == 1) {
        		count++;
        	}
        	
        	// if the number of character is 0, then we reduce the unique character number.
        	// or we we decrease the totally number of a character
        	if (--map[ct[i] - 'a'] == 0) {
        		count--;
        	}
        }
        
        return count == 0;
    }
}
