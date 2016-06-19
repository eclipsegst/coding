package challenge;

/**
 * @author Zhaolong Zhong Jun 18, 2016
 * 
 * Count Numbers with Unique Digits
 * 
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * 
 * Hint:
 * 1. A direct way is to use the backtracking approach.
 * 2. Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.
 * 3. This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
 * 4. Let f(k) = count of numbers with unique digits with length equals k.
 * 5. f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].
 */
public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		n = Math.min(n, 10);
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = 9;
			for (int j = 9; j >= 9 - i + 2; j--) {
				dp[i] *= j;
			}
		}
		
		int result = 0;
		for (int i = 0; i < dp.length; i++) {
			result += dp[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		CountNumbersWithUniqueDigits solution = new CountNumbersWithUniqueDigits();
		
		System.out.println(solution.countNumbersWithUniqueDigits(2));
	}
}
