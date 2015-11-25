package fiftyShadeOfCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaolong Zhong Nov 25, 2015
 */
public class TwoSum {
	// bucket to hold TwoSum data structure element.
	// space: O(n)
	private Map<Integer, Integer> map = new HashMap<>();
	
	// time: O(1)
	public void add(int val) {
		int count = map.containsKey(val) ? map.get(val) : 0;
		map.put(val, count + 1);
	}
	
	// time: O(n)
	public boolean find(int val) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (map.containsKey(val - entry.getKey())) {
				// handle duplicate key
				if (entry.getKey() == val - entry.getKey() && entry.getValue() < 2) 
					return false;
				return true;
			}
		}
		
		return false;
	}
	
	// solution 1 - HashMap
	// assumption: each input would have exactly one solution
	// time: O(n), space: O(n)
	public int[] SolutionHashMap(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]) + 1, i + 1 };
			}
			
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No solution");
	}
	
	// solution 2 - Binary Search 
	// assumption: the input array is sorted
	// time: O(n log n), space: O(1)
	public int[] SolutionBinarySearch (int[] nums, int target) {
		// assume the input is sorted, loop from left
		for (int i = 0; i < nums.length; i++) {
			int j = bsearch(nums, target - nums[i], i + 1);
			if (j != -1) {
				return new int[] { i + 1, j + 1 };
			}
		}
		
		throw new IllegalArgumentException("No solution");
	}
	
	private int bsearch(int[] nums, int key, int start) {
		int left = start;
		int right = nums.length - 1;
		while (left < right) {
			int middle = (left + right) / 2;
			if (nums[middle] < key) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		return (left == right && nums[left] == key) ? left : -1;
	}
	
	// solution 3 - Two pointers
	// assumption: the input array is sorted
	// time: O(n), space: O(1)
	public int[] SolutionTwoPointers(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int sum = nums[i] + nums[j];
			if (sum < target) {
				i++;
			} else if (sum > target){
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		
		throw new IllegalArgumentException("No solution");
	}
}
