package g;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Dec 26, 2015
 */
public class MissingRange {
	static class Range {
		int st;
		int en;
		
		Range(int st, int en) {
			this.st = st;
			this.en = en;
		}
		
		public String toString() {
			if (st == en) return "" + st;
			return st + "->" + en;
		}
		
		private boolean valid() {
			return en >= st;
		}
		
		public void addIfValid(List<String> list) {
			if (valid()) {
				list.add(toString());
			}
		}
	}
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<String>();
		
		Range current = new Range(lower, upper);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > current.en) break;
			
			if (nums[i] >= current.st) {
				Range range = new Range(current.st, nums[i] - 1);
				range.addIfValid(res);
				current.st = nums[i] + 1;
			}
		}
		
		current.addIfValid(res);
		
		return res;
	}
}
