/**
 * Author: Zhaolong Zhong
 * Date  : 2015 9:08:24 AM
 */
package sort;

public class MergeSort {
  private int[] nums;
  private int[] helper;
  private int len;
  
  public void sort(int[] nums) {
    this.len = nums.length;
    this.nums = nums;
    this.helper = new int[len];
    mergesort(0, len - 1);
  }
  
  private void mergesort(int low, int high) {
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
  
  private void merge(int low, int mid, int high) {
    // Copy sub array to helper
    for (int i = low; i <= high; i++) {
      helper[i] = nums[i];
    }
    
    int i = low;
    int j = mid + 1;
    int k = low;
    
    // Copy the smallest values from left and right back to original array
    while (i <= mid && j <= high) {
      if (helper[i] <= helper[j]) {
        nums[k] = helper[i];
        i++;
      } else {
        nums[k] = helper[j];
        j++;
      }
      k++;
    }
    
    // Copy the rest of the left side of the array to original
    // Try merge left: 1 2 6, right: 3 4 5   
    while (i <= mid) {
      nums[k] = helper[i];
      i++;
      k++;
    }
    // Try merge left: 3 4 5, right: 1 2 6 to figure why we do not need 
    // to copy the rest of the right side of the array
  }
}
