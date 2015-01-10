package findCommonElements;
import java.util.*;

public class FindCommonElements {
	public static void main(String[] args){
		System.out.println("Find Common Elements:");
		int [] array1 = {1, 2, 3, 4, 5};
		int [] array2 = {3, 4, 6};
		System.out.println("Brute-Force Approach:");
		List<Integer> list1 = new LinkedList<Integer>();
		list1 = findCommon(array1, array2);
		System.out.println(Arrays.toString(list1.toArray()));
		
		System.out.println("HashTable Approach:");
		List<Integer> list3 = new LinkedList<Integer>();
		list3 = findCommonHash(array1,array2);
		System.out.println(Arrays.toString(list3.toArray()));
		
		System.out.println("More Efficient Approach:");
		List<Integer> list4 = new LinkedList<Integer>();
		list4 = findIntersection(array1, array2);
		System.out.println(Arrays.toString(list4.toArray()));
	}
	
	// method 1: simple and brute-force approach, time complexityL O(m*n)
	public static List<Integer> findCommon(int[] array1, int[] array2){
		List<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<array1.length;i++){
			for(int j=0;j<array2.length;j++){
				if(array1[i] == array2[j]){
					list.add(array1[i]);
				}
			}
		}
		if(list.isEmpty()){
			return null;
		}else{
			return list;
		}
	}
	
	// method 2: binary search time complexity: O(mlog(n))

	
	// method 3: hashtable approach time complexity: O(m+n), hash each element in B to an using 
	public static List<Integer> findCommonHash(int[] array1, int[] array2){
		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		for(int item : array1){
			if(!hash.containsKey(item)){
				hash.put(item,"z");
			}
		}
		
		List<Integer> list = new LinkedList<Integer>();
		for (int item : array2){
			if(hash.containsKey(item)){
				list.add(item);
			}
		}
		if(list.isEmpty()){
			return null;
		}
		else{
			return list;
		}
	}
	// method 4: efficient way,like hashtable approach but without using extra space time complexity: O(m+n)
	public static List<Integer> findIntersection(int[] array1, int[] array2){
		int array1Length = array1.length;
		int array2Length = array2.length;
		
		if(array1Length == 0 || array2Length == 0){
			return null;
		}

		int indexFirst 	= 0;
		int indexSecond 	= 0;
		List<Integer> list = new LinkedList<Integer>();
		
		while(indexFirst < array1Length && indexSecond < array2Length){
			if(array1[indexFirst] < array2[indexSecond]){
				indexFirst ++;
			}else if (array1[indexFirst] > array2[indexSecond]){
				indexSecond ++;
			}else{
				list.add(array1[indexFirst]);
				indexFirst	++;
				indexSecond	++;
			}
		}
		return list;
	}	
}
