package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhaolong Zhong Jun 20, 2016
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 * 	[3],
 * 	[1],
 * 	[2],
 * 	[1,2,3],
 * 	[1,3],
 * 	[2,3],
 * 	[1,2],
 * 	[]
 * ]
 * 
 * Reference: http://blog.csdn.net/u011095253/article/details/9158397
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
        	return result;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        result.add(tmp);
        Arrays.sort(nums);
        
        subsetsHelper(result, tmp, nums, 0);
        
        return result;
	}
	
	private void subsetsHelper(List<List<Integer>> result, List<Integer> tmp, int[] nums, int position) {
		for (int i = position; i < nums.length; i++) {
			tmp.add(nums[i]);
			result.add(new ArrayList<Integer>(tmp));
			subsetsHelper(result, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
