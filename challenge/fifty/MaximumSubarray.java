package fifty;

/**
 * @author Zhaolong Zhong Dec 16, 2015
 */
public class MaximumSubarray {
	
	// O(n) runtime, O(1) space, dynamic programming
	// f(k) = max(f(k - 1) + A[k], A[k])
	public int maxSumSubarray(int[] nums) {
		int max = nums[0], res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max + nums[i], nums[i]);
			res = Math.max(max, res);
		}
		return res;
	}
	
	// O(n) runtime, O(1) space, dynamic programing
	// f(k) = max(f(k-1) * A[k], A[k], g(k-1) * A[k])
	// g(k) = min(g(k-1) * A[k], A[k], f(k-1) * A[k])
	public int maxProductSubarray(int[] nums) {
		int max = nums[0], min = nums[0], res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int m = max, n = min;
			max = Math.max(Math.max(m * nums[i], nums[i]), n * nums[i]);
			min = Math.min(Math.min(m * nums[i], nums[i]), n * nums[i]);
			res = Math.max(max, res);
		}
		return res;
	}
}
