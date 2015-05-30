/**
 * Author: Zhaolong Zhong
 * Date  : 2015 8:58:11 PM
 */
package endoffile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EndOfFile {
  public static void main(String[] args) {

    //// Read one line
    //    Scanner scanner = new Scanner(System.in);
    //    int i = 0;
    //    while(scanner.hasNext()) {
    //      i++;
    //      System.out.println(i + " " + scanner.next());
    //    }
    //    scanner.close();
    
    // Read multiple lines
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    int i = 0;

    try {
      while ((line = stdin.readLine()) != null){
        i++;
        System.out.println(i + " " + line);

      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
