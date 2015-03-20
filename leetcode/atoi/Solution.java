package atoi;
/*
 * Date: 01/25/2015 21:11
 * 
 * Problem:
 * Implement atoi to convert a string to an integer.
 * Hint:
 * Edge cases: Sign, Whitespace, Overflow 
 */
public class Solution {
  public static void main(String[] args) {
    int res = atoi("2147483648");
    System.out.println(res);
    System.out.println('9'-'0');
  }
  public static int atoi(String str) {
    if (str == null || "".equals(str)) {
      return 0;
    }
    char[] sa = str.toCharArray();
    int sum = 0;
    int sign = 1;
    int s = 0;
    boolean signseen = false;
    while (s <sa.length && !('0' <= sa[s] && sa[s] <= '9')) {
      if (signseen) {
        break;
      }
      if (sa[s] == '-') {
        sign *= -1;
        signseen = true;
      } else if (sa[s] == '+') {
        signseen = true;
      } else if (sa[s] != ' ') {
        break;
      }
      s++;
    }
    int e = s;
    while(e < sa.length && ('0' <= sa[e] && sa[e] <= '9')) {
      e++;
    }
    boolean flag = false;
    for (int i=s; i<e; i++) {
      if(sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && sa[i] - '0' > Integer.MAX_VALUE % 10 ))
        flag = true;
      sum = sum * 10 + (sa[i] - '0');
    }
    if (flag) 
      if (sign > 0)
        return Integer.MAX_VALUE;
      else
        return Integer.MIN_VALUE;
    return sum * sign;
  }
}