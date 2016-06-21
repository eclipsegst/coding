package a;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() <= 1) {
			return false;
		}
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack = new Stack<Character>();
		
		for (char c : s.toCharArray()) {
			if (map.keySet().contains(c)) {
				stack.push(c);
			} else if (map.values().contains(c) && !stack.isEmpty() && map.get(stack.peek()).equals(c)) {
				stack.pop();
			} else {
				return false;
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();
		
		String s1 = "()[]{}";
		String s2 = "([)]";
		
		System.out.println(solution.isValid(s1));
		System.out.println(solution.isValid(s2));
	}
}
