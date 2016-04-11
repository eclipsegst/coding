package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaolong Zhong Apr 11, 2016
 * 
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * 
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (words == null || words.length < 2) {
			return result;
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);
				
				if (isPalindrome(s1)) {
					String s2rev = new StringBuilder(s2).reverse().toString();
					if (map.containsKey(s2rev) && map.get(s2rev) != i) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(s2rev));
						list.add(i);
						result.add(list);
					}
				}
				
				if (isPalindrome(s2) && s2.length() != 0) {
					String s1rev = new StringBuilder(s1).reverse().toString();
					if (map.containsKey(s1rev) && map.get(s1rev) != i) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(s1rev));
						result.add(list);
					}
				}
			}
		}
		
		return result;
	}
	
	private boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePairs solution = new PalindromePairs();
		String[] words1 = {"bat", "tab", "cat"};
		String[] words2 = {"abcd", "dcba", "lls", "s", "sssll"};
		
		List<List<Integer>> res1 = solution.palindromePairs(words1);
		List<List<Integer>> res2 = solution.palindromePairs(words2);
		
		System.out.println(Arrays.toString(res1.toArray()));
		System.out.println(Arrays.toString(res2.toArray()));
	}
}
