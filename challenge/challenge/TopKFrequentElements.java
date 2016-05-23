package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Zhaolong Zhong May 23, 2016
 * 
 * Tok K Frequent Elements
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
	static class FE {
		public int value;
		public int count;
		public FE(int value, int count) {
			this.value = value;
			this.count = count;
		}
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (nums == null || nums.length == 0 || k > nums.length || k < 1) {
			return result;
		}
		
		// O(n)
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : nums) {
			if (map.keySet().contains(n)) {
				int count = map.get(n);
				map.put(n, count + 1);
			} else {
				map.put(n, 1);
			}
		}
		
		// O(n)
		PriorityQueue<FE> queue = new PriorityQueue<FE>(k, new Comparator<FE>() {
			@Override
			public int compare(FE fe1, FE fe2) {
				return fe1.count - fe2.count;
			}
		});
		
		// O(n)
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			FE fe = new FE(entry.getKey(), entry.getValue());
			queue.offer(fe);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		
		while (!queue.isEmpty()) {
			result.add(queue.poll().value);
		}
		
		Collections.reverse(result);
		
		return result;
	}
	
	public static void main(String[] args) {
		TopKFrequentElements solution = new TopKFrequentElements();
		
		int[] nums = {1, 1, 1, 2, 2, 3};
		List<Integer> result = solution.topKFrequent(nums, 2);
		System.out.println(Arrays.asList(result).toString());
	}
}
