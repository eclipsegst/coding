/**
 * Author: Zhaolong Zhong
 * Date  : 2015 10:20:59 PM
 * Problem:
 *  Given an array of integers, find if the array contains any duplicates. 
 *  Your function should return true if any value appears at least twice in the array, 
 *  and it should return false if every element is distinct.
 */
package challenge;

import java.util.HashSet;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    if (nums == null) return false;
    
    HashSet<Integer> set = new HashSet<Integer>();
    
    int i = 0;
    while (i < nums.length) {
        if (set.contains(nums[i])) {
            return true;
        } else {
            set.add(nums[i]);
        }
        i++;
    }
    
    return false;
  }
}
