package a;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
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
			// loop all the words in beginSet and find possible mutations
			for (String word : beginSet) {
				char[] chars = word.toCharArray();
				
				// mutate each character
				for (int i = 0; i < chars.length; i++) {
					// mutate the character from a to z
					for (char c = 'a'; c <= 'z'; c++) {
						char original = chars[i]; // we need to change back to original
						chars[i] = c;
						String target = String.valueOf(chars);
						
						if (endSet.contains(target)) {
							return len + 1;
						}
						
						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chars[i] = original;
					}
					
				}
			}
			
			beginSet = temp;
			len++;
		}
		
		return 0;
	}
	//BFS
	public int ladderLengthBFS(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || beginWord.length() != endWord.length()) {
			return 0;
		}
		
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		
		int len = 1;
		int lastNum = 1;//if beginWord's mutations have two element that belong to wordList, then lastNum will be two
		int curNum = 0;// the number of current word's mutations that are in wordList
		
		queue.offer(beginWord);
		visited.add(beginWord);
		
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			lastNum--;
			
			for (int i = 0; i < cur.length(); i++) {
				char[] curs = cur.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					curs[i] = c;
					String temp = new String(curs);
					if (temp.equals(endWord)) {
						return len + 1;
					}
					
					if (wordList.contains(temp) && !visited.contains(temp)) {
						curNum++;
						queue.offer(temp);
						visited.add(temp);
					}
				}
			}
			
			if (lastNum == 0) {
				lastNum = curNum;
				curNum = 0;
				len++;
			}
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
		System.out.println(solution.ladderLengthBFS(beginWord, endWord, wordList));
	}
}
