package gst;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Sudoku Solver
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * Reference:
 * https://leetcode.com/discuss/74029
 * https://leetcode.com/discuss/59369
 * https://leetcode.com/discuss/30482
 * 
 * Solution:
 * 1. try set a number from 1 to 9 in one position 
 * 2. check if the number is valid and if we can solve the rest recursively
 * 3. loop through all the position until we find solution.
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solve(board);
    }
	
	// Backtracking
	private boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					continue;
				}
				
				for (int k = 1; k <= 9; k++) {
					board[i][j] = (char)(k + '0');
					if (isValid(board, i, j) && solve(board)) {
						return true;
					}
					
					board[i][j] = '.';
				}
				
				return false;
			}
		}
		
		return true;
	}
	
	private boolean isValid(char[][] board, int a, int b) {
		// Check each number in current column is unique
		for (int i = 0; i < 9; i++) {
			if (i == a) {
				continue;
			}
			
			if (board[i][b] == board[a][b]) {
				return false;
			}
		}
		
		// Check each number in current row is unique
		for (int j = 0; j < 9; j++) {
			if (j == b) {
				continue;
			}
			
			if (board[a][j] == board[a][b]) {
				return false;
			}
		}
		
		// Check each number in current 3 * 3 sub square is unique
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
				
				if (x == a && y == b) {
					continue;
				}
				
				if (board[x][y] == board[a][b]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	//DFS
	public void solveSudokuDFS(char[][] board) {
		solveSudokuHelper(board, 0);
	}
	
	private boolean solveSudokuHelper(char[][] board, int d) {
		if (d == 81) {
			return true;
		}
		
		int i = d / 9, j = d % 9;
		
		// skip prefill number, do search directly
		if (board[i][j] != '.') {
			return solveSudokuHelper(board, d + 1);
		}
		
		boolean[] flag = new boolean[10];
		validate(board, i, j, flag);
		
		for (int k = 1; k <= 9; k++) {
			if (flag[k]) {
				board[i][j] = (char)('0' + k);
				if (solveSudokuHelper(board, d + 1)) {
					return true;
				}
			}
		}
		
		board[i][j] = '.'; // If we cannot solve, we need change back to '.'
		
		return false;
	}
	
	private void validate(char[][] board, int i, int j, boolean[] flag) {
		Arrays.fill(flag, true);
		
		for (int k = 0; k < 9; k++) {
			if (board[i][k] != '.') {
				flag[board[i][k] - '0'] = false;
			}
			
			if (board[k][j] != '.') {
				flag[board[k][j] - '0'] = false;
			}
			
			int r = i / 3 * 3 + k / 3;
			int c = j / 3 * 3 + k % 3;
			
			if (board[r][c] != '.') {
				flag[board[r][c] - '0'] = false;
			}
		}
	}
}
