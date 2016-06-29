package challenge;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jun 28, 2016
 * 
 * Range Addition
 * 
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 * Example:
 * 
 * Given:
 * 	length = 5,
 *  updates = [
 *      [1,  3,  2],
 *      [2,  4,  3],
 *      [0,  2, -2]
 *      ]
 * Output:
 *  [-2, 0, 3, 5, 3]
 * 
 * Explanation:
 * Initial state:
 * [ 0, 0, 0, 0, 0 ]
 * After applying operation [1, 3, 2]:
 * [ 0, 2, 2, 2, 0 ]
 * After applying operation [2, 4, 3]:
 * [ 0, 2, 5, 5, 3 ]
 * After applying operation [0, 2, -2]:
 * [-2, 0, 3, 5, 3 ]
 * 
 * Hint:
 * 1. Thinking of using advanced data structures? You are thinking it too complicated.
 * 2. For each update operation, do you really need to update all elements between i and j?
 * 3. Update only the first and end element is sufficient.
 * 4. The optimal time complexity is O(k + n) and uses O(1) extra space.
 * 
 * Solution:
 * 
 * nums[i...j] can be treated as nums[0...i - 1] and nums[0...j].
 * nums[i...j] increase 2 can be treated as nums[0...j] increase 2 and nums[0...i - 1] decrease 2.
 * so we can only increase nums at position j and decrease 2 at position i - 1,
 * then we can add it all from end (nums.length - 2) to start
 * 
 * Reference:
 * https://leetcode.com/discuss/111356
 */
public class RangeAddition {
	
	// O(k + n)
	public int[] getModifiedArray(int length, int[][] updates) {
		if (length == 0) {
        	return new int[0];
        }
		
		int[] result = new int[length];
        
		for (int[] update : updates) {
			result[update[1]] += update[2];
			
			if (update[0] > 0) {
				result[update[0] - 1] -= update[2];
			}
		}
		
		int sum = result[length - 1];
		
		for (int i = length - 2; i >= 0; i--) {
			int t = sum + result[i];
			result[i] += sum;
			sum = t;
		}    
        
        return result;
	}
	
	public int[] getModifiedArraySlow(int length, int[][] updates) {
        if (length == 0) {
        	return new int[0];
        }
        
        int[] result = new int[length];
        Arrays.fill(result, 0);
        
        for (int[] row : updates) {
        	int start = row[0];
        	int end = row[1];
        	int value = row[2];
        	
        	for (int i = start; i <= end; i++) {
        		result[i] += value;
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		RangeAddition solution = new RangeAddition();
		
		int length = 5;
		int[][] updates = new int[][] {
			{1, 3, 2},
			{2, 4, 3},
			{0, 2, -2}
		};
		
		int[] result = solution.getModifiedArraySlow(length, updates);
		System.out.println(Arrays.toString(result));
	}
}
