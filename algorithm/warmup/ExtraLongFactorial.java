package warmup;

import java.math.BigInteger;

/**
 * You are given an integer N. Print the factorial of this number.
 * N! = N * (N-1) * (N-2)...* 2 * 1
 * 
 * Note: Factorials of N > 20 can't be stored even in a 64-bit long long variable.
 * Bit integers must be used for such calculations.
 *
 */

import java.util.Scanner;

public class ExtraLongFactorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(factorial(BigInteger.valueOf(n)));

	}
	
	public static BigInteger factorial(BigInteger n) {
		BigInteger res = BigInteger.ONE;
		
		while(!n.equals(BigInteger.ZERO)) {
			res = res.multiply(n);
			n = n.subtract(BigInteger.ONE);
		}
		
		return res;
	}

}
