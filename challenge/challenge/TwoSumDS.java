package challenge;
import java.util.Map;
import java.util.HashMap;
/*
 *  Date: 2015-01-27 20:16
 * 
 *  Problem:
 *  Design an structure that you can add integers and you have an function
 *  that can find if a target value is the sum of the two integers in the structure.
 *  
 *  O(1) find
 *  O(1) add
 *  O(n) space
 */

public class TwoSumDS {
  Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
  public void add(int number) {
    Integer c = nums.get(number);
    if (c == null) c = 0;
    c++;
    nums.put(number,  c);
  }
  
  public boolean find (int value) {
    for(Integer n : nums.keySet()){
      Integer c = nums.get(value - n);
      if (c == null) continue;
      if (value - n == n) {
        if(c > 1) {
          return true;
        }
      } else {
        return true;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    TwoSumDS twoSum = new TwoSumDS();
    twoSum.nums.put(0, 0);
    twoSum.add(-1);
    twoSum.add(-1);
    twoSum.add(0);
    twoSum.add(1);
    twoSum.add(4);
    System.out.println(twoSum.find(3));
  }
}
