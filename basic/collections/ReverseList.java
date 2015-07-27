package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseList {

	public static void main(String[] args) {
		Integer[] values = new Integer[]{1, 3, 6, 8, 2, 5, 4, 9, 7};
		List<Integer> valueList = new ArrayList<Integer>(Arrays.asList(values));
		
		System.out.println("Before sort:");
		valueList.stream().forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		
		System.out.println("After sort");
		
		Collections.reverse(valueList);
		valueList.stream().forEach( i -> System.out.print(i + " "));
		
		System.out.println();
		System.out.println("Collections.sort(valueList, Collections.reverseOrder())");
		
		Collections.sort(valueList, Collections.reverseOrder());
		valueList.stream().forEach(i -> System.out.print(i + " "));
		
	}
	
}
