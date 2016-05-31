package map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong May 31, 2016
 */
public class ZMap<K, V> {
	private int size;
	private int DEFAULT_SIZE = 26;
	
	@SuppressWarnings("unchecked")
	private ZEntry<K, V>[] values = new ZEntry[DEFAULT_SIZE];
	
	private V get(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					return values[i].getValue();
				}
			}
		}
		
		return null;
	}
	
	public void put(K key, V value) {
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i].setValue(value);
				return;
			}
		}
		
		if (size == values.length) {
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
		
		values[size++] = new ZEntry<K, V>(key, value);
	}
	
	public int size() {
		return size;
	}
	
	public void remove(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i] = null;
				size--;
				for (int j = i; j < size; j++) {
					values[j] = values[j + 1];
				}
			}
		}
	}
	
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		
		for (int i = 0; i < size; i++) {
			set.add(values[i].getKey());
		}
		
		return set;
	}
	
	public static void main(String[] args) {
		ZMap<String, String> map = new ZMap<>();
		map.put("google", "android");
		map.put("apple", "iPhone");
		map.put("microsoft", "windows");
		map.put("z", "z");
		
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
		System.out.println();
		map.remove("z");
		
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}
}
