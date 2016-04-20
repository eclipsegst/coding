package google;

/**
 * @author Zhaolong Zhong Dec 25, 2015
 */
public class PeakElement {
	// O(lg n) is something like binary search or merge sort
	public int findPeakElement(int[] num) {
		return findPeakElement(num, 0, num.length);
	}
	
	private int findPeakElement(int[] num, int from, int to) {
		if (to - from == 1) return from;
		
		int m = (to + from) / 2;
		
		int l = findPeakElement(num, from, m);
		int r = findPeakElement(num, m, to);
		
		if (num[l] > num[r]) return l;
		else return r;
	}
}
