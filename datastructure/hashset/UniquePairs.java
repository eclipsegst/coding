/**
 * Author: Zhaolong Zhong
 * Date  : 2015 7:32:21 AM
 */
package hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class UniquePairs {
  public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = 0;
    try {
      n = Integer.parseInt(in.readLine());
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    int i = 0;
    String line = "";
    HashSet<String> set = new HashSet<String>();
    while (i < n) {
      try {
        line = in.readLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      set.add(line);
      System.out.println(set.size()); 
      i++;
    }
    
  }
}
