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
	
	// Two(or three) pointers, time:O(n), space:O(1)
	public void sortColorBetter(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		
		int nr = 0, nb = nums.length - 1;
		
		// find the fist element that is not red
		while (nr < nums.length && nums[nr]==0) {
			nr++;
		}
		
		// find the first element from left that is not blue
		while (nb >=0 && nums[nb]==2) {
			nb--;
		}
		
		int i = nr;
		
		while (i <= nb) {
			if (nums[i] == 0) {
				swap(nums, i, nr);
				nr++;
				i++;
			} else if (nums[i] == 2) {
				swap(nums, i, nb);
				nb--;
			} else {
				i++;
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	public static void main(String[] args) {
		SortColors solution = new SortColors();
		int[] nums = {0, 0, 1, 2, 0, 1, 0, 1, 2, 0, 1, 2, 2};
		int[] numsBetter = {0, 0, 1, 2, 0, 1, 0, 1, 2, 0, 1, 2, 2};
		solution.sortColorsNaive(nums);
		solution.sortColorBetter(numsBetter);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(numsBetter));
	}
}
