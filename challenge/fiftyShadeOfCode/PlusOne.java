package fiftyShadeOfCode;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Dec 8, 2015
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int[] res = new int[digits.length + 1];
		digits[digits.length - 1] += 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			res[i + 1] += digits[i];
			res[i] += res[i + 1] / 10;
			res[i + 1] %= 10;
		}
		
		if (res[0] == 0) {
			return Arrays.copyOfRange(res, 1, res.length);
		}
		return res;
	}
}
