package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhaolong Zhong May 31, 2016
 * 
 * Majority Element II
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 * Hint:
 * How many majority elements could it possibly have?
 */
public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		int c1 = 0, c2 = 0, count1 = 0, count2 = 0;
		
		for (int n : nums) {
			if (count1 == 0) {
				c1 = n;
			} else if (count2 == 0) {
				c2 = n;
			}
			
			if (c1 == n) {
				count1++;
			} else if (c2 == n) {
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		
		// verify
		count1 = 0;
		count2 = 0;
		
		for (int n : nums) {
			if (c1 == n) {
				count1++;
			} else if (c2 == n) {
				count2++;
			}
		}
		
		if (count1 > nums.length/3) {
			result.add(c1);
		}
		if (count2 > nums.length/3) {
			result.add(c2);
		}
		
		return result;
	}
	
	public List<Integer> majorityElementK(int[] nums) {
		return majorityElementHelper(nums, 3);
	}
	
	public List<Integer> majorityElementHelper(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else if (map.keySet().size() < k - 1) {
				map.put(n, 1);
			} else {
				boolean flag = false;
				for (int i : map.keySet()) {
					if (map.get(i) == 0) {
						map.remove(i);
						map.put(n, 1);
						flag = true;
						break;
					}
				}
				
				if (!flag) {
					for (int i : map.keySet()) {
						map.put(i,  map.get(i) - 1);
					}
				}
			}
		}
		
		for (int i : map.keySet()) {
			map.put(i, 0);
		}
		
		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			}
		}
		
		for (int i : map.keySet()) {
			if (map.get(i) > nums.length / k) {
				result.add(i);
			}
		}
		
		return result;
	}
}
