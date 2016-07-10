package challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Jul 9, 2016
 * 
 * Find K Pairs with Smallest Sums
 * 
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * Return: [1,2],[1,4],[1,6]
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * Return: [1,1],[1,1]
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3 
 * Return: [1,3],[2,3]
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/50527
 */
public class KSmallestPairs {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k < 1) {
        	return result;
        }
        
        int[] index = new int[nums1.length];
        while (k-- > 0) {
        	int min = Integer.MAX_VALUE;
        	int t = -1;
        	for (int i = 0; i < nums1.length; i++) {
        		if (index[i] >= nums2.length) {
        			continue;
        		}
        		
        		if (nums1[i] + nums2[index[i]] < min) {
        			min = nums1[i] + nums2[index[i]];
        			t = i;
        		}
        	}
        	
        	if (t == -1) {
        		break;
        	}
        	
        	result.add(new int[]{nums1[t], nums2[index[t]]});
        	index[t]++;
        }
        
        return result;
    }
}
