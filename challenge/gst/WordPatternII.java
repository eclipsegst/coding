package gst;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jun 27, 2016
 * 
 * Word Pattern II
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * 
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * 
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 * 
 * Reference:
 * https://leetcode.com/discuss/63252
 * https://leetcode.com/discuss/63393
 * https://leetcode.com/discuss/84025
 * 
 */
public class WordPatternII {
	
	Map<Character, String> map = new HashMap<Character, String>();
	Set<String> set = new HashSet<String>();
	
	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern.isEmpty()) {
			return str.isEmpty();
		}
		
		if (map.containsKey(pattern.charAt(0))) {
			String value = map.get(pattern.charAt(0));
			if (str.length() < value.length() || !str.substring(0, value.length()).equals(value)) {
				return false;
			}
			
			if (wordPatternMatch(pattern.substring(1), str.substring(value.length()))) {
				return true;
			}
		} else {
			for (int i = 1; i <= str.length(); i++) {
				if (set.contains(str.substring(0, i))) {
					continue;
				}
				
				map.put(pattern.charAt(0), str.substring(0, i));
				set.add(str.substring(0, i));
				
				if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
					return true;
				}
				
				set.remove(str.substring(0, i));
				map.remove(pattern.charAt(0));
			}
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		WordPatternII solution = new WordPatternII();
		
		String p1 = "abab";
		String p2 = "aaaa";
		String p3 = "aabb";
		
		String s1 = "redblueredblue";
		String s2 = "asdasdasdasd";
		String s3 = "xyzabcxzyabc";
		
		System.out.println(solution.wordPatternMatch(p1, s1));
		System.out.println(solution.wordPatternMatch(p2, s2));
		System.out.println(solution.wordPatternMatch(p3, s3));
	}
}
