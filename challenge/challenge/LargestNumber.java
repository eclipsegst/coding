package challenge;
import java.util.Arrays;
import java.util.Comparator;
/*
 * Date: 01/23/2015 18:37
 * Problem:
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
  public static void main(String[] args) {
    int[] nums0 = {3, 30, 34, 5, 9};
    int[] nums1 = {301,30,34,5,9};
//    System.out.println(largestNumber(nums0));
//    System.out.println(largestNumber(nums1));
    System.out.println(largestNumberComp(nums0));
    System.out.println(largestNumberComp(nums1));  
  }

  public static String largestNumber(int[] num) {
    String[] ns = Arrays.stream(num)
        .mapToObj(Integer::toString)
        .sorted((x,y) -> (y + x).compareTo(x + y))
        .toArray(String[]::new);
    if ("0".equals(ns[0])) return "0"; // remove multiple leading zero, like "00" -> "0"
    return String.join("", ns);
  }
  
  public static String largestNumberComp(int[] num) {
    String[] temp = new String[num.length];
    for (int i=0; i<num.length; i++) {
      temp[i] = String.valueOf(num[i]);
    }
    Arrays.sort(temp, new Comparator<String>(){
      public int compare(String left, String right) {
        String leftRight = left.concat(right);
        String rightLeft = right.concat(left);
        return rightLeft.compareTo(leftRight);
      }
    });

//    StringBuffer buffer = new StringBuffer();
//    for (int i=0; i < temp.length; i++) {
//      buffer.append(temp[i]);
//    }
//    java.math.BigInteger result = new java.math.BigInteger(buffer.toString());
//    return result.toString();
    String str = "";
    for (int i=0; i<temp.length; i++) {
      str += temp[i];
    }
    return str.replaceFirst("^0+(?!$)", ""); // remove multiple leading zero
  }
  
}
