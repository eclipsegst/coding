package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
 * Date: 01/20/2015 21:21
 * Problem: 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case
 * 
 */
public class Anagrams {
  public static void main(String[] args) {
    String [] strs = {"abc", "bc", "ac", "bca", "ca"};
    List<String> list = new ArrayList<String>();
    list = anagrams(strs);
    System.out.println(Arrays.toString(list.toArray()));
  }  
  public static List<String> anagrams(String[] strs) {
    List<String> res = new ArrayList<String>();
    if (strs == null || strs.length==0) {
      return res;
    }
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for (int i=0; i<strs.length; i++) {
      char[] charArr = strs[i].toCharArray();
      Arrays.sort(charArr);
      String str = new String(charArr);
      if (map.containsKey(str)) {
        map.get(str).add(strs[i]);
      } else {
        ArrayList<String> list = new ArrayList<String>();
        list.add(strs[i]);
        map.put(str, list);
      }
    }
    
    for(List<String> s : map.values()){
      if (s.size()>1) {
        res.addAll(s);
      }
    }
    return res;
  }
}
