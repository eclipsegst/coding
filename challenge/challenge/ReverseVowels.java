package challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Zhaolong Zhong May 23, 2016
 * 
 * Reverse Vowels of a String
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 */
public class ReverseVowels {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		
		String vowels = "aeoiuAEOIU";
		
		// find index of vowel
		List<Integer> indexOfVowels = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (vowels.indexOf(s.charAt(i)) != -1) {
				indexOfVowels.add(i);
			}
		}
		
		Collections.reverse(indexOfVowels);
		StringBuilder sb = new StringBuilder();
		
		for (char c : s.toCharArray()) {
			if (vowels.indexOf(c) != -1) {
				sb.append(s.charAt(indexOfVowels.get(0)));
				indexOfVowels.remove(0);
				continue;
			}
			
			sb.append(c);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ReverseVowels solution = new ReverseVowels();
		String s1 = "hello";
		String s2 = "hellohello";
		System.out.println(solution.reverseVowels(s1)); // return "holle"
		System.out.println(solution.reverseVowels(s2)); // return "holleholle"
	}
}
