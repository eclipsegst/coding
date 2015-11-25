package arithmeticSequence;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 */
public class ArithmeticSequence {
	public static int arithmeticSequence(int[] nums) {
		if (nums == null || nums.length < 3) return 0;
		int res = 0;
		int gap = nums[1] - nums[0];
		int length = 2;
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i+1] - nums[i] == gap) {
				length++;
			} else {
				gap = nums[i+1] - nums[i];
				if (length >= 3) res += (length - 1) * (length - 2) / 2;
				if (res > 1000000000) return -1;
				length = 2;
			}
		}
		
		if (length >= 3) res += (length - 1) * (length - 2) / 2;
		return res > 1000000000 ? -1 : res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {-1, 1, 3, 3, 3, 2, 1, 0};
		System.out.println(arithmeticSequence(nums));
	}
}
