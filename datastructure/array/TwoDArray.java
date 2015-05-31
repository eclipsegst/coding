/**
 * Author: Zhaolong Zhong
 * Date  : 2015 7:43:54 AM
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDArray {
  public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int[][] array = new int[6][6];
    
    int i = 0;
    String line = "";
    while (i < 6) {
      
      try {
        line = in.readLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      String[] strs = line.split(" ");
      int j = 0;
      for (String s : strs) {
        array[i][j] = Integer.parseInt(s);
        j++;
      }
      
      i++;
    }
    
    int max = Integer.MIN_VALUE;
    int sum = 0;
    
    for (int m = 1; m < 5; m++) {
      for (int n = 1; n < 5; n++) {
        sum = array[m][n] + array[m-1][n-1] + array[m-1][n] + array[m-1][n+1] + array[m+1][n-1] + array[m+1][n] + array[m+1][n+1];
        if (max < sum) {
          max = sum;
        }
      }
    }
    System.out.println(max);
  }
}
