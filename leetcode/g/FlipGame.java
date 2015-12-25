package g;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Dec 24, 2015
 */
public class FlipGame {

	public List<String> nextMoves(String s) {
		List<String> res = new ArrayList<String>();
		char [] chars = s.toCharArray();
		if (chars.length < 2) return res;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i-1] == '+' && chars[i] == '+') {
				chars[i-1] = '-';
				chars[i] = '-';
				res.add(new String(chars));
				chars[i-1] = '+';
				chars[i] = '+';
			}
		}
		
		return res;
	}
}
