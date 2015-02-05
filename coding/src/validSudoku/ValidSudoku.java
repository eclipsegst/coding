/**
 * Author : Zhaolong Zhong
 * Date   : Feb 4, 2015 7:29:12 PM
 * Problem:
 * Determine if a Sudoku is valid. The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note: A valid Sudoku board(partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
package validSudoku;
import java.util.HashSet;
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    for(int x = 0; x < 9; x++){
      HashSet<Character> col = new HashSet<Character>();
      for(int y = 0; y < 9; y++) {
        char c = board[x][y];
        if(c != '.') {
          if(col.contains(c)) return false;
          col.add(c);
        }
      }
    }
    
    for(int x = 0; x < 9; x++){
      HashSet<Character> row = new HashSet<Character>();
      for(int y = 0; y < 9; y++) {
        char c = board[y][x];
        if(c != '.') {
          if(row.contains(c)) return false;
          row.add(c);
        }
      }
    }
    
    for(int x = 0; x < 9; x+=3){
      for(int y = 0; y < 9; y+=3) {
          HashSet<Character> block = new HashSet<Character>();
          for(int offset = 0; offset < 9; offset++){
              int ox = offset / 3;
              int oy = offset % 3;
              char c = board[x + ox][y + oy];
              if(c != '.'){
                  if(block.contains(c)) return false;
                  block.add(c);
              } 
          }
      }
    }
    return true;
  }
}