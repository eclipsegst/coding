package threeSum;

import java.util.Arrays;
import java.util.ArrayList;
/*
 * Date: 01/23/2015 16:30
 * Problem:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-decending order.(ie, a <= b <= c)
 * The solution set must not contain duplicate triplets.
 * 
 * Hints:
 * Two pointers scan if the array is sorted, which give performance of O(n*n)
 */
public class ThreeSum {
  public static void main(String[] args) {
    //int[] nums = {-1, 0, 1, 2, -1, -4};
    int[] nums = {1,-1,-1,0};
    //Arrays.sort(nums);
    //System.out.println(nums[1]);
    printArrayList(threeSum(nums));
  }
  
  public static ArrayList<ArrayList<Integer>> threeSum (int[] num) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    
    if (num.length < 3) {
      return res;
    }
    
    Arrays.sort(num);
    
    for (int i=0; i < num.length - 2; i++) {
      if (i==0 || num[i] > num[i-1]) {
        int mid = i + 1;
        int end = num.length - 1;
        
        while (mid < end) {
          if (num[i] + num[mid] + num[end] == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(num[i]);
            temp.add(num[mid]);
            temp.add(num[end]);
            res.add(temp);
            
            mid ++;
            end --;
            while (mid < end && num[end] == num[end + 1])
              end --;
            while (mid < end && num[mid] == num[mid - 1])
              mid ++;
          } else if (num[i] + num[mid] + num[end] < 0) {
            mid ++;
          } else {
            end --;
          } 
        }
      }
    }
    
    return res;
  }
  
  public static void printArrayList(ArrayList<ArrayList<Integer>> list) {
    for (ArrayList<Integer> item : list) {
      for (int e : item) {
        System.out.print(e);
      }
      System.out.println();
    }
  }
}
