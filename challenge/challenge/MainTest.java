package challenge;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Zhaolong Zhong Nov 29, 2015
 */
public class MainTest {

	@Test
	public void testNumArray() {
		int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
		NumArray numArray = new NumArray(nums);
		assertEquals("testNumArray", 1, numArray.sumRange(0, 2));
		assertEquals("testNumArray", -1, numArray.sumRange(2, 5));
		assertEquals("testNumArray", -3, numArray.sumRange(0, 5));
	}
	
	@Test
	public void testPalindrome() {
		Palindrome solution = new Palindrome();
		String s0 = "code";
		String s1 = "aab";
		String s2 = "carerac";
		assertEquals("test Palindrome", false, solution.canPermutePalindrome(s0));
		assertEquals("test Palindrome", true, solution.canPermutePalindrome(s1));
		assertEquals("test Palindrome", true, solution.canPermutePalindrome(s2));
		assertEquals("test Palindrome", false, solution.canPermutePalindromeTwo(s0));
		assertEquals("test Palindrome", true, solution.canPermutePalindromeTwo(s1));
		assertEquals("test Palindrome", true, solution.canPermutePalindromeTwo(s2));
	}
	
	@Test
	public void testWordPattern() {
		WordPattern solution = new WordPattern();
		String pattern = "abba";
		String str1 = "dog cat cat dog";
		String str2 = "dog cat cat fish";
		assertEquals("test WordPattern", true, solution.wordPattern(pattern, str1));
		assertEquals("test WordPattern", false, solution.wordPattern(pattern, str2));
	}
	
	@Test
	public void testFlipGame() {
		FlipGame solution = new FlipGame();
		String s = "++++";
		assertEquals("test FlipGame", 3, solution.generatePossibleNextMoves(s).size());
	}
	
	@Test
	public void testUglyNumber() {
		UglyNumber solution = new UglyNumber();
		int n = 6;
		int m = 14;
		assertEquals("test UglyNumber", true, solution.isUglyNumber(n));
		assertEquals("test UglyNumber", false, solution.isUglyNumber(m));
	}
	
	@Test
	public void testHappyNumber() {
		HappyNumber solution = new HappyNumber();
		int n = 19;
		assertEquals("test HappyNumber", true, solution.isHappy(n));
		
	}
}
