package map;

import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * @author Zhaolong Zhong May 11, 2016
 * 
 * TreeMap will iterate according to the "nature ordering" of the keys according to their compareTo() method (or an externally supplied Comparator.
 * Additionally, it implements the SortedMap interface, which contains methods that depend on this sort order.
 * 
 * Implementation: Red-Black Tree
 * 
 * Get/put/remove/containsKey: O(log(n))
 * 
 * Only allow null value
 * 
 * Reference: http://stackoverflow.com/a/17708526/2427211
 */
class Content implements Comparable<Content> {
	String id;
	int length;
	int value;
	
	Content(String id, int length, int value) {
		this.id = id;
		this.length = length;
		this.value = value;
	}
	
	@Override
	public int compareTo(Content content) {
		return this.length - content.length;
	}
}

public class TreeMapExample {
	public static void main(String[] args) {
		Content c1 = new Content("1", 10, 80);
		Content c2 = new Content("2", 8, 90);
		Content c3 = new Content("3", 8, 80);
		Content c4 = new Content("4", 20, 60);
		
		TreeMap<Content, Integer> treeMap = new TreeMap<Content, Integer>();
		treeMap.put(c1, 10);
		treeMap.put(c2, 15);
		treeMap.put(c3, 50);// since c2 and c3 are the same length, c2 will be replaced by c3
		treeMap.put(c4, 20);
		
		for (Entry<Content, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey().id + ": " + entry.getValue());
		}
	}
}

