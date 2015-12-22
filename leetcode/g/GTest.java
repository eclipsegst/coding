package g;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Zhaolong Zhong Dec 21, 2015
 */
public class GTest {

	@Test
	public void test() {
		ValidParentheses sol = new ValidParentheses();
		String s = "{}([])";
		assertEquals("test ValidParentheses", true, sol.isValidParenthese(s));
	}

}
