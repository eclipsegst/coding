package challenge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicateCharsInTwoStrings {
	public static void main(String[] args){
		List<String> list = new LinkedList<String>();
		list = removeDuplicateCharsHashSet("abcdefgh","abcdef");
		System.out.println(list.toString());
	}
	
	public static List<String> removeDuplicateCharsHashSet(String a, String b){
		if(a.length()<b.length()) return null;
		HashSet<String> hashSet = new HashSet<String>();
		for(int i=0; i<a.length(); i++){
			hashSet.add(String.valueOf(a.charAt(i)));
		}
		
		for(int j=0; j<b.length(); j++){
			if(hashSet.contains(String.valueOf(b.charAt(j)))){
				hashSet.remove(String.valueOf(b.charAt(j)));
			}
		}
		
		List<String> list = new LinkedList<String>(hashSet);
		return list;
		
	}
	
	public static List<String> removeDuplicateCharsBruteForce(String a, String b){
	  if(a.length()<b.length()) return null;
	  boolean flag = false;
	  List<String> list = new LinkedList<String>();
	  for (int i=0; i<a.length(); i++){
	    for (int j=0; j<b.length(); j++){
	      if (a.charAt(i)==b.charAt(j)){
	         flag = true;
	      }
	    }
	    if(flag == false){
	      list.add(String.valueOf(a.charAt(i)));
	    }
	    flag = false;
	  }
	  return list;
	}
	
	/*
	**If the two string are in alphabet order
	*/

	public static List<String> removeDuplicateCharsInOrder(String a, String b){
	  if (a.length()<b.length()) return null;
	  int i = 0;
	  int j = 0;
	  List<String> list = new LinkedList<String>();
	  while(i < a.length()){
	    if(j < b.length()){
	      if(a.charAt(i) < b.charAt(j)){
	        list.add(String.valueOf(a.charAt(i)));
	        i++;
	      }else if(a.charAt(i) == b.charAt(j)){
	        i++;
	        j++;
	      }else{
	        j++;
	      }
	    }else{
	      list.add(String.valueOf(a.charAt(i)));
	      i++;
	    }
	  }
	  return list;
	}

}
