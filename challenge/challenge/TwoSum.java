package challenge;
import java.util.HashMap;
import java.util.Map;
/*
 * Date: 2015-01-12 00:04:31
 * 
 * Problem:
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 */
public class TwoSum {
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
  
  // only if the array is sorted
  public static int[] twoSumSortedArray(int[] numbers, int target) {
    if (numbers.length < 2) {
      return new int[]{0,0};
    }
    int i = 0;
    int j = numbers.length -1;
    while(i < j) {
      if (numbers[i] + numbers[j] > target) {
        j--;
      } else if(numbers[i] + numbers[j] < target) {
        i++;
      } else {
        return new int[]{i + 1, j + 1};
      }
    }
    throw new RuntimeException();
  }
  
  //compact version
  public int [] twoSumCompact(int[] numbers, int target) {
    int[] res = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int t;
    for (int i = 0; i < numbers.length; i++) {
        t = target - numbers[i];
        if (map.keySet().contains(t)) {
                res[0] = map.get(t) + 1;
                res[1] = i + 1;
                break;
        } else {
            map.put(numbers[i], i);
        }
    }
    return res;
  }
  
  public static void main(String[] args) {
    System.out.println("Two Sum:");
    int [] numbers = {2, 7, 11, 15};
    int [] res = twoSum(numbers, 26);
    System.out.println(res[0]);
    System.out.println(res[1]);
  }
}
