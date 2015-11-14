package moveZeroes;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Nov 14, 2015
 * 
 * Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums 
 * should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of of operations.
 */
public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;
		
		int totalZeroes = 0;
		int leftNonZero = 0;
		
		// move all the non zero to left in order
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				if (i > leftNonZero) nums[leftNonZero] = nums[i];
				leftNonZero++;
			} else {
				totalZeroes++;
			}
		}
		
		// set tailing zeroes
		for (int j = nums.length - totalZeroes; j < nums.length; j++) {
			if (nums[j] != 0) nums[j] = 0;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 0, 3, 2, 0, 5};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
