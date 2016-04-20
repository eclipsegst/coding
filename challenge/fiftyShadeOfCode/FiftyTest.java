package fiftyShadeOfCode;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Zhaolong Zhong Nov 25, 2015
 */
public class FiftyTest {

	@Test
	public void testTwoSum() {
		TwoSum twoSum = new TwoSum();
		int[] nums = new int[] {4, 2, 3, 1, 5, 6};
		int[] numsSorted = new int[] {1, 2, 3, 4, 5, 6};
		
		assertEquals("test SolutionHashMap", 1, twoSum.SolutionHashMap(nums, 10)[0]);
		assertEquals("test SolutionHashMap", 6, twoSum.SolutionHashMap(nums, 10)[1]);
		
		assertEquals("test SolutionBinarySearch", 4, twoSum.SolutionBinarySearch(numsSorted, 10)[0]);
		assertEquals("test SolutionBinarySearch", 6, twoSum.SolutionBinarySearch(numsSorted, 10)[1]);
		
		assertEquals("test SolutionTwoPointers", 4, twoSum.SolutionTwoPointers(numsSorted, 10)[0]);
		assertEquals("test SolutionTwoPointers", 6, twoSum.SolutionTwoPointers(numsSorted, 10)[1]);
	}
	
	@Test
	public void testStrStr() {
		StrStr strStr = new StrStr();
		String haystack = "mississippi";
		String needle = "issi";
		assertEquals("test StrStr", 1, strStr.strStr(haystack, needle));
	}
	
	@Test
	public void testReverseWords() {
		ReverseWords reverseWords = new ReverseWords();
		String s = "the sky is blue";
		String expected = "blue is sky the";
		assertEquals("test reverseWords", expected, reverseWords.reverseWords(s));
		assertEquals("test reverseWordsSimple", expected, reverseWords.reverseWordsSimple(s));
	}
	
	@Test
	public void testAtoi() {
		Atoi atoi = new Atoi();
		String s = "   -2147483649";
		int expected = -2147483648;
		assertEquals("test Atoi", expected, atoi.atoi(s));
	}
	
	@Test
	public void testIsNumber() {
		IsNumber isNumber = new IsNumber();
		String s = "  +0.1  ";
		String ss = " -12e+20 ";
		boolean expected = true;
		assertEquals("testIsNumber", expected, isNumber.isNumber(s));
		assertEquals("testIsNumber", expected, isNumber.isNumberE(ss));
	}
	
	@Test
	public void testLongestSubstring() {
		LongestSubstring solution = new LongestSubstring();
		String s = "abcabcbb";
		assertEquals("test LongestSubstring", 3, solution.lengthOfLongestSubstring(s));
		assertEquals("test LongestSubstring", 3, solution.lengthOfLongestSubstringTwo(s));
	}
	
	@Test
	public void testMissingRanges() {
		MissingRanges solution = new MissingRanges();
		int[] vals = new int[] {0, 1, 3, 50, 75};
		assertEquals("test MissingRanges", "2", solution.findMissingRanges(vals, 0, 99).get(0));
	}
	
	@Test
	public void testReverseInteger() {
		ReverseInteger solution = new ReverseInteger();
		int n = 1234;
		assertEquals("test ReverseInteger", 4321, solution.reverse(n));
	}
	
	@Test
	public void testUniquePath() {
		UniquePaths solution = new UniquePaths();
		int m = 3, n = 7;
		int expected = 28;
		assertEquals("test UniquePath", expected, solution.uniquePaths(m, n));
	}
	
	@Test
	public void testMaximumSubarray() {
		int[] sum = new int[] {2, 1, -3, 4, -1, 2, 1, -5, 4};
		int[] pro = new int[] {2, 3, -2, 4};
		int expected = 6;
		
		MaximumSubarray solution = new MaximumSubarray();
		assertEquals("test MaximumSumSubarray", expected, solution.maxSumSubarray(sum));
		assertEquals("test MaximumProductSubarray", expected, solution.maxProductSubarray(pro));
	}
}
