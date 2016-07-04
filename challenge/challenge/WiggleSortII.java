package challenge;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jul 3, 2016
 * 
 * Wiggle Sort II
 * 
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 *
 * Reference:
 * https://discuss.leetcode.com/topic/33084
 */
public class WiggleSortII {
	public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int[] temp = Arrays.copyOf(nums, n);
        int index = 0;
        for (int i = 0; i <= mid; i++) {
        	nums[index] = temp[mid - i];
        	if (index + 1 < n) {
        		nums[index + 1] = temp[n - i - 1];
        	}
        	
        	index += 2;
        }
    }
	
	public static void main(String[] args) {
		WiggleSortII solution = new WiggleSortII();
		
		int[] nums1 = {1, 5, 1, 1, 6, 4};
		solution.wiggleSort(nums1);
		System.out.println(Arrays.toString(nums1));
		
		int[] nums2 = {1, 3, 2, 2, 3, 1};
		solution.wiggleSort(nums2);
		System.out.println(Arrays.toString(nums2));
	}
}
