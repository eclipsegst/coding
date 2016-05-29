package a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong May 28, 2016
 */
public class RemoveDuplicate {
	public int[] removeDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (int n : nums) {
			set.add(n);
		}
		
		int[] result = new int[set.size()];
		int i = 0;
		for (int n : set) {
			result[i++] = n;
		}
		return result;
	}
	
	public int[] removeDuplicateInOriginalOrder(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		
		Set<Integer> set = new LinkedHashSet<>();
		
		for (int n : nums) {
			set.add(n);
		}
		
		int[] result = new int[set.size()];
		int i = 0;
		for (int n : set) {
			result[i++] = n;
		}
		return result;
	}
	
	public static void main(String[] args) {
		RemoveDuplicate solution = new RemoveDuplicate();
		
		int[] nums = {5, 2, 1, 3, 1, 4, 2};
		
		System.out.println(Arrays.toString(solution.removeDuplicate(nums)));
		System.out.println(Arrays.toString(solution.removeDuplicateInOriginalOrder(nums)));
	}
}
