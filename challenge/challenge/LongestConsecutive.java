package challenge;
import java.util.HashSet;

/*
 * Problem:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.
 * Your algorithm should run in O(n) complexity.
 *
 * Solution:
 * Because it requires O(n) complexity, we can not solve the problem by sorting the array first. Sorting takes at least O(nlogn) time.
 * After an element is checked, it should be removed from the set. Otherwise, time complexity would be O(mn) in which m is the average length of all consecutive sequences.
 * An extreme case here: If n is number of elements, m is average length of consecutive sequence, and m==n, then the time complexity is O(n^2). The reason is that in this case, no element is removed from the set each time. You can use this array to get the point: {1,3,5,7,9}.
 */
public class LongestConsecutive {
  public static void main(String[] args) {
    int [] a = {1,4,3,8,2,9,10,13,11,12};
    System.out.println(longestConsecutive(a));
  }
  public static int longestConsecutive(int[] num){
    if (num.length == 0) {
      return 0;
    }
    int max = 1;
    HashSet<Integer> set = new HashSet<Integer>();
    for (int e : num) {
      set.add(e);
    }
    
    for (int e : num) {
      int left = e - 1;
      int right = e + 1;
      int count = 1;
      
      while (set.contains(left)) {
        count++;
        set.remove(left);
        left--;
      }
      
      while (set.contains(right)) {
        count++;
        set.remove(right);
        right++;
      }
      
      max = Math.max(count, max);
    }
    return max;
  }

}
