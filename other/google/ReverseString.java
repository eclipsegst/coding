package google;

/**
 * @author Zhaolong Zhong Nov 29, 2015
 */
public class ReverseString {
	
	public String reverseBuilder(String s) {
		if (s == null || s.length() <=0) return s;
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	public String reverse(String s) {
		if (s == null || s.length() == 0) return s;
		int last = s.length() - 1;
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length()/2; i++) {
			char c = chars[i];
			chars[i] = chars[last - i];
			chars[last - i] = c;
		}
		return new String(chars);
	}
	
	public String reverseWhile(String s) {
		if (s == null || s.length() == 0) return s;
		int i = 0, j = s.length() - 1;
		char[] chars = s.toCharArray();
		while (i < j) {
			char c = s.charAt(i);
			chars[i] = chars[j];
			chars[j] = c;
			i++;
			j--;
		}
		return new String(chars);
	}
}
