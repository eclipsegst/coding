/**
 * Author: Zhaolong Zhong
 * Date  : Feb 24, 2015 9:24:34 AM
 *
 */
package lambdas;

import java.util.Arrays;

public class Lambdas {
  public static void main(String[] args) {
    System.out.println("Case 1");
    Arrays.asList("a", "b", "d").forEach( e -> System.out.println(e));
    
    System.out.println("Case 2");
    // provide the type of the argument e
    Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));
    
    System.out.println("Case 3");
    // wrap lambda's body into square brackets if it's too complex
    Arrays.asList("a", "b", "d").forEach( e -> {
      System.out.print(e);
      System.out.print(e);
    });
    
    System.out.println("Case 5");
    // lambdas may reference the class members and local variables(implicitly making them effectively final if they are not.)
    // the two below are equivalent.
    String separator = ",";
    Arrays.asList("a", "b", "d").forEach(
        (String e) -> System.out.print(e + separator));
    
    System.out.println("Case 6");
    final String separatorFinal = ",";
    Arrays.asList("a", "b", "d").forEach(
        (String e) -> System.out.print(e + separatorFinal));
    
    // lambdas may return a value. The return statement is not required if the lambda body is just a one-liner.
    System.out.println("Case 7");
    Arrays.asList("c", "l", "a", "r", "e").sort( (e1, e2) -> e1.compareTo(e2) );
    
    System.out.println("Case 8");
    Arrays.asList("c", "l", "a", "r", "e").sort( (e1, e2) -> {
      int result = e1.compareTo(e2);
      return result;
    });
    
    String[] strs = {"c", "l", "a", "r", "e"};
    Arrays.asList(strs).sort((e1, e2) -> e1.compareTo(e2));
    Arrays.asList(strs).forEach( e -> System.out.print(e));
    
    Arrays.asList(strs).sort((e1, e2) -> e2.compareTo(e1));
    Arrays.asList(strs).forEach( e -> System.out.print(e));
    
  }
}
