package challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Dec 2, 2015
 */
public class FlipGame {
	public List<String> possibleNextMoves(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() < 2) return res;
		
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				String s1 = s.substring(0, i);
				String s2 = "--";
				String s3 = s.substring(i + 2);
				String tmp = s1 + s2 + s3;
				res.add(tmp);
			}
		}
		
		return res;
	}
}
