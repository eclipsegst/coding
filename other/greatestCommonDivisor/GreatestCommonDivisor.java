package greatestCommonDivisor;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 */
public class GreatestCommonDivisor {
	
	public static int greatestCommonDivisor(int[] nums) {
		if (nums == null || nums.length == 1) return 0;
		int gcd = nums[0];
		for (int i = 1; i < nums.length; i++) {
			gcd = gcd(gcd, nums[i]);
		}
		
		return gcd;
	}
	
	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {16, 24, 56, 72};
		System.out.println(greatestCommonDivisor(nums));
	}
}
