package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class Hash {
	public static void main(String[] args){
		System.out.println("Test Hash");
		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
		hashtable.put("one", 1);
		hashtable.put("two", 2);
		hashtable.put("three", 3);
		hashtable.put("three", 4);
		//hashtable.put(null, 4);//throw java.lang.NullPointerException error
		System.out.println(hashtable.get("three"));
		
		// HashMap allow null key or null value
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("one", 1);
		hashmap.put("two", null);
		hashmap.put(null, null);
		System.out.println("Test HashMap");
		System.out.println(hashmap.get("one"));
		System.out.println(hashmap.get("two"));
		System.out.println(hashmap.get(null));
		
		HashSet<Integer> hashset = new HashSet<Integer>();
		hashset.add(1);
		hashset.add(2);
		hashset.add(3);
		hashset.add(1);
		hashset.add(4);
		System.out.println("Test HashSet");
		System.out.println(hashset.contains(1));
		System.out.println(Arrays.toString(hashset.toArray()));//keep unique set
	}
}