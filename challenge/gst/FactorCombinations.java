package gst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Factor Combinations
 * 
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 * 	 = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * Note: 
 * 	You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Examples: 
 * input: 1
 * output: []
 * input: 37
 * output: 
 * []
 * input: 12
 * output:
 * [
 * 	[2, 6],
 * 	[2, 2, 3],
 * 	[3, 4]
 * ]
 * input: 32
 * output:
 * [
 * 	[2, 16],
 * 	[2, 2, 8],
 * 	[2, 2, 2, 4],
 * 	[2, 2, 2, 2, 2],
 * 	[2, 4, 4],
 * 	[4, 8]
 * ]
 * 
 * Solution:
 * The upper bound for the factors of n is (int)Math.sqrt(n) and lower bound is 2.
 * We start with 2, check if remainder of n by 2 is 0 or not. If it's 0, then we have a factor and this combination adding to result.
 * Then we remove the factor from current combination, and check the factor recursively like n.
 * 
 * For example, n = 16, so the variable i can be from 2 to 4.
 * When i = 2, then its corresponding factor is 8, so we add 2 and 8 to the current combination, and add the current combination to result.
 * Then, we remove 8 from current combination, and recursively check 8 from 2 to 2 like we do in n.
 * The result should be: [2, 8], [2, 2, 4], [2, 2, 2, 2], [4, 4]
 */
public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        getFactorsHelper(result, new ArrayList<Integer>(), 2, n);
        
        return result;
    }
	
	// Backtracking
	private void getFactorsHelper(List<List<Integer>> result, List<Integer> combination, int start, int n) {
		int end = (int)Math.sqrt(n);
		
		for (int i = start; i <= end; i++) {
			int factor = -1;
			if (n % i == 0) {
				factor = n / i;
			}
			
			if (factor != -1 && factor >= i) {
				combination.add(i);
				combination.add(factor);
				result.add(new ArrayList<Integer>(combination));
				combination.remove(combination.size() - 1);
				getFactorsHelper(result, combination, i, factor);
				combination.remove(combination.size() - 1);
			}
		}
	}
	
	// Recursive
	public List<List<Integer>> getFactorsTwo(int n) {
		return factorHelper(n, 2);
	}
	
	private ArrayList<List<Integer>> factorHelper(int n, int minFactor) {
		ArrayList<List<Integer>> solutions = new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> subSolutions = new ArrayList<List<Integer>>();
		
		for (int factor = minFactor; factor <= n/factor; factor++) {
			if (n % factor == 0) {
				List<Integer> factors = new ArrayList<Integer>();
				factors.add(factor);
				factors.add(n/factor);
				solutions.add(factors);
				
				subSolutions = factorHelper(n/factor, factor);
				
				for (int i = 0; i < subSolutions.size(); i++) {
					subSolutions.get(i).add(0, factor);
					solutions.add(subSolutions.get(i));
				}
			}
		}
		
		return solutions;
	}
	
	public static void main(String[] args) {
		FactorCombinations solution = new FactorCombinations();
		List<List<Integer>> result = solution.getFactors(32);
		List<List<Integer>> result2 = solution.getFactorsTwo(32);
		
		System.out.println(Arrays.deepToString(result.toArray()));
		System.out.println(Arrays.deepToString(result2.toArray()));
	}
}
