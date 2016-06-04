package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jun 4, 2016
 * 
 * Word Ladder II
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * 
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * 	["hit","hot","dot","dog","cog"],
 * 	["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 */
public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>();
		Set<String> endSet = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		boolean[] connected = new boolean[]{false};
		bfs(beginSet, endSet, wordList, false, connected, map);
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		// if beginSet are not connected with endSet, then return empty list;
		if (!connected[0]) {
			return result;
		}
		
		List<String> temp = new ArrayList<String>();
		temp.add(beginWord);
		
		dfs(result, temp, beginWord, endWord, map);
		return result;
	}
	
	private void bfs(Set<String> beginSet, Set<String> endSet, Set<String> wordList, boolean swap, boolean[] connected, Map<String, List<String>> map) {
		if (beginSet.isEmpty() || endSet.isEmpty()) {
			return;
		}
		
		if (beginSet.size() > endSet.size()) {
			bfs(endSet, beginSet, wordList, !swap, connected, map);
			return;
		}
		
		wordList.removeAll(beginSet);
		wordList.removeAll(endSet);
		
		//newSet will be new beginSet
		Set<String> newSet = new HashSet<String>();
		
		for (String str : beginSet) {
			char[] chars = str.toCharArray();
			for (int i = 0; i < str.length(); i++) {
				for (char c = 'a'; c < 'z'; c++) {
					char original = chars[i];
					chars[i] = c;
					String temp = new String(chars);
					chars[i] = original;
					
					// Skip this string if it is not in endSet nor in wordList.
					if (!endSet.contains(temp) && !wordList.contains(temp)) {
						continue;
					}
					
					String key = !swap? str : temp;
					String val = !swap? temp : str;
					
					if (!map.containsKey(key)) {
						map.put(key, new ArrayList<String>());
					}
					
					// if endSet contains temp, then it's connected
					if (endSet.contains(temp)) {
						map.get(key).add(val);
						connected[0] = true;
						continue;
					}
					
					if (!connected[0] && wordList.contains(temp)) {
						map.get(key).add(val);
						newSet.add(temp);
					}
				}
			}
		}
		
		if (!connected[0]) {
			bfs(newSet, endSet, wordList, swap, connected, map);
		}
	}
	
	private void dfs(List<List<String>> result, List<String> temp, String beginWord, String endWord, Map<String, List<String>> map) {
		if (beginWord.equals(endWord)) {
			result.add(new ArrayList<String>(temp));
			return;
		}
		
		// Not each node in map is valid node in shortest path, skip those nodes
		if (!map.containsKey(beginWord)) {
			return;
		}
		
		for (String s : map.get(beginWord)) {
			temp.add(s);
			dfs(result, temp, s, endWord, map);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		WordLadderII solution = new WordLadderII();
		
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		
		List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
		
		System.out.println(Arrays.toString(result.toArray()));
	}
}
