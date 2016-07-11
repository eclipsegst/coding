package challenge;

/**
 * @author Zhaolong Zhong Jul 2, 2016
 * 
 * Increasing Triplet Subsequence
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * 
 * Formally the function should:
 *  Return true if there exists i, j, k 
 *  such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * 
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * 
 * Given [5, 4, 3, 2, 1],
 * return false.
 */
public class IncreasingTriplet {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int c = nums[i];
			
			if (a >= c) {
				a = c;
			} else if (b >= c) {
				b = c;
			} else {
				return true;
			}
		}
        
		return false;
    }
	
	public static void main(String[] args) {
		IncreasingTriplet solution = new IncreasingTriplet();
		int[] nums = {5, 2, 5, 5, 1, 6};
		
		System.out.println(solution.increasingTriplet(nums));
	}
}