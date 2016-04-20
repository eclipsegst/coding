package challenge;
/*
 * Date: 2015-01-28 12:05
 * Problem:
 * Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] !=� num[i+1], find a peak element and return its index.
 * 
 * Note: Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {
  static int findPeakElement(int[] num, int from, int to) {
    if (to - from == 1) return from;
    
    int mid = (from + to) / 2;
    
    int l = findPeakElement(num, from, mid);
    int r = findPeakElement(num, mid, to);
    
    if (num[l] > num[r]) return l;
    else return r;
  }
  public static int findPeakElement(int[] num){
    return findPeakElement(num, 0, num.length);
  }
  
  public static void  main(String[] args){
    int[] num = {3, 1, 2, 4, 1, 3, 2, 5, 1};
    int res = findPeakElement(num);// res = 7
    System.out.println(res);
  }
}