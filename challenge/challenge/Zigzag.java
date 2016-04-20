package challenge;

/*
 * Date: 2015-01-07 01:32:03
 * 
 * Problem:
 * Given a two dimension array, zig-zag print it, return the string with zig-zag print order. 
 * For example,
 * char c [][] = new char[][]{
 *   {'a', 'b', 'c'},
 *   {'d', 'e', 'f'},
 *   {'g', 'h', 'i'},
 *   {'j', 'k', 'l'}
 * };
 * 
 * return "adbcegjhfikl"
 * 
 */

public class Zigzag {
  public static String zigZag(char[][] c) {
    String res = "";
    int row = c.length;
    int col = c[0].length;
    int i = 0, j = 0;
    while(!(i == row- 1 && j == col - 1)) {
      res += c[i][j];
      if(i < row - 1){
        i++;
      } else if(j < col - 1){
        j++;
      }
      while(i > 0 && j < col - 1){
        res += c[i][j];
        i--;
        j++;
      }
      res += c[i][j];
      if(j < col -1){
        j++;
      } else if(i < row -1){
        i++;
      }
      while(j > 0 && i < row - 1){
        res += c[i][j];
        i++;
        j--;
      }
    }
    return res;
  }
}
