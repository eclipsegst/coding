package fiftyShadeOfCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhaolong Zhong Dec 15, 2015
 */
public class SingleNumber {
	
	// O(n) runtime - hash map
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			int count = map.containsKey(n) ? map.get(n) : 0;
			map.put(n, count + 1);
		}
		
		for (int n : nums) {
			if (map.get(n) == 1) {
				return n;
			}
		}
		throw new IllegalArgumentException("no single element");
	}
	
	// O(n) runtime - hash set
	public int singleNumberBetter(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (set.contains(n)) {
				set.remove(n);
			} else {
				set.add(n);
			}
		}
		return set.iterator().next();
	}
	
	// xor
	public int singleNumberBit(int[] nums) {
		int num = 0;
		for (int n : nums) {
			num ^= n;
		}
		return num;
	}
	
	// single number not appear three times
	public int singleNumberThree(int nums[], int n) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < nums.length; i++) {
			twos |= ones & nums[i];
			ones ^= nums[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
}
