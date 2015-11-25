package cacheMiss;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 */
public class CacheMiss {
	public static int cacheMiss(int[] nums, int size) {
		if (nums == null) return 0;
		List<Integer> cache = new LinkedList<Integer>();
		
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (cache.contains(nums[i])) {
				cache.remove(new Integer(nums[i]));
			} else {
				count++;
				if (size == cache.size()) 
					cache.remove(0);
			}
			cache.add(nums[i]);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 4, 5, 4, 1};
		System.out.println(cacheMiss(nums, 4));
	}
}
