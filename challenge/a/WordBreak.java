package a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jun 20, 2016
 * 
 * Word Break
 * 
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
	
	//Runtime: O(n * m)
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		
		for (int i = 0; i < s.length(); i++) {
			// Make sure range 0 to i - 1 of s breakable.
			// If it's not breakable, then we skip this break point.
			if (!result[i]) {
				continue;
			}
			
			for (String word : wordDict) {
				int len = word.length();
				int end = i + len;
				
				if (end > s.length()) {
					continue;
				}
				
				if (result[end]) {
					continue;
				}
				
				if (s.substring(i, end).equals(word)) {
					result[end] = true;
				}
			}
		}
		
		return result[s.length()];
	}
	
	//Runtime: O(n^2)
	public boolean wordBreakSimple(String s, Set<String> wordDict) {
		int[] position = new int[s.length() + 1];
		
		Arrays.fill(position, 0);
		
		position[0] = 1;
		
		for (int i = 0; i < s.length(); i++) {
			if (position[i] != 0) {
				for (int j = i + 1; i <= s.length(); j++) {
					String sub = s.substring(i, j);
					if (wordDict.contains(sub)) {
						position[j] = i;
					}
				}
			}
		}
		
		return position[s.length()] != 0;
	}
	
	public static void main(String[] args) {
		WordBreak solution = new WordBreak();
		
		String s = "helloword";
		Set<String> wordDict = new HashSet<>();
		wordDict.add("hello");
		wordDict.add("word");
		
		System.out.println(solution.wordBreak(s, wordDict));
	}
}
