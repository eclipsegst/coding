/**
 *  Author : Zhaolong Zhong
 *  Date   : Feb 7, 2015 1:33:46 AM
 *  Problem:
 *      Describe an algorithm to find the smallest one million numbers(m) in one billion numbers.
 *      Assume that the computer memory can hold all one billion numbers(n).
 * 
 *  Solution 1: Sorting 
 *      We can sort the elements in asscending order and then take the first one million number from that.
 *      The time complexity is O(n log(n)).
 * 
 *  Solution 2: Min Heap/PriorityQueue
 *      We can use min heap to solve this problem.
 *      Since PriorityQueue providesO(log(n)) time for the enqueing and dequeing methods(offer, poll, remove(), and add),
 *      and constant time for the retrieve methods(peek, element, and size). 
 *      So we are going to have m size PriorityQueue, the operation time each element is O(log m).
 *      The time complexity is O(n log(m)).
 *  
 *  Solution 3: Selection Rank
 *      Selection Rank is well-known algorithm(medium of medium or quick select) in computer science to find the ith smallest 
 *      (or largest) element in an array in linear time.
 *      If the elements are unique, you can find the ith smallest element in expected O(n) time.
 *      Once we have found the ith smallest element, we can run through the array to find all values less than or equal to this element.
 *  
 */
package chapter_18_hard;

public class FindSmallestNNumbers {
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
