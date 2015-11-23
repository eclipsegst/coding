package validParentheses;

import java.util.HashMap;
import java.util.Stack;
/**
 * @author Zhaolong Zhong Nov 23, 2015
 */
public class ValidParentheses {
	public static boolean validParentheses(String str) {
		if (str == null) return true;
		
		HashMap<Character, Character> map = new HashMap<>();
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
		
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.keySet().contains(c)) {
				stack.push(c);
			} else if (map.values().contains(c)) {
				if (map.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		if (stack.isEmpty()) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		String str = "{}{({})}";
		System.out.println(validParentheses(str));
	}
}
