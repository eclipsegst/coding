package isValidParentheses;

import java.util.HashMap;
import java.util.Stack;

/* Problem:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * Solution:
 * use HashMap to store parentheses template
 * use a stack to store temporary character
 * if left parentheses, push to the stack
 * else check if it's in value set
 * get the value by peek the stack
 * compare the two
 * */

public class IsValidParentheses {	
	public static void main(String[] args){
		System.out.println(valid.isValid("(]"));
		System.out.println(valid.isValid("([(]))"));
		System.out.println(valid.isValid("()[]{}"));
		System.out.println(valid.isValid("(([]))"));
	}
}

class valid{
	public static boolean isValid(String s){
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		hm.put('(', ')');
		hm.put('[', ']');
		hm.put('{', '}');
		
		Stack<Character> stack = new Stack<Character>();
		
		//char [] charArray = s.toCharArray(); //we can use those two lines to replace the following two lines below. 
		//for(Character c: charArray){
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);		// s.charAt(i), convert the item at string s position i to char
			if(hm.keySet().contains(c)){// check if the character is parentheses; keySet() get all of keys in hashmap
				stack.push(c);
			} else if(hm.values().contains(c)){					//hm.values() get all the values in hashmap
				if(!stack.empty() && hm.get(stack.peek()) == c){//hm.get(byKey), get the value by a key
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		return stack.empty();
	}
}