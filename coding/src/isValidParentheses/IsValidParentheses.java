package isValidParentheses;

import java.util.HashMap;
import java.util.Stack;

public class IsValidParentheses {	
	public static void main(String[] args){
		System.out.println(valid.isValid("(([]))"));
	}
}

class valid{
	public static boolean isValid(String s){
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		hm.put('(', ')');
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(hm.keySet().contains(c)){ // check if the character is parentheses
				stack.push(c);
			} else if(hm.values().contains(c)){
				if(!stack.empty() && hm.get(stack.peek()) == c){
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		return stack.empty();
	}
}