/** 
 * Author : Zhaolong Zhong
 * Date   : Feb 4, 2015 04:00:10 PM
 * Problem:
 * Given a string containing just the characters'(', ')', '{', '}', '[', ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 */

package challenge;

import java.util.HashMap;
import java.util.Stack;

public class IsValidParentheses {	
  public static boolean isValid(String s){
    HashMap<Character, Character> hm = new HashMap<Character, Character>();
    hm.put('(', ')');
    hm.put('[', ']');
    hm.put('{', '}');
    
    Stack<Character> stack = new Stack<Character>();
    
    //char [] charArray = s.toCharArray(); 
    //for(Character c: charArray){
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(hm.keySet().contains(c)){
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