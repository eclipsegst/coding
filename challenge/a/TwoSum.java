package a;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong May 26, 2016
 * 
 * Assume all the integer are unique
 */
public class TwoSum {
	public int twoSum(int[] nums, int target) {
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
		
		System.out.println(solution.twoSum(nums, target));
	}
}
