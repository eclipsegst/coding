/**
 * Author : Zhaolong Zhong
 * Date   : Mar 9, 2015 10:33:32 AM
 * Problem: Rotate Array
 *  Rotate an array of n elements to the right by k steps.
 *  For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Hint: Could you do it in-place with O(1) extra space?
 * i = (i + k) % nums.length; //get the index of every k elements. If i is equal to previous i, then stop
 * For example, 
 * i = 0;
 * step 1: rotate element with index 0,3,6; i = (6 + 3) % 7 = 2
 * step 2: rotate element with index 2,5; i = (5 + 3) % 7 = 1
 * step 3: rotate element with index 1,4; i = (4 + 3) % 7= 0, current i is equals to previous i, stop
 * 
 */
package rotateArray;

import java.util.Arrays;

public class RotateArray {
  // brute force, time complexity: O(n^k)
  public static void rotate(int[] nums, int k) {
    for (int i = 0; i < k; i++) {
      int t = nums[nums.length - 1];
      for (int j = nums.length - 1; j > 0; j--) {
          nums[j] = nums[j - 1];
      }
      nums[0] = t;
    }
  }
  
  // time complexity: O(n)
  public static void rotateArray(int[] nums, int k) {
    if (k <= 0) return;
    int count = 0;
    for (int j = 0; j < k; j++) {
        int i = j;
        int t = nums[i];
        while (true) {
            i = (i + k) % nums.length;
            int nt = nums[i];
            nums[i] = t;
            t = nt;
            System.out.println("i = " + i + Arrays.toString(nums));
            count++;
            if (i == j) break;
        }
        if (count == nums.length) break;
    }
  }
  
  public static void rotateArray2(int[] nums, int k) {
    if (k <= 0) return;
    int c = 0, t, p, i;
    for (int j = 0; j < k; j++) {
      t = nums[j];
      i = j;
      while (true) {
        i = (i + k) % nums.length;
        p = nums[i];
        nums[i] = t;
        t = p;
        c++;
        if (i == j) break; 
      }
      if (c == nums.length) break; 
    }
  }
 
  public static void main(String[] args) {
    int [] array1 = {1,2,3,4,5,6,7};
    int [] array2 = {1};
    rotateArray(array1, 3);
    rotateArray2(array2, 2);
    System.out.println(Arrays.toString(array1));
    System.out.println(Arrays.toString(array2));
  }
}
