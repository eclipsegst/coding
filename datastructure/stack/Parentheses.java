/**
 * Author: Zhaolong Zhong
 * Date  : 2015 9:29:27 PM
 */
package stack;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;

public class Parentheses {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    
    Scanner stdin = new Scanner(new BufferedInputStream(System.in));
    String str = "";
    while (stdin.hasNext()) {
      str = stdin.next();
      HashMap<Character, Character> map = new HashMap<Character, Character>();
      map.put('{', '}');
      map.put('[', ']');
      map.put('(', ')');
        
      int i = 0;
      Stack<Character> stack = new Stack<Character>();
      while (i < str.length()) {
        char c = str.charAt(i);
        if (map.containsValue(c)) {
          if (map.get(stack.peek()) == c) {
            stack.pop();
          } else {
            stack.add(c);
          }
        } else {
          stack.add(c);
        }
        i++;
      }
      System.out.println(stack.empty());
    }
  }
}
