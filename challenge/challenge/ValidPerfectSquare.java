package challenge;

/**
 * @author Zhaolong Zhong Jun 27, 2016
 * 
 * Valid Perfect Square
 * 
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * Input: 16
 * Returns: True
 * 
 * Example 2:
 * Input: 14
 * Returns: False
 * 
 * Reference:
 * https://leetcode.com/discuss/110735
 * Newton's method: https://en.wikipedia.org/wiki/Newton%27s_method
 */
public class ValidPerfectSquare {
	
	// 	A square number is 1 + 3 + 5 + 7 + ...
	//	1 = 1
	//	4 = 1 + 3
	//	9 = 1 + 3 + 5
	//	16 = 1 + 3 + 5 + 7
	//	25 = 1 + 3 + 5 + 7 + 9
	//	36 = 1 + 3 + 5 + 7 + 9 + 11
	//	....
	//	so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
	// 	O(sqrt(N))
	public boolean isPerfectSquare(int num) {
		if (num < 1) {
			return false;
		}
		
		for (int i = 1; num > 0; i += 2) {
			num -= i;
		}
		
		return num == 0;
	}
	
	public boolean isPerfectSquareBinary(int num) {
		if (num < 1) {
			return false;
		}
		
		long left = 1, right = num; // long type to avoid 2147483647 case
		
		while (left <= right) {
			long mid = left + (right - left) / 2;
			long t = mid * mid;
			
			if (t > num) {
				right = mid - 1;
			} else if (t < num) {
				left = mid + 1;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	// Newton's
	// Find square root of num and square it
	// square == num ? true : false
	// Time complexity is near constant
	public boolean isPerfectSquareNewton(int num) {
		long t = num;
		while (t * t > num) {
			t = (t + num/t) / 2;
		}
		
		return t * t == num;
    }
}
