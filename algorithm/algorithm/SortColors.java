package algorithm;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Apr 11, 2016
 */
public class SortColors {

	// naive, space is O(n)
	public void sortColorsNaive(int[] nums) {
		if (nums == null || nums.length <=1) {
			return;
		}
		
		int[] countArray = new int[3];
		
		for (int i = 0; i < nums.length; i++) {
			countArray[nums[i]]++;
		}
		
		for (int i = 1; i <= 2; i++) {
			countArray[i] += countArray[i-1];
		}
		
		int[] sorted = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int index = countArray[nums[i]] - 1;
			countArray[nums[i]] -= 1;
			sorted[index] = nums[i];
		}
		
		System.arraycopy(sorted, 0, nums, 0, nums.length);
	}
	
	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		
		int[] countArray = new int[3];
		
		for (int i = 0; i < nums.length; i++) {
			countArray[nums[i]]++;
		}
		
		int j = 0, k = 0;
		while (j <= 2) {
			if (countArray[j] != 0) {
				nums[k++] = j;
				countArray[j] -= 1;
			} else {
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		SortColors solution = new SortColors();
		int[] nums = {1, 2, 0, 1, 0, 1, 2, 0, 1};
		solution.sortColorsNaive(nums);
		System.out.println(Arrays.toString(nums));
	}
}
