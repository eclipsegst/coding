/**
 * Author : Zhaolong Zhong
 * Date   : Jan 29, 2015 9:37:43 PM
 * 
 * Problem:
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1]
 * Note: Could you optimize your algorithm to use only O(k) extra space.
 */
package challenge;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PascalTriangleTwo {
  public static List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<Integer>();
    Integer[] prev = null;
    for(int i = 1; i <= rowIndex + 1; i++){
      Integer[] row = new Integer[i];
      row[0] = 1;
      row[i - 1] = 1;
      for(int j = 1; j < i - 1; j++){
        row[j] = prev[j - 1] + prev[j];
      }
      prev = row;
      res = Arrays.asList(row);
    }
    return res;
  }
  
  public List<Integer> getRowTwo(int rowIndex) {
    Integer[] row = new Integer[rowIndex + 1];
    Arrays.fill(row, 1);
    for(int i = 0; i < rowIndex - 1; i++){
      for(int j = i + 1; j >= 1; j--){
        row[j] = row[j] + row[j - 1];
      }
    }
    return Arrays.asList(row);
  }
  
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    list = getRow(3);
    System.out.println(Arrays.toString(list.toArray()));
  }
  
}
