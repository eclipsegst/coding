package longestIncreasingSequence;
import java.util.HashSet;

public class LongestConsecutive {
  public int longestConsecutiveBasic(int[] n) {
    int max = 0;
    HashSet hs = new HashSet();
    for (int i : n) {
      hs.add(i);
      int count = 0;
      int temp = i;
      while(hs.contains(temp-1)) {
        hs.remove(temp-1);
        count++;
        temp--;
      }
      while(hs.contains(temp+1)) {
        hs.remove(temp+1);
        count++;
        temp++;
      }
      
      max =Math.max(max, count);
    }
    return max;
  }
}
