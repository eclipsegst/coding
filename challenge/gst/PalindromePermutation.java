package gst;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Palindrome Permutation
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.
 * 
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 * Hint:
 * 	1. Consider the palindromes of odd vs even length. What difference do you notice?
 *  2. Count the frequency of each character.
 *  3. If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int t = 0;
        int count = 0;
        for (Character c : s.toCharArray()) {
        	if (!map.containsKey(c)) {
        		map.put(c, 1);
        		count++;
        	} else {
        		t = map.get(c);
        		if (t == 1) {
        			map.put(c, 0);
        			count--;
        		} else {
        			map.put(c, 1);
        			count++;
        		}
        	}
        }
        
        return count <= 1;
    }
	
	public boolean canPermutePalindromeSet(String s) {
		if (s == null || s.length() == 0) {
        	return false;
        }
		
		Set<Character> set = new HashSet<Character>();
		
		for (Character c : s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		
		return set.size() <= 1;
	}
	
	// Reference: https://leetcode.com/discuss/53180/
	public boolean canPermutePalindromeBitSet(String s) {
		BitSet bs = new BitSet();
		
		for (byte b : s.getBytes()) {
			bs.flip(b);
		}
		
		return bs.cardinality() < 2;
	}
	
	public static void main(String[] args) {
		PalindromePermutation solution = new PalindromePermutation();
		String s1 = "code";
		String s2 = "aab";
		String s3 = "carerac";
		
		System.out.println(solution.canPermutePalindrome(s1));
		System.out.println(solution.canPermutePalindrome(s2));
		System.out.println(solution.canPermutePalindrome(s3));
		
		System.out.println(solution.canPermutePalindromeSet(s1));
		System.out.println(solution.canPermutePalindromeSet(s2));
		System.out.println(solution.canPermutePalindromeSet(s3));
		
		System.out.println(solution.canPermutePalindromeBitSet(s1));
		System.out.println(solution.canPermutePalindromeBitSet(s2));
		System.out.println(solution.canPermutePalindromeBitSet(s3));
	}

}
