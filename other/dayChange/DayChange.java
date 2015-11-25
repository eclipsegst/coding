package dayChange;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 */
public class DayChange {
	public static int[] dayChange(int[] nums, int n) {
		if (nums == null || n <= 0) return nums;
		int length = nums.length;
		int[] res = new int[length+2];
		res[0] = 0;
		res[length+1] = 0;
		
		// copy to new array
		for (int i = 1; i <= length; i++) {
			res[i] = nums[i-1];
		}
		
		// change
		for (int i = 0; i < n; i++) {
			int pre = res[0];
			for (int j = 1; j <= length; j++) {
				int tmp = res[j];
				res[j] = pre^res[j+1];
				pre = tmp;
			}
		}
		
		return Arrays.copyOfRange(res, 1, length + 1);
	}
	
	public static void main (String[] args) {
		int[] nums = new int[] {1, 0, 0, 0, 0, 1, 0, 0};
		System.out.println(Arrays.toString(dayChange(nums, 1)));
	}
}
