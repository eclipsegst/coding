package maximumGap;
/*
 * Date: 2015-01-28 09:44
 * Problem:
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * 
 */
public class Solution {
  static class Bucket {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    void add(int n) {
      min = Math.min(min, n);
      max = Math.max(max, n);
    }
  }
  
  public static int maximumGap(int[] num) {
    int maxiGap = Integer.MIN_VALUE;
    if (num.length < 2) return 0;
    
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    
    for(int i = 0; i < num.length; i++){
      min = Math.min(min, num[i]);
      max = Math.max(max, num[i]);
    }
    
    int gap = (int) Math.ceil((double)(max - min) / (num.length-1));
    int n = (max - min)/gap + 1;
    Bucket[] buckets = new Bucket[n];
    
    for(int i = 0; i < num.length; i++){
      int index = (num[i] - min) / gap;
      if(buckets[index] == null) buckets[index] = new Bucket();
      buckets[index].add(num[i]);
    }
    
    int prev = min;
    
    for(int i = 0; i < buckets.length; i++){
      if(buckets[i] == null) continue;
      maxiGap = Math.max(maxiGap, buckets[i].min - prev);
      prev = buckets[i].max;
    }
    return maxiGap;
  }
  
  public static void main(String[] args) {
    int[] num = {4, 2, 3, 12, 8, 6};
    System.out.println(maximumGap(num));
  }
}