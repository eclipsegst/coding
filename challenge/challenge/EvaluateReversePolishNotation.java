/**
 * Author : Zhaolong Zhong
 * Date   : Feb 16, 2015 9:42:03 PM
 * Problem:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand maybe an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 */
package challenge;
import java.util.Stack;
import java.util.HashMap;
public class EvaluateReversePolishNotation {
  public static int evalRPN(String[] tokens) {
    if (tokens.length == 1) return Integer.parseInt(tokens[0]);
    int res = 0;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("+", 0);
    map.put("-", 1);
    map.put("*", 2);
    map.put("/", 3);
    
    int t;
    Stack<String> s = new Stack<String>();
    for (int i = 0; i < tokens.length; i ++) {
      if (!map.keySet().contains(tokens[i])) {
        s.push(tokens[i]);
      } else {
        if (map.get(tokens[i]) == 0) {
          t = Integer.parseInt(s.pop());
          res = Integer.parseInt(s.pop()) + t;
          s.push(Integer.toString(res));
        } else if (map.get(tokens[i]) == 1) {
          t = Integer.parseInt(s.pop());
          res = Integer.parseInt(s.pop()) - t;
          s.push(Integer.toString(res));
        } else if (map.get(tokens[i]) == 2) {
          t = Integer.parseInt(s.pop());
          res = Integer.parseInt(s.pop()) * t;
          s.push(Integer.toString(res));
        } else {
          t = Integer.parseInt(s.pop());
          res = Integer.parseInt(s.pop()) / t;
          s.push(Integer.toString(res));
        }
      }
    }
    return res;
  }
  
  public static void main(String[] args) {
    String[] s1 = {"2", "1", "+", "3", "*"};
    String[] s2 = {"4", "13", "5", "/", "+"};
    System.out.println(evalRPN(s1));
    System.out.println(evalRPN(s2));
  }
}
