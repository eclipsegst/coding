package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Zhaolong Zhong Jun 30, 2016
 * 
 * Contains Duplicate III
 * 
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference 
 * between i and j is at most k.
 * 
 * Solution:
 * Use a TreeSet to maintain a a window of size k (index difference), 
 * we check if the number difference exists in the window 
 * 
 * Reference:
 * https://leetcode.com/discuss/38177
 * https://leetcode.com/discuss/38206
 */
public class ContainsDuplicateIII {
	// O(N log k), since simple queries of TreeSet is O(log k)
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0) {
        	return false;
        }
        
        TreeSet<Integer> values = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	Integer floor = values.floor(nums[i] + t);
        	Integer ceil = values.ceiling(nums[i] - t);
        	
        	if ((floor != null && floor >= nums[i])
        			|| (ceil != null && ceil <= nums[i])) {
        		return true;
        	}
        	
        	values.add(nums[i]);
        	// maintain window size k
        	if (i >= k) {
        		values.remove(nums[i - k]);
        	}
        }
        
        return false;
    }
	
	// Time: O(N), Space: O(k)
	public boolean containsNearbyAlmostDuplicateBucket(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 1 || t < 0) {
        	return false;
        }
		
		Map<Long, Long> map = new HashMap<Long, Long>();
		
		for (int i = 0; i < nums.length; i++) {
			long mapped = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = mapped / ((long) t + 1);
			
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && mapped - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - mapped <= t)) {
				return true;
			}
			
			// maintain window size k
			if (map.size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			
			map.put(bucket, mapped);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		TreeSet<Integer> values = new TreeSet<Integer>();
		Integer floor = values.floor(Integer.MAX_VALUE + 2);
		System.out.println(floor);
	}
}
