package google;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Zhaolong Zhong Nov 29, 2015
 */
public class MainTest {

	@Test
	public void testReverseString() {
		ReverseString solution = new ReverseString();
		String s = "Madam, I'm Adam";
		String expected = "madA m'I ,madaM";
		assertEquals("test ReverseString", expected, solution.reverseBuilder(s));
		assertEquals("test ReverseString", expected, solution.reverse(s));
		assertEquals("test ReverseString", expected, solution.reverseWhile(s));
	}
	
	@Test
	public void testFibonacci() {
		Fibonacci solution = new Fibonacci();
		int n = 6;
		int expected = 8;
		assertEquals("test Fibonacci", expected, solution.fib(n));
		assertEquals("test Fibonacci", expected, solution.fibFast(n));
	}
	
	@Test
	public void testSumFile() {
		SumFile solution = new SumFile();
		String path = "./files/sum.txt";
		String pathOutput = "./files/sumOutput.txt";
		int expected = 15;
		assertEquals("test SumFile", expected, solution.sumFile(path, pathOutput));
	}

}
