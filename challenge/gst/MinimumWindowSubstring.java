package gst;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaolong Zhong Jun 27, 2016
 * 
 * Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * Reference:
 * https://leetcode.com/discuss/72701
 * https://leetcode.com/discuss/10337
 * https://leetcode.com/discuss/18584
 * https://leetcode.com/discuss/32851
 * https://leetcode.com/discuss/20053
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
	
		for (char c : s.toCharArray()) {
			map.put(c,  0);
		}
		
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				return "";
			}
		}
		
		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
		while (end < s.length()) {
			char c1 = s.charAt(end);
			
			if (map.get(c1) > 0) {
				counter--;
			}
			
			map.put(c1, map.get(c1) - 1);
			end++;
			
			while (counter == 0) {
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}
				
				char c2 = s.charAt(start);
				map.put(c2, map.get(c2) + 1);
				if (map.get(c2) > 0) {
					counter++;
				}
				
				start++;
			}
		}
		
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}
}
