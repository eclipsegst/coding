package validanagram;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong
 * Date: 6:14:32 PM Aug 1, 2015
 * 
 * Problem: Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 */
public class ValidAnagram {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));

	}
	
	public static boolean isAnagram(String s, String t) {
        char [] cs = s.toCharArray();
        char [] ct = t.toCharArray();
        
        Arrays.sort(cs);
        Arrays.sort(ct);
        
        return Arrays.equals(cs, ct);
    }

}
