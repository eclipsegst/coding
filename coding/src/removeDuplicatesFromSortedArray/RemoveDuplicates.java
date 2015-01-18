package removeDuplicatesFromSortedArray;

import java.util.Arrays;
/*
 * Date: 01/18/2015
 * 
 * Create an array with all unique elements
 */
public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] arr = {1,2,2,3,3};
		arr = removeDuplicates(arr);
		System.out.println(arr.length);
	}
	
	public static int[] removeDuplicates(int[] a) {
		if (a.length < 2) {
			return a;
		}
		
		int i = 1;
		int j = 0;
		
		while (i < a.length) {
			if(a[i] == a[j]) {
				i++;
			} else {
				j++;
				a[j] = a[i];
				i++;
			}
		}
		
		int[] b = Arrays.copyOf(a, j+1);
		return b;
	}
}
