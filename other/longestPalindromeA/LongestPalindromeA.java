package longestPalindromeA;

/**
 * @author Zhaolong Zhong Nov 23, 2015
 * 
 * Time O(n^2), Space O(1)
 */
public class LongestPalindromeA {
	public static String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) return null;
		if (s.length() == 1) return s;
		
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i ++) {
			// get longest palindrome with center of i
			String tmp = getPalindrome(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			
			// get longest palindrome with center of i, i + 1
			tmp = getPalindrome(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}	
		}
		
		return longest;
	}
	
	public static String getPalindrome(String s, int start, int end) {
		while (start >=0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		
		return s.substring(start + 1, end);
	}
	
	public static void main(String[] args) {
		String s = "abcdefggfedad";
		System.out.println(longestPalindrome(s));
	}
}

