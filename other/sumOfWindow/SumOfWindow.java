package sumOfWindow;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 */
public class SumOfWindow {
	public static int[] sumOfWindow(int[] nums, int k) {
		if (nums == null || nums.length < k || k <= 0) return null;
		int[] res = new int[nums.length-k+1];
		// calculate the first element of the result
		for (int i = 0; i < k; i++) {
			res[0] += nums[i];
		}
		
		// calculate the rest
		for (int i = 1; i < res.length; i++) {
			// the current element is the sum of the part of previous element
			// and the right of the window edge
			res[i] = res[i-1] - nums[i-1] + nums[i+k-1];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {4, 2, 73, 11, -5};
		int[] res2 = sumOfWindow(nums, 2);
		System.out.println("window size 2: " + Arrays.toString(res2));
		int[] res3 = sumOfWindow(nums, 3);
		System.out.println("window size 3: " + Arrays.toString(res3));
	}
}
