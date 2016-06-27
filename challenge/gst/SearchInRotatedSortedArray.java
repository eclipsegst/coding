package gst;

/**
 * @author Zhaolong Zhong Jun 27, 2016
 * 
 * Search in Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
	
	public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
        	int mid = (left + right) / 2;
        	if (nums[mid] == target) {
        		return mid;
        	}
        	
        	// case: 0 1 2 4(mid) 5 6 7
        	if (nums[mid] >= nums[left]) {
        		if (nums[left] <= target && target <= nums[mid]) {
        			right = mid - 1;
        		} else {
        			left = mid + 1;
        		}
        	} 
        	// case: 6 7 0 1(mid) 2 4 5
        	else {
        		if (nums[mid] < target && target <= nums[right]) {
        			left = mid + 1;
        		} else {
        			right = mid - 1;
        		}
        	}
        }
        
        return -1;
	}
}
