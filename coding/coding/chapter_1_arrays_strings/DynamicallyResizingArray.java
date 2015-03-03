/**
 *  Author: Zhaolong Zhong
 *  Date  : Mar 2, 2015 8:30:13 PM
 *  
 */
package chapter_1_arrays_strings;
import java.util.ArrayList;

public class DynamicallyResizingArray {
  // ArrayList provides O(1) access
  // when resizing, it takes O(n) time
  public ArrayList<String> merge(String[] word, String[] more) {
    ArrayList<String> result = new ArrayList<String>();
    for (String s : word) result.add(s);
    for (String s : more) result.add(s);
    return result;
  }
}
