package gst;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * One Edit Distance
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * An edit between two strings is one of the following changes.
 * 	a. Add a character
 * 	b. Delete a character
 * 	c. Change a character
 * 
 * Solution:
 * 1. Replace one char
 * 		s: a B c
 * 		t: a D c 
 * 2. Delete one char from s
 * 		s: a D b c
 * 		t: a   b c
 * 3. Delete one char from t
 * 		s: a   b c
 * 		t: a D b c
 * 
 * Reference: https://leetcode.com/discuss/71071/
 */
public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
//        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
//        	if (s.charAt(i) != t.charAt(i)) {
//        		if (s.length() == t.length()) {
//        			return s.substring(i + 1).equals(t.substring(i + 1));
//        		} else if (s.length() < t.length()) {
//        			return s.substring(i).equals(t.substring(i + 1));
//        		} else {
//        			return s.substring(i + 1).equals(t.substring(i));
//        		}
//        	}
//        }
        
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + (s.length() >= t.length() ? 1 : 0)).equals(t.substring(i + (s.length() <= t.length() ? 1 : 0)));
            }
        }
        
        // all the previous chars are the same.
        return Math.abs(s.length() - t.length()) == 1;
    }
	
	public static void main(String[] args) {
		OneEditDistance solution = new OneEditDistance();
		String s = "abc";
		String t = "abcd";
		
		System.out.println(solution.isOneEditDistance(s, t));
	}
}
