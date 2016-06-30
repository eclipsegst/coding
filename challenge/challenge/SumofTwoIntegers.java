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
	
	public static void main(String[] args) {
		SumofTwoIntegers solution = new SumofTwoIntegers();
		
		int a = 1, b = 2;
		
		int result = solution.getSum(a, b);
		
		System.out.print(result);
	}
}
