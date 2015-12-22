package g;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Zhaolong Zhong Dec 21, 2015
 * 
 * Problem: Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.The brackets must close in the correct 
 * order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean isValidParenthese(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (!stack.isEmpty() && map.get(stack.peek()) == c){
				stack.pop();
			} else {
				return false;
			}
		}
		
		return stack.isEmpty();
	}
}
