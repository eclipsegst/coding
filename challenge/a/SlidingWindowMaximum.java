package a;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Sliding Window Maximum
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 	1 [3  -1  -3] 5  3  6  7       3
 * 	1  3 [-1  -3  5] 3  6  7       5
 * 	1  3  -1 [-3  5  3] 6  7       5
 * 	1  3  -1  -3 [5  3  6] 7       6
 * 	1  3  -1  -3  5 [3  6  7]      7
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * Follow up:
 * Could you solve it in linear time?
 * Hint:
 * 
 * 1. How about using a data structure such as deque (double-ended queue)?
 * 2. The queue size need not be the same as the window’s size.
 * 3. Remove redundant elements and the queue should store only elements that need to be considered.
 *
 */
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k) {
			return new int[0];
		}
		
		int[] result = new int[nums.length - k + 1];
		
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && deque.getLast() < nums[i]) {
				deque.removeLast();
			}
			
			deque.offer(nums[i]);
			
			if (i < k - 1) {
				continue;
			}
			
			result[i - k + 1] = deque.getFirst();
			
			if (result[i - k + 1] == nums[i - k + 1]) {
				deque.removeFirst();
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		SlidingWindowMaximum solution = new SlidingWindowMaximum();
		
		int[] nums = {1,3,-1,-3,5,3,6,7};
		
		int[] result = solution.maxSlidingWindow(nums, 3);
		System.out.println(Arrays.toString(result));
	}
}
