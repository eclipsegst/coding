package challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jun 5, 2016
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
	// O(n^2)
	public boolean wordBreakSlow(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }
	
	private boolean wordBreakHelper(String s, Set<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}
		
		for (String str : wordDict) {
			int len = str.length();
			int end = start + len;
			
			if (end > s.length()) {
				continue;
			}
			
			if (s.substring(start, start + len).equals(str)) {
				if (wordBreakHelper(s, wordDict, start + len)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		
		for (int i = 0; i < s.length(); i++) {
			if (!result[i]) {
				continue;
			}
			
			for (String w : wordDict) {
				int len = w.length();
				int end = i + len;
				
				if (end > s.length()) {
					continue;
				}
				
				if (result[end]) {
					continue;
				}
				
				if (s.substring(i, end).equals(w)) {
					result[end] = true;
				}
			}
		}
		
		return result[s.length()];
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
