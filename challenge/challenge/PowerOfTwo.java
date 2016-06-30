package challenge;

/**
 * @author Zhaolong Zhong Jun 30, 2016
 * 
 * Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
	// Recursive
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
		
		if (n == 1) {
			return true;
		}
		
		if (n % 2 == 1) {
			return false;
		}
		
		return isPowerOfTwo(n / 2);
	}
	
	//Bit manipulation
	public boolean isPowerOfTwoBit(int n) {
		// n = 1000, then n - 1 = 0111
		return (n & (n - 1)) == 0; // n and n - 1 never share a '1'
	}
}