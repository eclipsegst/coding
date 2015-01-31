/**
 * Author : Zhaolong Zhong
 * Date   : Jan 31, 2015 3:11:11 PM
 * 
 * Problem:
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * - Given numerator = 1, denominator = 2, return "0.5".
 * - Given numerator = 2, denominator = 1, return "2".
 * - Given numerator = 2, denominator = 3, return "0.(6)".
 */
package fractionToRecurringDecimal;
import java.util.Map;
import java.util.HashMap;

public class FractionToDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    String res = "";
    if(Math.signum(numerator) * Math.signum(denominator) < 0){
      res = "-";
    }
    long remainder = numerator;
    long quotient = remainder / denominator;  // integer, beofore "."
    remainder %= denominator;
    remainder *= 10;
    res += Math.abs(quotient);
    Map<String, Integer> map = new HashMap<String, Integer>();
    int i = 0;
    StringBuilder sb = new StringBuilder();
    while(remainder != 0){
      quotient = Math.abs(remainder / denominator);
      remainder %= denominator;
      Integer start = map.get(remainder + "," + quotient);
      if(start != null){
        sb.insert(start, "(");
        sb.append(")");
        break;
      }
      sb.append(quotient);
      map.put(remainder + "," + quotient, i);
      remainder *= 10;
      i++;
    }
    String fractionalPart = sb.toString();
    if(!"".equals(fractionalPart)) fractionalPart = "." + fractionalPart;
    res += fractionalPart;
    return res;
  }
}
