package summaryranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong
 * Date: 2:11:51 PM Jul 8, 2015
 * 
 * Problem:
 */
public class SummaryRanges {

	static class Range {
		int s;
		int e;
		
		Range(int s) {
			this.s = s;
			this.e = s;
		}
		
		public String toString() {
			if (s == e) return "" + s;
			return s + "->" + e;
		}
	}
	
	public List<String> summaryRanges(int[] nums) {
		
		List<String> res = new ArrayList<String>();
		
		if (nums.length == 0) return res;
		
		Range r = new Range(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] - r.e == 1) {
				r.e = nums[i];
			} else {
				res.add(r.toString());
				r = new Range(nums[i]);
			}
		}
		
		res.add(r.toString());
		
		return res;
	}
}
