package u;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Zhaolong Zhong Sep 30, 2016
 */
public class LetterCombinations {
	// Time: O(3^n), Space: O(n)
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		
		if (digits == null || digits.isEmpty()) {
			return result;
		}
		
		HashMap<Character, char[]> map = new HashMap<Character, char[]>();
		
		map.put('0', new char[] {});
		map.put('1', new char[] {});
		map.put('2', new char[] {'a', 'b', 'c'});
		map.put('3', new char[] {'d', 'e', 'f'});
		map.put('4', new char[] {'g', 'h', 'i'});
		map.put('5', new char[] {'j', 'k', 'l'});
		map.put('6', new char[] {'m', 'n', 'o'});
		map.put('7', new char[] {'p', 'q', 'r', 's'});
		map.put('8', new char[] {'t', 'u', 'v'});
		map.put('9', new char[] {'w', 'x', 'y', 'z'});
		
		StringBuilder sb = new StringBuilder();
		
		letterCombinationsHelper(map, digits, sb, result);
		
		return result;
	}
	
	private void letterCombinationsHelper(HashMap<Character, char[]> map, String digits, StringBuilder sb, ArrayList<String> result) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}
		
		// The average number of character in each key is 3
		// Each level has m (3) different character.
		// The depth is n which is the length of digits.
		// Time complexity is m * m * ...* m = m^n
		for (char c : map.get(digits.charAt(sb.length()))) {
			sb.append(c);
			letterCombinationsHelper(map, digits, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		LetterCombinations solution = new LetterCombinations();
		ArrayList<String> result = solution.letterCombinations("23");
		
		System.out.println(Arrays.asList(result).toString());
	}
}
