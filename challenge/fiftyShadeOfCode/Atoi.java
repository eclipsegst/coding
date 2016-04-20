package fiftyShadeOfCode;

/**
 * @author Zhaolong Zhong Nov 28, 2015
 */
public class Atoi {
	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
	
	public int atoi(String s) {
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		int sign = 1;
		if (i < n && s.charAt(i) == '+') {
			i++;
		} else if (i < n && s.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		
		int res = 0;
		while (i < n && Character.isDigit(s.charAt(i))) {
			int digit = Character.getNumericValue(s.charAt(i));
			if (res > maxDiv10 || res == maxDiv10 && digit >= 8) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + digit;
			i++;
		}
		return sign * res;
	}
}
