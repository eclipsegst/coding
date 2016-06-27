package challenge;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jun 27, 2016
 * 
 * Longest Increasing Subsequence
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * Reference:
 * https://leetcode.com/discuss/74510
 * https://leetcode.com/discuss/72127
 * https://leetcode.com/discuss/67609
 */
public class LongestIncreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int dp[] = new int[nums.length];
		Arrays.fill(dp, 1);
		
		int longest = 1;
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			
			if (dp[i] > longest) {
				longest = dp[i];
			}
		}
		
		
		return longest;
    }
	
	// DP with binary search
	// O(n log n)
	public int lengthOfLISBinary(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] increasingSequence = new int[nums.length];
		int len = 0;
		increasingSequence[len++] = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > increasingSequence[len - 1]) {
				increasingSequence[len++] = nums[i];
			} else {
				int pos = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
				increasingSequence[pos] = nums[i];
			}
		}
		
		return len;
    }
	
	private int findPositionToReplace(int[] nums, int low, int high, int x) {
		int mid;
		
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] > x) {
				high = mid - 1;
			} else if (nums[mid] < x) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		
		return low;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		
		System.out.println(solution.lengthOfLIS(nums));
		System.out.println(solution.lengthOfLISBinary(nums));
	}
}
