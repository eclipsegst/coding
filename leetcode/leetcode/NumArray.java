package leetcode;

/**
 * @author Zhaolong Zhong Nov 29, 2015
 */
public class NumArray {
	private int[] sum;
	
	public NumArray(int[] nums) {
		this.sum = new int[nums.length];
		int s = 0;
		for (int i = 0; i < nums.length; i++) {
			s += nums[i];
			sum[i] = s;
		}
	}
	
	public int sumRange(int i, int j) {
		return i == 0 ? sum[j] : sum[j] - sum[i-1];
	}
}
