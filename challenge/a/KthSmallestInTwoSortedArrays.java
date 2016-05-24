package a;

/**
 * @author Zhaolong Zhong May 23, 2016
 * 
 * Find the k-th Smallest Element in the Union of Two Sorted Arrays
 * 
 * Given two sorted arrays A, B of size m and n respectively. Find the k-th smallest element in the union of A and B. You can assume that there are no duplicate elements.
 * 
 * You can assume that there are no duplicate elements.
 * 
 * Follow up: can you do it in O(lgm + lgn)?
 */
public class KthSmallestInTwoSortedArrays {
	// O(k)
	public int findKthSmallest(int[] nums1, int[] nums2, int k) {
		if ((nums1 == null && nums2 == null) || (nums1 != null && nums2 != null && (nums1.length + nums2.length) < k) || k <= 0) {
			return Integer.MAX_VALUE;
		}
		
		if (nums1 == null) {
			return nums2[k - 1];
		}
		
		if (nums2 == null) {
			return nums1[k - 1];
		}
		
		if (k == 1) {
			return nums1[0] < nums2[0] ? nums1[0] : nums2[0];
		}
		
		int i = 0, j = 0;
		
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
			
			if (i + j == k - 1 && i < nums1.length && j < nums2.length) {
				if (nums1[i] < nums2[j]) {
					return nums1[i];
				} else {
					return nums2[j];
				}
			}
		}
		
		if (i == nums1.length) {
			while (j < nums2.length) {
				if (i + j == k - 1) {
					return nums2[j];
				}
				
				j++;
			}
		}
		
		if (j == nums2.length) {
			while (i < nums2.length) {
				if (i + j == k - 1) {
					return nums1[i];
				}
				
				i++;
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		KthSmallestInTwoSortedArrays solution = new KthSmallestInTwoSortedArrays();
		int[] nums1 = {1, 3, 5, 7, 9};
		int[] nums2 = {2, 4, 6, 8, 10, 112};
		int k = 1;
		
		System.out.println(solution.findKthSmallest(nums1, nums2, k));
	}
}
