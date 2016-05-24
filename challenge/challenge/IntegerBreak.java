package challenge;

/**
 * @author Zhaolong Zhong May 24, 2016
 * 
 * Integer Break
 * 
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: you may assume that n is not less than 2.
 * 
 * Hint:
 * There is a simple O(n) solution to this problem.
 * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 * 
 * 2 = 1 + 1
 * 3 = 1 + 2
 * 4 = 2 + 2
 * 5 = 3 + 2
 * 6 = 3 + 3
 * 7 = 3 + 2 + 2 => n % 3 = 1, then two 2s and the rest are all 3s
 * 8 = 3 + 3 + 2 => n % 3 = 2, then one 2 and the rest are all 3s
 * 9 = 3 + 3 + 3 => n % 3 = 0, then all 3s
 * 10= 4 + 3 + 3 or 3 + 3 + 2 + 2, n % 3 = 1, two 2s and the rest are all 3s
 * 
 */
public class IntegerBreak {
	public int integerBreak(int n) {
		if (n == 2) {
			return 1;
		}
		
		if (n == 3) {
			return 2;
		}
		
		int product = 1;
		
		while (n > 4) {
			product *= 3;
			n -= 3;
		}
		
		product *= n;
		
		return product;
	}
	
	public int integerBreakTwo(int n) {
		if (n <= 3) {
			return n - 1;
		}
		
		if (n % 3 == 0) {
			return (int) Math.pow(3, n/3);
		}
		
		if (n % 3 == 1) {
			return (int) Math.pow(3, (n - 4) /3) * 4;
		}
		
		// n % 3 == 2
		return (int) Math.pow(3, n / 3) * 2;
	}
	
	public static void main(String[] args) {
		IntegerBreak solution = new IntegerBreak();
		int n1 = 2;
		int n2 = 10;
		
		System.out.println(solution.integerBreak(n1));
		System.out.println(solution.integerBreak(n2));
		
		System.out.println(solution.integerBreakTwo(n1));
		System.out.println(solution.integerBreakTwo(n2));
	}
}
