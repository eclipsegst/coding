package fiftyShadeOfCode;

/**
 * @author Zhaolong Zhong Nov 25, 2015
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(j))
					!= Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			
			i++;
			j--;
		}
		return true;
	}
}
