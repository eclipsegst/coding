package u;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhaolong Zhong Oct 2, 2016
 * 
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		return wordBreakDFSHelper(s, wordDict, new HashMap<String, List<String>>());
	}
	
	private List<String> wordBreakDFSHelper(String s, Set<String> wordDict, HashMap<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		
		List<String> result = new LinkedList<String>();
		if (s.length() == 0) {
			result.add("");
			return result;
		}
		
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> subList = wordBreakDFSHelper(s.substring(word.length()), wordDict, map);
				for (String sub : subList) {
					result.add(word + (sub.isEmpty() ? "" : " ") + sub);
				}
			}
		}
		
		map.put(s, result);
		
		return result;
	}
	
	public List<String> wordBreakTwo(String s, Set<String> wordDict) {
		int maxLen = 0;
		
		for (String word: wordDict) {
			maxLen = Math.max(maxLen, word.length());
		}
		
		return wordBreakDPHelper(s, wordDict, new HashMap<String, List<String>>(), maxLen);
	}
	
	private List<String> wordBreakDPHelper(String s, Set<String> wordDict, Map<String, List<String>> map, int maxLen) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		
		List<String> result = new LinkedList<String>();
		if (s.length() == 0) {
			return result;
		}
		
		int n = s.length();
		
		for (int i = 1; i <= n; i++) {
			if (i > maxLen) {
				break;
			}
			
			String left = s.substring(0, i);
			
			if (wordDict.contains(left)) {
				
				if (i == n) {
					result.add(left);
				} else {
					String right = s.substring(i);
					List<String> sublist = wordBreakDPHelper(right, wordDict, map, maxLen);
					
					for (String sub : sublist) {
						result.add(left + " " + sub);
					}
				}
			}
		}
		
		map.put(s, result);
		
		return result;
	}
	
	public static void main(String[] args) {
		WordBreakII solution = new WordBreakII();
		
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		String s2 = "goalspecial";
		Set<String> wordDict2 = new HashSet<String>();
		wordDict2.add("go");
		wordDict2.add("goal");
		wordDict2.add("goals");
		wordDict2.add("special");
		
		System.out.println(solution.wordBreak(s, wordDict));
		System.out.println(solution.wordBreakTwo(s, wordDict));
		
		System.out.println(solution.wordBreak(s2, wordDict2));
		System.out.println(solution.wordBreakTwo(s2, wordDict2));
	}
}
