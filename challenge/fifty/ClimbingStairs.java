package fifty;

/**
 * @author Zhaolong Zhong Dec 15, 2015
 */
public class ClimbingStairs {
	// f(n) = f(n -1) + f(n -2)
	public int climbStairs(int n) {
		int p = 1, s = 1;
		for (int i = 2; i <= n; i++) {
			int t = s;
			s += p;
			p = t;
		}
		return s;
	}
}
