package google;

/**
 * @author Zhaolong Zhong Nov 29, 2015
 */
public class Fibonacci {
	
	// recursive
	public long fib(int n) {
		return n <= 1 ? n : fib(n-1) + fib(n-2);
	}
	
	// iterative
	public long fibFast(int n) {
		if (n <= 1) return n;
		int pre = 0, cur = 1, t;
		for (int i = 1; i <= n; i++) {
			t = cur;
			cur += pre;
			pre = t;
		}
		return pre;
	}
}
