package a;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jun 2, 2016
 * 
 * Word Ladder
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * 
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>();
		Set<String> endSet = new HashSet<String>();
		
		int len = 1;
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}
			
			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chars = word.toCharArray();
				
				for (int i = 0; i < chars.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chars[i];
						chars[i] = c;
						String target = String.valueOf(chars);
						
						if (endSet.contains(target)) {
							return len + 1;
						}
						
						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chars[i] = old;
					}
					
				}
			}
			
			beginSet = temp;
			len++;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		WordLadder solution = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		
		System.out.println(solution.ladderLength(beginWord, endWord, wordList));
	}
}
