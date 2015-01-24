package removeDuplicatesFromSortedArray;
/*
 * Date: 01/17/2015 22:20
 * Given a sorted array, remove the duplicates in place such that 
 * each element appear only once and return the new length. 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example, given input array A = [1,1,2], your function should return length = 2, 
 * and A is now [1,2].
*/
public class RemoveDuplicatesNavie {
  public static void main(String[] args) {
    int [] a = {1,2,2,3,3};
    System.out.println(removeDuplicatesNaive(a));
  }
  public static int removeDuplicatesNaive(int[] a) {
    if (a.length < 2) {
      return a.length;
    }
    
    int i = 1;
    int j = 0;
    
    while (i < a.length) {
      if (a[i] == a[j]) {
        i++;
      } else {
        j++;
        a[j] = a[i];
        i++;
      }
    }
    
    return j + 1;
  }
}
