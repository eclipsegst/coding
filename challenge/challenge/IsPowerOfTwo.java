package challenge;

/**
 * @author Zhaolong Zhong
 * Date: 1:59:04 PM Jul 8, 2015
 * 
 * Problem: Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 * 
 */
public class IsPowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n == 0) return false;
		if (n == 1) return true;
		if (n % 2 == 1) return false;
		return isPowerOfTwo(n / 2);
	}
}
