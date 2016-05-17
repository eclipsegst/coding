package fifty;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Zhaolong Zhong Dec 15, 2015
 */
public class ValidParentheses {
	public boolean isValid (String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || map.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
