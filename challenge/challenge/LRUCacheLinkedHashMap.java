package challenge;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Zhaolong Zhong Jun 19, 2016
 * 
 * Reference: 
 * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-int-float-boolean-
 * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-
 */
public class LRUCacheLinkedHashMap {
	private LinkedHashMap<Integer, Integer> map;
	private final int CAPACITY;
	
	@SuppressWarnings("serial")
	public LRUCacheLinkedHashMap(int capacity) {
		this.CAPACITY = capacity;
		this.map = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > CAPACITY;
			}
		};
	}
	
	public int get(int key) {
		return map.getOrDefault(key, -1);
	}
	
	public void set(int key, int value) {
		map.put(key, value);
	}
}
