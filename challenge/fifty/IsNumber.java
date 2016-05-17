package fifty;

/**
 * @author Zhaolong Zhong Nov 28, 2015
 */
public class IsNumber {
	public boolean isNumber(String s) {
		boolean isNumeric = false;
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		return isNumeric && i == n;
	}
	
	public boolean isNumberE(String s) {
		boolean isNumeric = false;
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		if (isNumeric && i < n && s.charAt(i) == 'e') {
			i++;
			isNumeric = false;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		return isNumeric && i == n;
	}
}
