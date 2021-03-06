package a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhaolong Zhong May 26, 2016
 * 
 * Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * Two sum count:
 * Assume all the integer are unique
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return new int[0];
		}
		
		int[] result = new int[2];
		
		// value and index map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			
			map.put(nums[i], i);
		}
		
		return result;
	}
	
	public int twoSumCount(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		
		for (int n : nums) {
			if (set.contains(target - n)) {
				count++;
			} else {
				set.add(n);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		TwoSum solution = new TwoSum();
		
		int[] nums = {1, 2, 3, 4, 5, 6};
		int target = 6;
		
		System.out.println(solution.twoSumCount(nums, target));
	}
}
