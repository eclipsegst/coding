/**
 * Author : Zhaolong Zhong
 * Date   : Jan 29, 2015 8:26:32 PM
 * 
 * Problem:
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *  [1],
 *  [1,1],
 *  [1,2,1],
 *  [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
package pascalTriangle;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {
  
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Integer[] prev = null;
    for(int i = 1; i <= numRows; i++){
      Integer[] row = new Integer[i];
      row[0] = 1;
      row[i - 1] = 1;
      for(int j = 1; j < i - 1; j++){
        row[j] = prev[j] + prev[j -1];
      }
      res.add(new ArrayList<Integer>(Arrays.asList(row)));
      prev = row;
    }
    return res;
  }
  
  public static void main(String[] args) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    res = generate(2);
    System.out.println(res.size());
  }
}
