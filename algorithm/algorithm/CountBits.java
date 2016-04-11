package algorithm;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Apr 10, 2016
 * Given a non negative integer number num. For every numbers i in the range 0 <= i <= num
 * calculate the number of 1's in their binary representation and return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0, 1, 1, 2, 1, 2].
 * 
 * Follow up:
 * It is very easy to come up with a solution with run time O(n * sizeof(integer)). But can you do it in linear time O(n), possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function.
 * 
 * Hint:
 * 1. You should make use of what you have produced already.
 * 2. Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * 3. Or does the odd/even status of the number help you in calculating the number of 1s?
 * For number 2(10), 4(100), 8(1000), 16(10000), ..., the number of 1's is 1. Any other number can be converted to be 2^m + x. For example, 9=8+1, 10=8+2. The number of 1's for any other number is 1 + # of 1's in x.
 */
public class CountBits {
	
	// naive
	public int[] countBitsNaive(int num) {
		int[] result = new int[num+1];
		
		for (int i = 0; i <= num; i++) {
			result[i] = countEach(i);
		}
		
		return result;
	}
	
	private int countEach(int num) {
		int count = 0;
		
		while(num != 0) {
			if (num % 2 == 1) {
				count++;
			}
			num = num/2;
		}
		
		return count;
	}
	
	public int[] countBits(int num) {
		int[] result = new int[num+1];
		int p = 1, q = 1;
		
		for (int i = 1; i <= num; i++) {
			if (i == q) {
				result[i] = 1;
				q <<= 1;
				p = 1;
			} else {
				result[i] = result[p] + 1;
				p++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		CountBits solution = new CountBits();
		
		int[] resultNaive = solution.countBitsNaive(5);
		int[] resultBetter = solution.countBits(5);
		System.out.println(Arrays.toString(resultNaive));
		System.out.println(Arrays.toString(resultBetter));
	}
}
