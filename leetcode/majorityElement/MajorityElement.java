/**
 * Author : Zhaolong Zhong
 * Date   : Jan 29, 2015 1:03:08 AM
 *
 * Problem:
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than floor n/2 times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 */
package majorityElement;

public class MajorityElement {
  public static int majorityElement(int[] num) {
    int n = num[0];
    int c = 1;
    for(int i = 1; i < num.length; i++){
      if (num[i] == n) {
        c++;
      } else if (c > 1){
        c--;
      } else {  // c == 1 && num[i] != n
        n = num[i];
      }
    }
    return n;
  }
  
  public static void main(String[] args) {
    int[] num = {1,2,3,2,4,1,1,2,2};
    System.out.println(majorityElement(num));
  }
}
