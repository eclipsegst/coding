package challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zhaolong Zhong May 23, 2016
 * 
 * Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class FindKthLargest {
	// O(nlogk)
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k) {
			return Integer.MIN_VALUE;
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
		
		for (int n : nums) {
			queue.offer(n);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		
		return queue.peek();
	}
	
	public static void main(String[] args) {
		FindKthLargest solution = new FindKthLargest();
		
		int[] nums = {3,2,1,5,6,4};
		System.out.println(solution.findKthLargest(nums, 2));
	}
}
