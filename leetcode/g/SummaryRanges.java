package g;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Dec 22, 2015
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
	static class Range {
		int start;
		int end;
		Range(int start) {
			this.start = start;
			this.end = start;
		}
		
		public String toString() {
			if (start == end) return "" + start;
			return start + "->" + end;
		}
	}
	
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		
		Range range = new Range(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == range.end + 1 ) {
				range.end = nums[i];
			} else {
				res.add(range.toString());
				range = new Range(nums[i]);
			}
		}
		res.add(range.toString());
		return res;
	}
}
