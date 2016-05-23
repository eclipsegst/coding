package challenge;

/**
 * @author Zhaolong Zhong May 23, 2016
 * 
 * Reverse String
 * 
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
	public String reverseString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		
		char[] chars = s.toCharArray();
		
		for (int i = 0; i < s.length()/2; i++) {
			char t = chars[i];
			chars[i] = chars[s.length() - i - 1];
			chars[s.length() - i - 1] = t;
		}
		
		return new String(chars);
	}
	
	public static void main(String[] args) {
		ReverseString solution = new ReverseString();
		String s = "hello";
		System.out.println(solution.reverseString(s));
	}
}
