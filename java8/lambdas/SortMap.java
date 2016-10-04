package lambdas;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.*;

public class SortMap {
	
	public static void main(String[] args) {
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("A", 63.7);
		map.put("B", 99.5);
		map.put("C", 88.4);
		map.put("D", 26.0);
		
		System.out.println("Before sort");
		map.forEach((k, v) -> {
			System.out.println("k: " + k + ", v: " + v);
		});
		System.out.println();
		System.out.println("After sort");
		map = sortByValue(map);
		map.forEach((k, v) -> {
			System.out.println("k: " + k + ", v: " + v);
		});
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ) {
		Map<K,V> result = new LinkedHashMap<>();
		Stream <Entry<K,V>> st = map.entrySet().stream(); 
		st.sorted(Comparator.comparing(e -> e.getValue()))
			.forEach(e ->result.put(e.getKey(),e.getValue()));
		
	     return result;
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueJava7( Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		
		Map<K, V> result = new LinkedHashMap<>();
		
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
