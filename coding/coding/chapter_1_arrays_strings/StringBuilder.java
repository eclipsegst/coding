/**
 * Author: Zhaolong Zhong
 * Date  : Mar 2, 2015 8:39:29 PM
 *
 */
package chapter_1_arrays_strings;

public class StringBuilder {
  // what is the running time of concatenating a list strings using following algrithm
  // assume that strings are all the same length (x), there are n strings, 
  // running time: O(x + 2x + ... + nx) = O(xn(n+1)/2) or O(n^2)
  public String makeSentence(String[] words) {
    String result = "";
    for (String w : words) result += w;
    return result.toString();
  }
  
  // StringBuffer creates an array of all strings, 
  // and copy back to a string back only when necessary.
  // running time: O(n)
  public String joinWords(String[] words) {
    StringBuffer result = new StringBuffer();
    for (String w : words) result.append(w);
    return result.toString();
  }
}
