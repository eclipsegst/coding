package challenge;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jun 30, 2016
 * 
 * Sort Transformed Array
 * 
 * Given a sorted array of integers nums and integer values a, b and c. 
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * 
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33]
 * 
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * Result: [-23, -5, 1, 7]
 * 
 * Reference:
 * https://leetcode.com/discuss/108831
 */
public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        
        while (i <= j) {
        	if (a >= 0) {
        		result[index--] = calculalte(nums[i], a, b, c) >= calculalte(nums[j], a, b, c) ? 
        				calculalte(nums[i++], a, b, c) : calculalte(nums[j--], a, b, c);
        	} else {
        		result[index++] = calculalte(nums[i], a, b, c) >= calculalte(nums[j], a, b, c) ? 
        				calculalte(nums[j--], a, b, c) : calculalte(nums[i++], a, b, c);
        	}
        }
        
        return result;
    }
	
	private int calculalte(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
	
	public static void main(String[] args) {
		SortTransformedArray solution = new SortTransformedArray();
		
		int[] nums = {-4, -2, 2, 4};
		int a = 1, b = 3, c = 5;
		
		int[] result = solution.sortTransformedArray(nums, a, b, c);
		System.out.println(Arrays.toString(result));
	}
}
