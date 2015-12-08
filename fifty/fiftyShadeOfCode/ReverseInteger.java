package fiftyShadeOfCode;

/**
 * @author Zhaolong Zhong Dec 7, 2015
 */
public class ReverseInteger {
	public int reverse(int x) {
		int res = 0;
		while(x != 0) {
			// handle overflow/underflow
			if (Math.abs(res) > 214748364)
				return 0;
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	}
}