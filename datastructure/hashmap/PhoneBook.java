/**
 * Author: Zhaolong Zhong
 * Date  : 2015 4:04:12 AM
 * 
 * Problem:
 * 
  Sample Input:
    3
    uncle sam
    99912222
    tom
    11122222
    harry
    12299933
    uncle sam
    uncle tom
    harry
    
  Sample Output:
    uncle sam=99912222
    Not found
    harry=12299933
 */
package hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PhoneBook {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    int i = 0;
    int n = 0;
    String line = "";
    HashMap<String, String> map = new HashMap<String, String>();
    String name = "";
    String phone = "";
    try {
      while((line = stdin.readLine()) != null) {
        if (i != 0) {
          if (i % 2 != 0) {
            name = line;
          } else {
            phone = line;
            map.put(name, phone);
            name = "";
            phone = "";
          }
        } else {
          n = Integer.parseInt(line);
        }
        
        i++;
        
        if (i > n * 2) break;
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    try {
      while((line = stdin.readLine()) != null) {
        if (map.containsKey(line)) {
          System.out.println(line + "=" + map.get(line));
        } else {
          System.out.println("Not found");
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
