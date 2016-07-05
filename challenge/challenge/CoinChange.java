package challenge;

/**
 * @author Zhaolong Zhong Jul 4, 2016
 * 
 * Coin Change
 * 
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/32489
 * https://discuss.leetcode.com/topic/35720
 */
public class CoinChange {
	// Recursive
	public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChangeRecursiveHelper(coins, amount, new int[amount]);
    }
	
	private int coinChangeRecursiveHelper(int[] coins, int remain, int[] count) {
		if (remain < 0) return -1; // not valid
		if (remain == 0) return 0; // cool, we find the solution
		if (count[remain - 1] != 0) return count[remain - 1]; // we have already visited it, then reuse it.
		
		int min = Integer.MAX_VALUE;
		
		for (int coin : coins) {
			int result = coinChangeRecursiveHelper(coins, remain - coin, count);
			if (result >= 0 && result < min) {
				min = result + 1;
			}
		}
		
		count[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		
		return count[remain - 1];
	}
	
	public int coinChangeIter(int[] coins, int amount) {
		if (amount < 1) return 0;
		int[] dp = new int[amount + 1];
		int sum = 0;
		
		while (++sum <= amount) {
			int min = -1;
			for (int coin : coins) {
				if (sum >= coin && dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;
					min = min < 0 ? temp : (temp < min ? temp : min);
				}
			}
			
			dp[sum] = min;
		}
		
		return dp[amount];
	}
}
