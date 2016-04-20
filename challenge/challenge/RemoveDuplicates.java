/**
 * Author : Zhaolong Zhong
 * Date   : 01/18/2015
 * 
 * Problem: 
 * Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For exmaple, 
 * Given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].
 */
package challenge;

public class RemoveDuplicates {
  public int removeDuplicates(int[] A) {
    if (A.length<=1) return A.length;
    
    int pos=0;
    for(int i=0; i<A.length-1; i++){
        if (A[i]!=A[i+1]){
            A[++pos] = A[i+1];
        }
    }
    return pos+1;      
  }
}
