package gst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Combination Sum
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * 	All numbers (including target) will be positive integers.
 * 	The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * 
 * A solution set is: 
 * [
 * 	[7],
 * 	[2, 2, 3]
 * ]
 * 
 * Reference:
 * https://gist.github.com/daifu/5844049
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        
        combinationSumHelper(result, new ArrayList<Integer>(), candidates, 0, target);
        
        return result;
    }
	
	private void combinationSumHelper(List<List<Integer>> result, List<Integer> combination, int[] candidates, int from, int target) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(combination));
			return;
		}
		
		for (int i = from; i < candidates.length; i++) {
			int t = target - candidates[i];
			
			if (t == 0 || t >= candidates[i]) {
				combination.add(candidates[i]);
				combinationSumHelper(result, combination, candidates, i, t);
				combination.remove(combination.size() - 1);
			}
		}
	}
}
