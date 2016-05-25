package a;

/**
 * @author Zhaolong Zhong May 25, 2016
 * String to Integer
 * 
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * 
 * Requirements for atoi:
 * 1. The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * 2. The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * 3. If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * 4. If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
	public int atoi(String str) {
		if (str == null || str.length() < 1) {
			return 0;
		}
		
		// trim white spaces
		str = str.trim();
		int sign = 1;
		
		// check negative or positive
		
		if (str.charAt(0) == '-') {
			sign = -1;
		}
		
		int i = 1;
		double result = 0;
		boolean flag = false;
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
				flag = true;
				break;
			}
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		
		// handle max and min
		if (flag) {
			if (result * sign > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			
			if (result * sign < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
		}
		
		return (int) result * sign;
	}
	
	public static void main(String[] args) {
		StringToInteger solution = new StringToInteger();
		String s = "  -26";
		System.out.println(solution.atoi(s));
	}
}
