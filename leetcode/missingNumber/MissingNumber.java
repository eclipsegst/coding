package missingNumber;

/**
 * @author Zhaolong Zhong Nov 17, 2015
 * Give an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement 
 * it using only constant extra space complexity?
 * 
 * Hint: XOR operator
 * If A ^ B = C then A = B ^ C, and B = A ^ C, and A ^ A = 0, 0 ^ A = A
 */
public class MissingNumber {
	public static int missingNumber(int[] nums) {
		int r = 0;
		for (int i = 0; i< nums.length; i++) {
			r ^= i ^ nums[i];
		}
		
		return r ^ nums.length;
	}
	
	public static void main (String[] args) {
		int[] nums = new int[]{0, 3, 5, 4, 2};
		System.out.println(missingNumber(nums));
	}
}
