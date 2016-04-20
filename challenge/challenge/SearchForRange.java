package challenge;

/*
 * Date: 01/19/2015 22:00
 * Problem:
 * Search for a range
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm��s runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return[-1.-1].
 * For example,
 * [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3,4]
 */

public class SearchForRange {
  public static void main(String[] args) {
    int[] a = {5, 7, 7, 8, 8, 10};
//    int[] res = SearchRange(a,8);
    int[] res = searchRangeImproved(a,8);
    System.out.println("["+res[0]+","+res[1]+"]");
  }
  public static int[] SearchRange(int[] a, int t) {
    int start, mid, end;
    int[] res = new int[2];
    
    if (a.length==0) {
      res[0] = res[1] = -1;
      return res;
    }
    
    // search for the left bound
    start = 0;
    end = a.length - 1;
    while (start + 1 < end) {
      mid = start + (end - start)/2;
      if (a[mid] >= t) {
        end = mid;
      } else {
        start = mid;
      }
    }
    if (a[start] == t) {
      res[0] = start;
    } else if (a[end] == t) {
      res[0] = end;
    } else {
      res[0] = res[1] = -1;
      return res;
    }
    // search for the right bound
    start = 0;
    end = a.length -1;
    while (start + 1 < end) {
      mid = start + (end-start)/2;
      if(a[mid] <= t) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (a[end] == t) {
      res[1] = end;
    } else if (a[start] == t) {
      res[1] = start;
    } else {
      res[0] = res[1] = -1;
      return res;
    }
    return res;
  }
  
  public static int[] searchRangeImproved(int[] A, int target) {
    int s = 0;
    int e = A.length;
    while(s < e){
      int mid = (s + e) / 2;
      if(A[mid] == target) {
        int ss = mid;
        int ee = mid;
        while(ss - 1 >= 0 && A[ss-1] == target)
          ss--;
        while(ee + 1 < A.length && A[ee+1] == target) 
          ee++;
        return new int[]{ss,ee};
      } else if(A[mid] < target){
        s = mid + 1;
      } else if(A[mid] > target){
        e = mid;
      }
    }
    return new int[] {-1,-1};
  }
}
