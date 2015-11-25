package fourInteger;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 * Given an array s with four integers a, b, c, d, shuffle them in some order. If the integer are unique, then there are 24 shuffles. 
 * Make F(s) = abs(s[0] - s[1]) + abs(s[1] - s[2]) + abs(s[2] - s[3]) to be largest.
 * For example, a = 5, b = 3, c = -1, d = 5. F[s] = 14.
 */
public class FourInteger {
	public static int[] fourInteger(int[] nums) {
		Arrays.sort(nums);
		swap(nums, 0, 1);
		swap(nums, 2, 3);
		swap(nums, 0, 3);
		return nums;
	}
	
	private static void swap(int[] nums, int i, int j) {
//		int t = nums[i];
//		nums[i] = nums[j];
//		nums[j] = t;
		
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {-1, 3, 5, 5};
		System.out.println(Arrays.toString(fourInteger(nums)));
	}
}
