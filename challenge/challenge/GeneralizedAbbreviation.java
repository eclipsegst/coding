package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhaolong Zhong Jul 5, 2016
 * 
 * Generalized Abbreviation
 * 
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/32270
 * https://discuss.leetcode.com/topic/32765
 */
public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        backtrack(result, word, 0, "", 0);
        
        return result;
    }
	
	private void backtrack(List<String> result, String word, int position, String current, int count) {
		if (position == word.length()) {
			if (count > 0) current += count;
			result.add(current);
		} else {
			backtrack(result, word, position + 1, current, count + 1);
			backtrack(result, word, position + 1, current + (count > 0 ? count : "") + word.charAt(position), 0);
		}
	}
	
	public List<String> generateAbbreviationsDFS(String word) {
		List<String> result = new ArrayList<>();
		dfsHelper(result, new StringBuilder(), word.toCharArray(), 0, 0);
		
		return result;
	}
	
	// O(2^n)
	public void dfsHelper(List<String> result, StringBuilder sb, char[] c, int i, int num) {
		int len = sb.length();
		if (i == c.length) {
			if (num != 0) sb.append(num);
			result.add(sb.toString());
		} else {
			dfsHelper(result, sb, c, i + 1, num + 1); // Abbreviate c[i]
			
			if (num != 0) sb.append(num);
			dfsHelper(result, sb.append(c[i]), c, i + 1, 0); // Not abbreviate c[i]
		}
		sb.setLength(len);
	}
	
	public static void main(String[] args) {
		GeneralizedAbbreviation solution = new GeneralizedAbbreviation();
		
		String word = "word";
		
		List<String> result1 = solution.generateAbbreviations(word);
		List<String> result2 = solution.generateAbbreviationsDFS(word);
		System.out.println(Arrays.toString(result1.toArray()));
		System.out.println(Arrays.toString(result2.toArray()));
	}
}
