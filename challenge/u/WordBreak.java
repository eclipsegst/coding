package u;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong Oct 2, 2016
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		
		for (int i = 0; i < s.length(); i++) {
			if (!result[i]) {
				continue;
			}
			
			for (String word : wordDict) {
				int len = word.length();
				int end = i + len;
				
				// Out of boundary
				if (end > s.length()) {
					continue;
				}
				
				// Breakable at end
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
	
	public boolean wordBreakBetter(String s, Set<String> wordDict) {
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		
//		// Method 1: Time O(m^n), m is the length of dictionary
//		for (int i = 1; i <= s.length(); i++) {
//			for (String word: wordDict) {
//				if (word.length() <= i) {
//					if (result[i - word.length()]) {
//						if (s.substring(i - word.length(), i).equals(word)) {
//							result[i] = true;
//							break;
//						}
//					}
//				}
//			}
//		}
		
//		// Method 2: Time O(n^2)
//		for (int i = 1; i <= s.length(); i++) {
//			for (int j = 0; j < i; j++) {
//				if (result[j] && wordDict.contains(s.substring(j, i))) {
//					result[i] = true;
//					break;
//				}
//			}
//		}
		
		// Method 3: Time worst O(n^2), best O(mn), m is average of word length in dictionary
		int maxLen = 0;
		for (String word: wordDict) {
			maxLen = Math.max(maxLen, word.length());
		}
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - maxLen >= 0 ? i - maxLen : 0; j < i; j++) {
				if (result[j] && wordDict.contains(s.substring(j, i))) {
					result[i] = true;
					break;
				}
			}
		}
		
		return result[s.length()];
	}
	
	public static void main(String[] args) {
		WordBreak solution = new WordBreak();
		
		String s = "helloword";
		Set<String> wordDict = new HashSet<String>();
		
		wordDict.add("hello");
		wordDict.add("word");
		
		System.out.println(solution.wordBreakBetter(s, wordDict));
	}
}
