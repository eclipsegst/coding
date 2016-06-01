package a;

/**
 * @author Zhaolong Zhong May 31, 2016
 * 
 * Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		int n = nums[0];
		int count = 1;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == n) {
				count++;
			} else if (count > 1) {
				count--;
			} else {
				n = nums[i];
			}
		}
		
		return n;
	}
}
