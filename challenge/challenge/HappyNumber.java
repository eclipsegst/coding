package challenge;

import java.util.HashSet;
/**
 * @author Zhaolong Zhong Dec 4, 2015
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		if (n <= 0) return false;
		HashSet<Integer> set = new HashSet<>();
		
		for(;;) {
			if (n == 1) return true;
			if (set.contains(n)) return false;
			set.add(n);
			n = sumOfDigit(n);
		}
	}
	
	private int sumOfDigit(int n) {
		int res = 0;
		do {
			int s = n % 10;
			res += s * s;
			n /= 10;
		} while (n > 0);
		
		return res;
	}
}
