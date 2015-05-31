/**
 * Author: Zhaolong Zhong
 * Date  : 2015 9:29:27 PM
 */
package stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Parentheses {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    
    Scanner stdin = new Scanner(System.in);
    String str = "";
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    map.put('{', '}');
    map.put('[', ']');
    map.put('(', ')');

    while (stdin.hasNext()) {
      str = stdin.next();
      int i = 0;
      Stack<Character> stack = new Stack<Character>();
      while (i < str.length()) {
        char c = str.charAt(i);
        if (map.keySet().contains(c)) {
          stack.add(c);
        } else {
          if (!stack.empty()) {
            if (map.keySet().contains(stack.peek())) {
              if (map.get(stack.peek()) == c) {
                stack.pop();
              } else {
                stack.add(c);
              }
            }
          } else {
            stack.add(c);
          }
        }
        i++;
      }
      System.out.println(stack.empty());
    }
  }
}
