package challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaolong Zhong Nov 30, 2015
 * counting map
 * http://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
 */
public class Palindrome {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() <= 1) return true;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) == 1) {
				map.remove(c);
			} else {
				map.put(c, 1);
			}
		}
		
		if (map.size() > 1) return false;
		return true;
	}
	
	public boolean canPermutePalindromeTwo(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			Integer i = map.get(c);
			if (i == null) {
				map.put(c, 1);
			} else {
				map.put(c, i + 1);
			}
		}
		
		int single = 0;
		
		for (int value : map.values()) {
			if (value % 2 == 1) {
				single++;
			}
			if (single > 1) {
				return false;
			}
		}
		
		return true;
	}
}
