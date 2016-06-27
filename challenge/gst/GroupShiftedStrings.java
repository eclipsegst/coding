package gst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Group Shifted Strings
 * 
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * A solution is:
 * [
 * 	["abc","bcd","xyz"],
 * 	["az","ba"],
 * 	["acef"],
 * 	["a","z"]
 * ]
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strings) {
        	String key = getKey(str);
        	System.out.println(key);
        	if (map.containsKey(key)) {
        		map.get(key).add(str);
        	} else {
        		List<String> list = new ArrayList<String>();
        		list.add(str);
        		map.put(key, list);
        	}
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
    private String getKey(String word) {
    	StringBuilder sb = new StringBuilder();
    	if (word.isEmpty()) {
    		return sb.toString();
    	}
    	
    	char c = word.charAt(0);
    	for (int i = 0; i < word.length(); i++) {
    		sb.append((char)((word.charAt(i) + 26 - c) % 26));
    	}
    	
    	return sb.toString();
    }
    
    public static void main(String[] args) {
    	GroupShiftedStrings solution = new GroupShiftedStrings();
    	
    	String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    	List<List<String>> result = solution.groupStrings(strings);
    	
    	System.out.println(Arrays.deepToString(result.toArray()));
    	System.out.println('a' + 0);
    	System.out.println('z' + 0);
    	System.out.println('a' + 2);
    }
}
