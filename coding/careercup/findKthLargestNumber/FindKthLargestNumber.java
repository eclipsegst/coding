/**
 * Author: Zhaolong Zhong
 * Date  : Feb 7, 2015 1:33:46 AM
 *
 */
package findKthLargestNumber;

public class FindKthLargestNumber {
  public static void main(String[] args) {
    int[] nums = new int[20];
    java.util.Random myRandom = new java.util.Random();
    for (int i = 0; i < nums.length; i++) {
      nums[i] = myRandom.nextInt(100);
      System.out.print(nums[i] + ",");
    }
    System.out.println();
    System.out.println("After:");
    findKthLargest(nums, 10);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + ",");
    }   
    
  }
  public static int findKthLargest(int[] nums, int k) {
    if (k < 1 || k > nums.length){
      return -1;
    }
    
    return findKthLargestSub(nums, 0, nums.length - 1, k);
  }
  
  public static int findKthLargestSub(int[] nums, int start, int end, int k) {
    int pivot = start;
    int left = start;
    int right = end;
    while (left <= right) {
      while (left <= right && nums[left] <= nums[pivot]) left++;
      while (left <= right && nums[pivot] <= nums[right]) right--;
      if(left < right) {
        swap(nums, left, right);
      }
    }
    swap(nums, pivot, right);
    if(k == right + 1) {
      return nums[right];
    } else if (k > right + 1) {
      return findKthLargestSub(nums, right + 1, end, k);
    } else {
      return findKthLargestSub(nums, start, right -1, k);
    }
  }
  
  private static void swap(int[] nums, int a, int  b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
