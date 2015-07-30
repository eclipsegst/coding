package countprimes;

/**
 * @author Zhaolong Zhong
 * Date: 1:47:51 AM Jul 30, 2015
 * 
 * Problem: Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 */

public class CountPrimes {
	
	public static void main(String[] args) {
		System.out.println(countPrimesSlow(1000));
		System.out.println(countPrimes(1000));
	}

	/*
	 * Time complexity: O(n^1.5)
	 */
	static int countPrimesSlow(int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (isPrime(i)) count++;
		}
		
		return count;
	}
	
	/*
	 * Check if an integer is prime or not
	 * Time Complexity: O(n^0.5)
	 */
	private static boolean isPrime(int n) {
		
		if (n <= 1) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	static int countPrimes(int n) {
		if (n <= 2) return 0;
		boolean [] primes = new boolean[n];
		for (int i = 2; i < n; i++) {
			primes[i] = true;
		}
		
		for (int i = 2; i * i < n; i++) {
			if (primes[i]) {
				// primes[i + i * ii] already marked,ii = 2, ... i - 1, so we start with i * i
				// for example, when i = 2, we mark 2 * 3, 2 * 4...
				// so when i = 3, we don't need to mark 3 * 2 = (3 + 3)
				for (int j = i * i; j < n; j += i) {
					primes[j] = false;
				}
			}
		}
		
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i]) count++;
		}
		
		return count;
	}
}
