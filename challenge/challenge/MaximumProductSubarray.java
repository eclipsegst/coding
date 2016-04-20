/**
 * Author : Zhaolong Zhong
 * Date   : Feb 16, 2015 8:22:46 PM
 * Problem:
 * Maximum Product Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,2,-4]
 * the contiguous subarray [2,3] has the largest project = 6
 * 
 */
package challenge;

public class MaximumProductSubarray {
  
  public int maxProduct(int[] A) {
    int max = A[0];
    int pos = A[0];
    int neg = A[0];
    
    for(int i = 1; i < A.length; i++) {
      pos *= A[i];
      neg *= A[i];
      
      if (neg > pos) {
        int t = neg;
        neg = pos;
        pos = t;
      }
      
      pos = Math.max(A[i], pos);
      neg = Math.min(A[i], neg);
      
      max = Math.max(max, pos);
    }
    
    return max;
  }
  
  //Time Limit Exceeded
  public static int maxProductBrute(int[] A) {
    if (A.length <= 0) return Integer.MIN_VALUE;
    if (A.length == 1) return A[0];
    int max = A[0] * A[1];
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = i + 1; j < A.length; j++) {
        int temp = A[i] * A[j];
        if (temp > max) max = temp;
      }
    }
    return max;
  }
  
  public static void main(String[] args) {
    int A[] = {2,3,2,-4};
    System.out.println(maxProductBrute(A));
  }
}
