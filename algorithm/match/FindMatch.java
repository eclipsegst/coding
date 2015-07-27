package match;

/**
 * 
 * @author Zhaolong Zhong
 * Date: 3:05:26 PM Jul 27, 2015
 * 
 * Problem: Substring Pattern Matching
 * Input: A text string s, and a pattern stringp
 * Output: Does s contain the patter p as substing, and if so where?
 * 
 * Time Complexity:
 * 	f(n) = (M - N) * N + c(M - N)
 *       = O(MN)
 */

public class FindMatch {
	private static int findMatch(String s, String p) {
		if (s == null || p == null) return -1;
		int m = s.length();
		int n = p.length();
		if (m < n) return -1;
		
		for (int i = 0; i <= (m - n); i++) { // (M - N) steps
			int j = 0;
			
			while(j < n && s.charAt(i + j) == p.charAt(j)) { // at most N steps
				j++;
			}
			
			if (j == n) return i;
		}
		
		return -1;
	}
	
	public static void main(String args[]) {
		String s = "aababba";
		String p = "abba";
		int res = findMatch(s, p);
		System.out.println(res);
	}
}
