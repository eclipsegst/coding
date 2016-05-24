package challenge;

/**
 * @author Zhaolong Zhong May 23, 2016
 * 
 * Power of Four
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * 
 */
public class PowerOfFour {
	public boolean isPowerOfFourRecursion(int num) {
		if (num < 1) {
			return false;
		}
		
		while (num >= 4 ) {
			if (num % 4 != 0) {
				return false;
			}
			num /= 4;
		}

		return num == 1;
	}
	
	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
	}
	
	public static void main(String[] args) {
		PowerOfFour solution = new PowerOfFour();
		
		int n1 = 16;
		int n2 = 5;
		
		System.out.println(solution.isPowerOfFourRecursion(n1));
		System.out.println(solution.isPowerOfFourRecursion(n2));
		System.out.println(solution.isPowerOfFour(n1));
		System.out.println(solution.isPowerOfFour(n2));
	}
}
