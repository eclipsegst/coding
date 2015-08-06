package sort;

import java.util.Arrays;

public class SortStringArray {

	public static void main(String[] args) {
		
		String[] strs = {"cba", "cab", "ca","a", "cba", "cba", "ca"};
		for (String str : strs) {
			System.out.print(str + " ");
		}
		
		System.out.println();
//		Arrays.sort(strs);
		MergeSortString.sort(strs);
		for (String str : strs) {
			System.out.print(str + " ");
		}
		System.out.println(countUnique(strs));
		System.out.println("cab".compareTo("cabbb"));
		
		strs = removeDuplicates2(strs);
		System.out.println();
		for (String str : strs) {
			System.out.print(str + " ");
		}
	}
	
	/*
	 * Remove duplicates from sorted array in place.
	 */
	public static String[] removeDuplicates(String[] strs) {
		if (strs.length < 2) {
			return strs;
		}
		
		int i = 1;
		int j = 0;
		
		while (i < strs.length) {
			if (strs[i].equals(strs[j])) {
				i++;
			} else {
				j++;
				strs[j] = strs[i];
				i++;
			}
		}
		
		String[] res = Arrays.copyOf(strs, j + 1);
		return res;
	}
	
	/*
	 * Remove Duplicates from Sorted Array II 
	 * For example, given sorted array strs = ["1","1","1","2","2","3"], 
	 * return ["1","1","2","2","3"].
	 */
	public static String[] removeDuplicates2(String[] strs) {
		if (strs.length <= 2)
			return strs;
 
		int prev = 1; // point to previous
		int curr = 2; // point to current
 
		while (curr < strs.length) {
			if (strs[curr].equals(strs[prev]) && strs[curr].equals(strs[prev - 1])) {
				curr++;
			} else {
				prev++;
				strs[prev] = strs[curr];
				curr++;
			}
		}
 
		String[] res = Arrays.copyOf(strs, prev + 1);
		return res;
	}
	
	
	// Count the number of unique elements in a sorted with duplicate elements
	public static int countUnique(String[] strs) {
		int count = 0;
		for (int i = 0; i < strs.length - 1; i++) {
			if (strs[i].equals(strs[i + 1])) {
				count++;
			}
		}
		return (strs.length - count);
	}
	 
}

class MergeSortString {
  private static String[] strs;
  private static String[] helper;
  private static int len;
  
  public static void sort(String[] strsInput) {
	  len = strsInput.length;
	  strs = strsInput;
	  helper = new String[len];
    mergesort(0, len - 1);
  }
  
  private static void mergesort(int low, int high) {
    // Check if low is smaller than high, if not then the array is sorted
    if(low < high) {
      // Get the index of the element which is the middle
      int mid = low + (high - low) / 2;
      // Sort the left side of the array
      mergesort(low, mid);
      // Sort the right side of the array
      mergesort(mid + 1, high);
      // Merge them both
      merge(low, mid, high);
    }
  }
  
  private static void merge(int low, int mid, int high) {
    for (int i = low; i <= high; i++) {
      helper[i] = strs[i];
    }
    
    int i = low;
    int j = mid + 1;
    int k = low;
    
    while (i <= mid && j <= high) {
      if (helper[i].compareTo(helper[j]) <= 0) {
        strs[k] = helper[i];
        i++;
      } else {
        strs[k] = helper[j];
        j++;
      }
      k++;
    }
    
    while (i <= mid) {
      strs[k] = helper[i];
      i++;
      k++;
    }
  }
}

