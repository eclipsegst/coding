package sort;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong
 * Date: 2:28:16 PM Jul 27, 2015
 * 
 * Insertion Sort
 * Time complexity: O(n^2)
 * Worst case performance: 
 * 	when the array is descending order, there will be 1 + 2 + ... N - 1 swaps (N(N -1)/2)).
 * 	each swap is O(1), so f(n) = O(n^2)
 */

public class InsertionSort {
	
	private static void insertionSort(Integer nums[], int n) {
		if (nums ==null || nums.length <= 0 || n <= 0) return;
		
		for (int i = 0; i < n; i++) { 
			int j = i;
			int t = 0;
			while (j > 0 && nums[j] < nums[j - 1]) { // at most N(N - 1)/2 steps
				t = nums[j - 1];
				nums[j - 1] = nums[j];
				nums[j] = t;
				j--;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] nums = {3, 1, 5, 4, 0, 2};
		insertionSort(nums, 6);
		Arrays.asList(nums).forEach((Integer e) -> System.out.print(e + " "));
	}

}
