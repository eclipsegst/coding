package findCommonElements;

import java.util.*;

public class FindCommonElements {
	public static void main(String[] args){
		System.out.println("Find Common Elements");
		int [] arrayFirst = {1, 2, 3, 4, 5};
		int [] arraySecond = {3, 4, 6};
		findCommon(arrayFirst, arraySecond);
		List<Integer> list = new LinkedList<Integer>();
		list = findIntersection(arrayFirst, arraySecond);
		System.out.println(list.get(0));
	}
	
	// method 1: simple and brute-force approach, time complexityL O(n*n)
	public static void findCommon(int[] arrayFirst, int[] arraySecond){
		for(int i=0;i<arrayFirst.length;i++){
			for(int j=0;j<arraySecond.length;j++){
				if(arrayFirst[i] == arraySecond[j]){
					System.out.println(arrayFirst[i]);
				}
			}
		}
	}
	
	public static List<Integer> findIntersection(int[] arrayFirst, int[] arraySecond){
		int arrayFirstLength 	= arrayFirst.length;
		int arraySecondLength	= arraySecond.length;
		
		if(arrayFirstLength == 0 || arraySecondLength == 0){
			return null;
		}

		int indexFirst 	= 0;
		int indexSecond 	= 0;
		List<Integer> list = new LinkedList<Integer>();
		
		while(indexFirst < arrayFirstLength && indexSecond < arraySecondLength){
			if(arrayFirst[indexFirst] < arraySecond[indexSecond]){
				indexFirst ++;
			}else if (arrayFirst[indexFirst] > arraySecond[indexSecond]){
				indexSecond ++;
			}else{
				indexFirst	++;
				indexSecond	++;
				list.add(arrayFirst[indexFirst]);
			}
		}
	
			return list;
		}
	
}
