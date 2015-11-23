package twoSumA;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Zhaolong Zhong Nov 23, 2015
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int sum) {
		if (nums == null || nums.length < 2) return null;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.keySet().contains(sum - nums[i])) {
				return new int[] {map.get(sum - nums[i]), i};
			} else {
				map.put(nums[i], i);
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 7, 8, 4, 5, 6};
		int sum = 7;
		int [] res = TwoSum.twoSum(nums, sum);
		System.out.println(Arrays.toString(res));
	}
}
