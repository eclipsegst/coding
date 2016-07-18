package challenge;

import java.util.Stack;

/**
 * @author Zhaolong Zhong Jul 17, 2016
 * 
 * Remove Duplicate Letters
 * 
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * 
 * Example:
 * Given "bcabc"
 * Return "abc"
 * Given "cbacdcbc"
 * Return "acdb"
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/31404
 * https://discuss.leetcode.com/topic/31413
 * https://discuss.leetcode.com/topic/31424
 * https://discuss.leetcode.com/topic/43469
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        int[] count = new int[26];
        char[] array = s.toCharArray();
        
        for (char c : array) count[c - 'a']++;
        
        boolean[] visited = new boolean[26];
        
        for(char c : array) {
        	count[c - 'a']--;
        	if (visited[c - 'a']) continue;
        	
        	while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
        		visited[stack.peek() - 'a'] = false;
        		stack.pop();
        	}
        	
        	stack.push(c);
        	visited[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        
        return sb.toString();
    }
}
