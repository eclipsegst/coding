package fiftyShadeOfCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Dec 6, 2015
 */
public class MissingRanges {
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> ranges = new ArrayList<>();
		int pre = start - 1, cur;
		for (int i = 0; i <= vals.length; i++) {
			cur = (i == vals.length) ? end + 1 : vals[i];
			if (cur - pre > 1) {
				ranges.add(getRange(pre + 1, cur - 1));
			}
			pre = cur;
		}
		return ranges;
	}
	
	private String getRange(int from, int to) {
		return from == to ? String.valueOf(from) : from + "->" + to;
	}
}
