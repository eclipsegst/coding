package g;

/**
 * @author Zhaolong Zhong Apr 6, 2016
 * Problem:
 * Compute and return the square root of n.
 */
public class SquareRoot {
	
	//Binary search: the square root of x is less than x/2 + 1.
	// time complexity:log n, but there is overflow risk.
	public int sqrt(int x) {
		if (x < 0) {
			return -1;
		}
		
		if (x == 0) {
			return 0;
		}
		
		long i = 0;
		long j = x / 2 + 1;
		while (i <= j) {
			long mid = (i + j) / 2;
			if (mid * mid < x) {
				i = mid + 1;
			} else if (mid * mid > x) {
				j = mid - 1;
			} else {
				return (int)mid;
			}
		}
		
		return (int)j;
	}
	
	//Newtons' method: x/t + t = 2t
	public int sqrtNew(int x) {
		if (x < 0) {
			return -1;
		}
		
		if (x == 0) {
			return 0;
		}
		
		double n = (double) x;
		double nn = 0;
		while ((int)n - (int)nn != 0) {
			nn = n;
			n = (x/n + n) / 2;
		}
		
		return (int)nn;
	}
	
	//Binary search improved
	public int sqrtBetter(int x) {
		if (x < 0) {
			return -1;
		}
		
		if (x == 0) {
			return 0;
		}
		
		int i = 0;
		int j = x;
		
		while (i < j) {
			int m = (j - i) / 2 + i;
			
			int m1 = x / (m + 1);
			int m2 = x / (m + 1 + 1);
			
			if (m + 1 == m1) {
				return m + 1;
			}
			
			if (m + 1 + 1 == m2) {
				return m + 1 + 1;
			}
			
			if (m + 1 < m1 && m2 < m + 1 + 1) {
				return m + 1;
			}
			
			if (m1 < m + 1) {
				j = m;
			} else {
				i = m + 1;
			}
		}
		
		throw new RuntimeException();
	}
	
	
	public static void main(String[] args) {
		SquareRoot solution = new SquareRoot();
		
		System.out.println(solution.sqrt(4));
		System.out.println(solution.sqrt(5));
		System.out.println(solution.sqrt(Integer.MAX_VALUE));
		System.out.println(solution.sqrtBetter(Integer.MAX_VALUE));
		System.out.println(solution.sqrtNew(Integer.MAX_VALUE));
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}
}
