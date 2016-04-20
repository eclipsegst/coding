package challenge;

/*
 * Date: 01/16/2015 16:42
 * 
 * Problem:
 * 
 * Give a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally 
 * or vertically neighbor.
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * 
 * Given borad = 
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * 
 * word = "ABCCED", -> return true,
 * word = "SEE", -> return true,
 * word = "ABCB", -> return false.
 *  
 * 
 */

public class WordSearch {
  
  public static void main(String[] args){
    char[][] board = {
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };
    
    System.out.println(wordSearch(board,"ABCCED"));
    System.out.println(wordSearch(board,"SFCS"));
    System.out.println(wordSearch(board,"SEE"));
    System.out.println(wordSearch(board,"ABCB"));
    System.out.println(wordSearch(board,"BCCFSA"));
    
  }
  
  private static int n;
  private static int m;
  
  public static boolean wordSearch(char[][] board, String word){
    if (word == null) {
      return false;
    }
    
    n = board.length;
    m = board[0].length;
    boolean[][] visited = new boolean[n][m];
    if (m == 0 || n == 0) {
      return false;
    }
    
    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        if (SearchDFS(board,word,0,i,j, visited)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean SearchDFS(char[][] board, String word, int position, int i, int j, boolean[][] visited) {
    if (position == word.length()) {
      return true;
    }
    
    if (i < 0 || j < 0 || i >= n || j >= m) {
      return false;
    }
    
    if (visited[i][j]) {
      return false;
    }
    
    if (board[i][j] != word.charAt(position)) {
      return false;
    }
    visited[i][j] = true;
    boolean res = SearchDFS(board, word, position + 1, i-1, j, visited)
        || SearchDFS(board, word, position + 1, i+1, j, visited)
        || SearchDFS(board, word, position + 1, i, j-1, visited)
        || SearchDFS(board, word, position + 1, i, j+1, visited);
    
    visited[i][j] = false; // why set to false? 
    
    return res;
  }
}