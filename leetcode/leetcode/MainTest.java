package leetcode;

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

}
