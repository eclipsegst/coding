/**
 * Author : Zhaolong Zhong
 * Date   : Feb 2, 2015 11:26:51 PM
 * 
 * Problem:
 * Merge Sorted Array
 * Given two sorted integer arrays A and B, merger B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */
package challenge;

public class MergeSortedArray {
  public void merge(int A[], int m, int B[], int n) {
    int a = m - 1;
    int b = n - 1;
    for(int i = m + n -1; i >= 0; i--){
      if(a >= 0 && b < 0) break;
      if(a < 0 && b >= 0){
        A[i] = B[b--];
        continue;
      }
      if(a >= 0 && b >= 0){
        if(A[a] > B[b]) A[i] = A[a--];
        else A[i] = B[b--];
      }
    }
  }
}
