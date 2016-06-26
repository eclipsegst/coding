package a;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Product of Array Except Self
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductExceptSelf {
	//Runtime: O(n), space: O(n)
	public int[] productExceptSelfSimple(int[] nums) {
        int[] result = new int[nums.length];
        
        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];
        
        t1[0] = 1;
        t2[nums.length - 1] = 1;
        
        //scan from left to right
        for (int i = 0; i < nums.length - 1; i++) {
        	t1[i + 1] = nums[i] * t1[i];
        }
        
        //scan from right to left
        for (int i = nums.length - 1; i > 0; i--) {
        	t2[i - 1] = t2[i] * nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
        	result[i] = t1[i] * t2[i];
        }
        
        return result;
    }
	
	//Runtime: O(n), space: O(n)
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		result[nums.length - 1] = 1;
		
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}
		
		int left = 1;
		
		for (int i = 0; i < nums.length; i++) {
			result[i] = result[i] * left;
			left = left * nums[i]; //keep tracking of all the left side multiply result
		}
		
		return result;
	}
	
	public void productExceptSelfTwo(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int[] result = new int[nums.length];
		result[nums.length - 1] = 1;
		
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}
		
		int left = 1;
		
		for (int i = 0; i < nums.length; i++) {
			result[i] = result[i] * left;
			left *= nums[i];
		}
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = result[i];
		}
	}
}
