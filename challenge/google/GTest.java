package google;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Zhaolong Zhong Dec 21, 2015
 */
public class GTest {

	@Test
	public void testValidParentheses() {
		ValidParentheses sol = new ValidParentheses();
		String s = "{}([])";
		assertEquals("test ValidParentheses", true, sol.isValidParenthese(s));
	}

	@Test
	public void testStrobogrammaticNumber() {
		StrobogrammaticNumber solution = new StrobogrammaticNumber();
		assertEquals("test StrobogrammaticNumber", true, solution.isStrobogrammatic("69"));
	}
}
