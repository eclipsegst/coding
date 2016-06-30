package challenge;

/**
 * @author Zhaolong Zhong Jun 29, 2016
 * 
 * Sum of Two Integers
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * 
 * Example:
 * Given a = 1 and b = 2, return 3.
 * 
 * Reference:
 * https://en.wikipedia.org/wiki/Two%27s_complement
 * https://www.cs.cornell.edu/~tomf/notes/cps104/twoscomp.html
 */
public class SumofTwoIntegers {
	public int getSum(int a, int b) {
		if (a == 0) {
			return b;
		}
		
		if (b == 0) {
			return a;
		}
		
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
    }
	
	public int getSubtract(int a, int b) {
		while (b != 0) {
			int borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}
		
		return a;
	}
	
	// Recursive
	public int getSumRecursive(int a, int b) {
		return (b == 0) ? a : getSumRecursive(a ^ b, (a & b) << 1);
	}
	// Recursive
	public int getSubtractRecursive(int a, int b) {
		return (b == 0) ? a : getSubtractRecursive(a ^ b, (~a & b) << 1);
	}
	
	// Get negative number
	public int negate(int x) {
		return getSumRecursive(~x, 1);
	}
	
	public static void main(String[] args) {
		SumofTwoIntegers solution = new SumofTwoIntegers();
		
		int a = 1, b = 2;
		int sum = solution.getSum(a, b);
		int substract = solution.getSubtract(a, b);
		
		System.out.println(sum);
		System.out.println(substract);
		System.out.println(solution.negate(2));
	}
}
