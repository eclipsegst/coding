package sort;

import java.util.Arrays;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = {"cba", "cab", "ca","a", "cba", "cba", "ca"};
		String[] res = RemoveDuplicateMergeSort(strs);
		
		for(String s : res) {
			System.out.print(s + " ");
		}
		
		System.out.println();
	}

	public static String[] RemoveDuplicateMergeSort(String[] strs) {
		MergeSortStringRemoveDuplicate.sort(strs);
		int duplicateCount = MergeSortStringRemoveDuplicate.count;
		String[] res = Arrays.copyOf(strs, strs.length - duplicateCount);
		return res;
	}


}



class MergeSortStringRemoveDuplicate {
  private static String[] strs;
  private static String[] helper;
  private static int len;
  public static int count = 0;
  
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
    // Copy sub array to helper
    for (int i = low; i <= high; i++) {
      helper[i] = strs[i];
    }
    
    int i = low;
    int j = mid + 1;
    int k = low;
    
    // Copy the smallest values from left and right back to original array
    while (i <= mid && j <= high) {
      if (helper[i].compareTo(helper[j]) <= 0) {
        strs[k] = helper[i];
        i++;
        if (helper[i].compareTo(helper[j]) == 0) {
        	j++;
        	count++;
        }
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