package challenge;
/*
 * Problem:
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you 
 * from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into 
 * on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class RobHouse {
	public int robHouse(int[] num) {
		int len = num.length;
		if (len == 0) return 0;
		if (len == 1) return num[0];
		
		int [] P = new int[len];
		P[0] = num[0];
		P[1] = Math.max(num[0], num[1]);
		
		for (int i = 2; i < len; i++) {
			P[i] = Math.max(num[i] + P[i - 2], P[i - 1]);
		}
		
		return P[len - 1];
	}
}
