package challenge;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong May 23, 2016
 * 
 * Intersection of Two Arrays II
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to num2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionTwo {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]){
				j++;
			} else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		
		int[] result = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		IntersectionTwo solution = new IntersectionTwo();
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		
		int[] result = solution.intersection(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
}
