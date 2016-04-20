package google;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Dec 23, 2015
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
	static final char[][] PATTERNS = {
		{'9', '6'},
		{'6', '9'},
		{'8', '8'},
		{'0', '0'},
	};
	
	public boolean isStrobogrammatic(String num) {
		char[] chars = num.toCharArray();
		for (int i = 0; i <= chars.length / 2; i++) {
			if (!isStrobogrammatic(chars[i], chars[chars.length - 1 - i])) {
				return false;
			}
		}
		
		return true;
	}
	
	boolean isStrobogrammatic(char l, char r) {
		char[] s = new char[]{l, r};
		for (char[] p : PATTERNS) {
			if (Arrays.equals(p, s))
				return true;
		}
		return false;
	}
}
