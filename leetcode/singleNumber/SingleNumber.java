package singleNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaolong Zhong Nov 17, 2015
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it 
 * without using extra memory?
 */
public class SingleNumber {

	public int singleNumberHash(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.remove(nums[i]);
			} else {
				map.put(nums[i], nums[i]);
			}
		}
		
		for(int i : map.keySet()) {
			return map.get(i);
		}
		return 0;
	}
	
	public int singleNumber(int[] nums) {
		int r = 0;
		for (int i = 0; i < nums.length; i++) {
			r ^= nums[i];
		}
		
		return r;
	}
}
