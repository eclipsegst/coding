package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Zhaolong Zhong Dec 1, 2015
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length()) return false;
		Map index = new HashMap();
		for (int i = 0; i < words.length; i++) {
			if (!Objects.equals(index.put(pattern.charAt(i), i), index.put(words[i], i)))
				return false;
		}
		
		return true;
	}
}
