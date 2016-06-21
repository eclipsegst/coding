package a;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jun 20, 2016
 * 
 * Reverse Words in a String II
 * 
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsII {
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		int right = 0;
		while (right < s.length) {
			int left = right;
			while (right < s.length && s[right] != ' ') {
				right++;
			}
			
			reverse(s, left, right - 1);
			right++;
		}
	}
	
	public void reverse(char[] s, int left, int right) {
		while (left < right) {
			char tmp = s[left];
			s[left++] = s[right];
			s[right--] = tmp;
		}
	}
	
	public static void main(String[] args) {
		ReverseWordsII solution = new ReverseWordsII();
		String s = "the sky is blue";
		char[] chars = s.toCharArray();
		solution.reverseWords(chars);
		
		System.out.println(Arrays.toString(chars));
	}
}
