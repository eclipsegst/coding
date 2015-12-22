package g;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Dec 21, 2015
 * 
 * Problem: Plus One
 * 
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the 
 * head of the list.
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int[] res = new int[digits.length + 1];
		digits[digits.length - 1] += 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			res[i + 1] += digits[i];
			res[i] = res[i + 1] / 10;
			res[i + 1] %= 10;
		}
		
		if (res[0] == 0) 
			return Arrays.copyOfRange(res, 1, digits.length);
		return res;
	}
}
