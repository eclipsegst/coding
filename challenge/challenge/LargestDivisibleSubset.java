package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhaolong Zhong Jun 27, 2016
 * 
 * Largest Divisible Subset
 * 
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * 
 * Example 2:
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 * 
 * Solution:
 * 1. sort array, a < b < c
 * 2. if a < b and b % a == 0, b < c and c % b == 0, then c % a == 0
 * 3. keep tracking of maximum number of subset at index i,
 * 4. if nums[i] > nums[j], nums[i] % [j] == 0, dp[i] = max(dp[j] + 1, dp[i])
 * 
 * Similar problem:
 * Longest Increasing Subsequence
 */
public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
		
        if (nums == null || nums.length == 0) {
        	return result;
        }
        
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length], index = new int[nums.length];
        dp[0] = 1;
        index[0] = -1;
        
        int max = 1, end = 0;
        
        for (int i = 1; i < nums.length; i++) {
        	for (int j = 0; j < i; j++) {
        		if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
    				dp[i] = dp[j] + 1;
    				index[i] = j;
        		}
        	}
        	
        	if (max < dp[i]) {
				max = dp[i];
				end = i;
			}
        }
        
        while (end >= 0) {
        	result.add(nums[end]);
        	end = index[end];
        }
        
        return result;
	}
	
	public static void main(String[] args) {
		LargestDivisibleSubset solution = new LargestDivisibleSubset();
		
		int[] nums1 = {1, 2, 3};
		int[] nums2 = {1, 2, 4, 8};
		
		System.out.println(Arrays.toString(solution.largestDivisibleSubset(nums1).toArray()));
		System.out.println(Arrays.toString(solution.largestDivisibleSubset(nums2).toArray()));
	}
}
