package map;

/**
 * @author Zhaolong Zhong May 31, 2016
 */
public class ZEntry<K, V> {
	private final K key;
	private V value;
	
	public ZEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
}
