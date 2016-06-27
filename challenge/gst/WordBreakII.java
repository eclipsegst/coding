package gst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Word Break II
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * Tags: Dynamic Programming, Backtracking
 * 
 * Reference:
 * https://leetcode.com/discuss/65692
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<String, LinkedList<String>>());
    }
	
	// Memorized DFS
	// O(len(wordDict)^len(s/minWordLenInDict)), since there are len(wordDict) possibilities for each cut.
	private List<String> wordBreakHelper(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
		if (map.containsKey(s)) {
			map.get(s);
		}
		
		LinkedList<String> result = new LinkedList<String>();
		
		if (s.length() == 0) {
			result.add("");
			return result;
		}
		
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> sublist = wordBreakHelper(s.substring(word.length()), wordDict, map);
				
				for (String sub : sublist) {
					result.add(word + (sub.isEmpty() ? "" : " ") + sub);
				}
			}
		}
		
		map.put(s, result);
		
		return result;
	}
	
	public List<String> wordBreakDP(String s, Set<String> wordDict) {
		return wordBreakDPHelper(s, wordDict, new HashMap<String, List<String>>());
	}
	
	private List<String> wordBreakDPHelper(String s, Set<String> wordDict, HashMap<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		
		List<String> result = new LinkedList<String>();
		if (s.isEmpty()) {
			return result;
		}
		
		if (wordDict.contains(s)) {
			result.add(s);
		}
		
		for (int i = 1; i < s.length(); i++) {
			String firstWord = s.substring(0, i);
			if (!wordDict.contains(firstWord)) {
				continue;
			}
			
			List<String> rest = wordBreakDPHelper(s.substring(i), wordDict, map);
			for (String str : rest) {
				result.add(firstWord + " " + str);
			}
		}
		
		map.put(s, result);
		
		return result;
	}
	
	public static void main(String[] args) {
		WordBreakII solution = new WordBreakII();
		
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
	
		List<String> result = solution.wordBreak(s, wordDict);
		List<String> result2 = solution.wordBreakDP(s, wordDict);
		System.out.println(Arrays.toString(result.toArray()));
		System.out.println(Arrays.toString(result2.toArray()));
	}
}
