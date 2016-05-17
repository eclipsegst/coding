package fifty;

/**
 * @author Zhaolong Zhong Nov 27, 2015
 */
public class ReverseWords {
	public String reverseWordsSimple(String s) {
		if (s == null || s.isEmpty() || s == "") return "";
		String[] strs = s.trim().split(" +");
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length -1; i > 0; i--) {
			sb.append(strs[i] + " ");
		}
		sb.append(strs[0]);
		return sb.toString();
	}
	
	// O(n) runtime, O(n) space
	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}
	
	// Assume the input string does not contain leading or trailing spaces and the words are always separated by a single space.
	// O(n) runtime, O(1) space
	public void reverseWordsInPlace(char[] s) {
		reverse(s, 0, s.length);
		int i = 0;
		for (int j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}
	
	private void reverse(char[] s, int begin, int end) {
		for (int i = 0; i < (end - begin) / 2; i++) {
			char tmp = s[begin + i];
			s[begin + i] = s[end - i - 1];
			s[end - i - 1] = tmp;
		}
	}
}
