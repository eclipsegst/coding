package challenge;
/*
 * Date: 2015-01-28 00:26
 * Problem:
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 */
public class RemoveElement {
  public static void main(String[] args){
    int[] A = {3,2,1,4,3};
    System.out.println(removeElement(A,3));
  }
  public static int removeElement(int[] A, int elem) {
    if(A.length == 0) return 0;
    int len = 0;
    for(int i=0; i<A.length; i++) {
      if(A[i] != elem) A[len++] = A[i];
    }
    return len;
  }
}
