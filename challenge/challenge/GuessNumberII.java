package challenge;

/**
 * @author Zhaolong Zhong Jul 16, 2016
 * 
 * Guess Number Higher or Lower II
 * 
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * Example:
 * n = 10, I pick 8.
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * Game over. 8 is the number I picked.
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 * 
 * Hint:
 * The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
 * Take a small example (n = 3). What do you end up paying in the worst case?
 * Check out this article(https://en.wikipedia.org/wiki/Minimax) if you're still stuck.
 * The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
 * As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/51353
 */
public class GuessNumberII {
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        int[][] dp = new int[n + 1][n + 1];
        return getMoneyAmount(dp, 1, n);
    }
    
    private int getMoneyAmount(int[][] dp, int s, int e) {
    	if (s >= e) return 0;
    	if (dp[s][e] != 0) return dp[s][e];
    	
    	int res = Integer.MAX_VALUE;
    	for (int i = s; i <= e; i++) {
    		int t = i + Math.max(getMoneyAmount(dp, s, i - 1), getMoneyAmount(dp, i + 1, e));
    		res = Math.min(res, t);
    	}
    	
    	dp[s][e] = res;
    	return res;
    }
    
    // Bottom up
    public int getMoneyAmountII(int n) {
    	int[][] table = new int[n + 1][n + 1];
    	for (int j = 2; j <= n; j++) {
    		for (int i = j - 1; i > 0; i--) {
    			int globalMin = Integer.MAX_VALUE;
    			for (int k = i; k <= j; k++) {
    				int localMax = k + Math.max(table[i][k == i? k : k -1], table[k == j ? k : k + 1][j]);
    				globalMin = Math.min(globalMin, localMax);
    			}
    			table[i][j] = globalMin;
    		}
    	}
    	
    	return table[1][n];
    }
}
