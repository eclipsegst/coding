package challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong May 23, 2016
 * 
 * Intersection of Two Arrays
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 */
public class Intersection {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int i = 0, j = 0;
		Set<Integer> set = new HashSet<>();
		
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		
		int[] result = new int[set.size()];
		
		int k = 0;
		for (int n : set) {
			result[k] = n;
			k++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Intersection solution = new Intersection();
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		
		int[] result = solution.intersection(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
}
