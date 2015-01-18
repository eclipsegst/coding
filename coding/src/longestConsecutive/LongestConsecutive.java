package longestConsecutive;
import java.util.HashSet;
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
