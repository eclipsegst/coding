/**
 * Author: Zhaolong Zhong
 * Date  : 2015 6:57:10 AM
 */
package string;


import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;

public class IPChecker {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    while(in.hasNext()) {
      String IP = in.next();
      System.out.println(IP.matches(new myRegex().pattern));
    }
  }
}

class myRegex {
  private static final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
  private static final String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
  public final String pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
  

  static {
    try {
      Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
      Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
    } catch (PatternSyntaxException e) {
      //logger.severe("Unable to compile pattern", e);
    }
  }
}
