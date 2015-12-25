package g;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhaolong Zhong Dec 24, 2015
 */
public class UniqueWordAbbreviation {
	Map<String, Set<String>> map = new HashMap<>();
	
	public UniqueWordAbbreviation(String[] strs) {
		for (String s : strs) {
			String abbr = "";
			if (s.length() > 2) {
				abbr += s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
			}
			if (map.containsKey(abbr)) {
				map.get(abbr).add(s);
			} else {
				Set<String> set = new HashSet<String>();
				set.add(s);
				map.put(abbr, set);
			}
		}
	}
	
	public boolean isUnique(String word) {
		String abbr = "";
		if (word.length() > 2) {
			abbr += word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
		}
		
		if (!map.containsKey(abbr)) return true;
		else return map.get(abbr).contains(word) && map.get(abbr).size() <= 1;
	}
}
