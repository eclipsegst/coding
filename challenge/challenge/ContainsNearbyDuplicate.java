/**
 * Author : Zhaolong Zhong
 * Date   : 2015 10:45:23 PM
 * Problem:
 * Given an array of integers and an integer k, find out 
 * whether there there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
package challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsNearbyDuplicate {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    int i = 0;
    while (i < nums.length) {
      List<Integer> listOfIndex = map.get(nums[i]);
      
      if (listOfIndex == null) {    // there's no duplicate
        listOfIndex = new ArrayList<>();
        map.put(nums[i], listOfIndex);
      } else {  // there's duplicate
        for (int j : listOfIndex) {
          if (i - j <= k) {
            return true;
          }
        }
      }
      listOfIndex.add(i);   // add the index for current value
      i++;
    }
    
    return false;
  }
}
