package g;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaolong Zhong Dec 23, 2015
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
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
		for (int v : map.values()) {
			if (v % 2 == 1) {
				single++;
			}
			
			if (single > 1) {
				return false;
			}
		}
		
		return true;
	}
}
