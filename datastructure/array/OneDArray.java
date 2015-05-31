/**
 * Author: Zhaolong Zhong
 * Date  : 2015 8:16:03 AM
 */
package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneDArray {
  public static void main(String[] args){
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int time = 0;
    try {
      time = Integer.parseInt(in.readLine());
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    int i = 0;
    String line = "";
    while (i < time) {
      int n = 0, m = 0;
      try {
        line = in.readLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      String[] strs = line.split(" ");
      n = Integer.parseInt(strs[0]);
      m = Integer.parseInt(strs[1]);
      
      try {
        line = in. readLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      String[] strs2 = line .split(" ");
      
      strs2[0] = "2";
      
      for (int k=0; k < n; k++) {
        
        int ii = 0;
        while(strs2[k+ii] == "2" && k+ii+1 < strs2.length) {
            if (strs2[k+ii+1].equals("0")) {
              strs2[k+ii+1] = "2";
              
              if (k+ii+1+m < strs2.length && strs2[k+ii+1+m].equals("0") ) {
                strs2[k+ii+1+m] = "2";
              }
              
              ii++;
            } else {
              break;
            }
          
        }
        int jj = 0;
        
        while(strs2[k-jj].equals("2") && k-jj-1>0 ) {
          if (strs2[k-jj-1].equals("0")) {
            strs2[k-jj-1] = "2";
            
            if (k-jj-1+m < strs2.length && strs2[k-jj-1+m].equals("0") ) {
              strs2[k-jj-1+m] = "2";
            }
            
            jj++;
          } else {
            break;
          }
          
        }
        
        if (k+m < strs2.length && strs2[k].equals("2") && strs2[k+m].equals("0") ) {
          strs2[k+m] = "2";
        }
      }
      
      boolean flag = false;
      
      for (int x=0; x < n; x++) {
        if (strs2[x].equals("2") && n - x <= m) {
          flag = true;
        }
      }
      
      if (flag) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
