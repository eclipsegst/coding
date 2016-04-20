package google;

/**
 * @author Zhaolong Zhong Dec 24, 2015
 */
public class PaintFence {
	public int numWays(int n, int k) {
		int dp[] = {0, k, k*k, 0};
		
		if (n <= 2) {
			return dp[n];
		}
		for (int i = 2; i < n; i++) {
			// the third post is different from the first one or the second one
			// the third post will have one color, so the rest is (k - 1)
			dp[3] = (k - 1) * (dp[1] + dp[2]);
			dp[1] = dp[2];
			dp[2] = dp[3];
		}
		
		return dp[3];
	}
}
