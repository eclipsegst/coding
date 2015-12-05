package fiftyShadeOfCode;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Dec 5, 2015
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		boolean[] exist = new boolean[256];
		int i = 0, max = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			max = Math.max(j - i + 1, max);
		}
		return max;
	}
	
	public int lengthOfLongestSubstringTwo(String s) {
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		int i = 0, max = 0;
		for (int j = 0; j < s.length(); j++) {
			if (charMap[s.charAt(j)] >= i) {
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			max = Math.max(j - i + 1, max);
		}
		return max;
	}
}
