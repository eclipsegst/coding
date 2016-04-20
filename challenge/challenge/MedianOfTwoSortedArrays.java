/**
 * Author : Zhaolong Zhong
 * Date   : 2015 4:39:23 PM
 * Problem:
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m + n)).
 * 
 * Hints:
 * Suppose the array is sorted, A[m] is greater than exactly m - 1 values in Array A.
 * If it is the median, it is also greater than exactly n = ceiling(n/2) - (m - 1) elements in B.
 * It requires constant time to check if B[n] <= A[i] <= B[n + 1].
 * If A[m] is not the median, then depending on whether A[i] is greater or less than B[n] and B[n + 1],
 * you know that A[m] is either greater than or less than the median.
 * 
 * 
 * A = {1, 3, 5, 7, 9}
 *      s     m     e
 *      
 * B = {0, 2, 4, 6, 8}

 * 
 * len = len(A) + len(B)
 * if (len is odd)
 *  kth(A, B, len/2)
 * else 
 *  (kth(A, B, len/2) + kth(A, B, len/2 + 1)) /2
 *  
 * function kth(m, A, B)
 *  n = k - m
 *  return B[n] <= A[m] <= B[n + 1}
 *  
 * if A[m] < B[n] // enlarge A[m]
 *  s = m + 1
 * else // diminish A[m]
 *  e = m
 * 
 * Play with the two example below:
 * Example 1:
 * A = {0, 1, 2, 3}
 * B = {4, 5, 6, 7}
 * 
 * Example 2:
 * A = {0, 2, 4, 6, 8}
 * B = {1, 3, 5, 7, 9}
 */
package challenge;

public class MedianOfTwoSortedArrays {

  public static double findMedianSortedArrays(int A[], int B[]) {

    int s = A.length + B.length;
    final int k = s / 2;
    if (s % 2 == 1) {
        return kth(A, B, k); // odd
    } else {
        return (kth(A, B, k - 1) + kth(A, B, k)) / 2.0; // even
    }
  }
  
  static int kth(int A[], int B[], int k) {
      
      if (A.length == 0) {
          return B[k];
      }
  
      if (B.length == 0) {
          return A[k];
      }
      // only when A.length == 1 && B.length == 1
  if (k == 0) {
          return Math.min(A[0], B[0]);
  }
  // only when A.length == 1 && B.length == 1
      if (A.length == 1 && B.length == 1) {
          return Math.max(A[0], B[0]);
      }
  
      int s = 0;
      int e = A.length;
      
      while ( s < e) {
          int m = (s + e) / 2;
          int n = k - m;
          if ( A[m] <= safe(B, n)) {
              if (n == 0 || A[m] >= safe(B, n - 1)) {
                  return A[m];
              }
          }
  
          if (safe(B, n) <= A[m]) {
              if (m == 0 || safe(B, n) >= A[m - 1]) {
                  return B[n];
              }
          }
  
          if (A[m] < safe(B, n)) {
              s = m + 1;
          } else {
              e = m;
          }
      }
      
      if (A[A.length - 1] < B[0]) {
          return B[k - A.length]; // if all elements in B are greater than elements in A
      } else {
          return kth(B, A, k);
      }
  }
  
  static int safe(int[] S, int i) {
      if (i < 0) return Integer.MIN_VALUE;
  
      if (i >= S.length) return Integer.MAX_VALUE;
  
      return S[i];    
  }
}
