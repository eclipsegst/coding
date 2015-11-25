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
}
