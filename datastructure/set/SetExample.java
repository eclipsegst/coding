package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * @author Zhaolong Zhong May 16, 2016
 */
public class SetExample {
	
	public static void main(String[] args) {
		// HashSet, the order is unpredictable.
		// add/remove/contains: O(1)
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("google");
		hashSet.add("apple");
		hashSet.add("microsoft");
		
		System.out.println("\nHashSet:");
		Iterator<String> hashSetIterator = hashSet.iterator();
		while (hashSetIterator.hasNext()) {
			String s = hashSetIterator.next();
			System.out.println(s);
		}
		
		System.out.println();
		for (String s : hashSet) {
			System.out.println(s);
		}
		
		// LinkedHashSet, it iterates through the elements in the order in which they were inserted.
		// add/remove/contains: O(1)
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("google");
		linkedHashSet.add("apple");
		linkedHashSet.add("microsoft");
		
		System.out.println("\nLinkedHashSet:");
		Iterator<String> linkedHashSetIterator = linkedHashSet.iterator();
		while (linkedHashSetIterator.hasNext()) {
			String s = linkedHashSetIterator.next();
			System.out.println(s);
		}
		
		// TreeSet, it iterates through the elements in the nature order.
		// add/remove/contains: O(log(n))
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("google");
		treeSet.add("apple");
		treeSet.add("microsoft");

		System.out.println("\nTreeSet:");
		Iterator<String> treeSetIterator = treeSet.iterator();
		while (treeSetIterator.hasNext()) {
			String s = treeSetIterator.next();
			System.out.println(s);
		}
	}
}
