/**
 * Author: Zhaolong Zhong
 * Date  : 2015 5:49:33 AM
 */
package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loop {
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int m = 0, a = 0, b = 0, n = 0;
    try {
      m = Integer.parseInt(reader.readLine());
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String res = ""; 
    String line = "";
    try {
      for (int k = 0; k < m; k++) {
        line = reader.readLine();
        String[] str = line.split(" ");
        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);
        n = Integer.parseInt(str[2]);
        int sum = 0;
        for (int i = 0; i < n; i++) {
          int sum2 = 0;
          for (int j = 0; j <= i; j++) {
            sum2 += Math.pow(2,j);
          }
          
          sum = a + sum2 * b;
          res = res + String.valueOf(sum) + " ";
        }
        
        res += "\n";
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    System.out.println(res);
  }
}
