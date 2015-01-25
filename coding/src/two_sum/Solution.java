package two_sum;
import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    System.out.println("Two Sum:");
    int [] numbers = {2, 7, 11, 15};
    int [] res = twoSum(numbers, 26);
    System.out.println(res[0]);
    System.out.println(res[1]);
  }
  
  public static int [] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i=0; i<numbers.length; i++) {
      map.put(target - numbers[i], i);
    }
    
    for (int j=0; j<numbers.length; j++) {
      Integer n = map.get(numbers[j]);
      if (n != null && n != j) {
        if(j < n) {
          result[0] = j + 1;
          result[1] = n + 1;
        } else {
          result[0] = n + 1;
          result[1] = j + 1;
        }
      }
    }
    return result;
  }
}
