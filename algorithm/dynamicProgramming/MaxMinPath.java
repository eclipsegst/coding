package dynamicProgramming;

/**
 * @author Zhaolong Zhong Mar 25, 2016
 * 
 * [8, 4, 7]
 * [6, 5, 9]
 * 
 * Path:
 * 8-4-7-9 min: 4
 * 8-4-5-9 min: 4
 * 8-6-5-9 min: 5
 * 
 * return 5
 */
public class MaxMinPath {
	
	public int maxMinPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;

		int row = matrix.length;
		int col = matrix[0].length;

		int[][] dp = new int[row][col];

		dp[0][0] = matrix[0][0];

		for (int i = 1; i < row; i++) {
			dp[i][0] = Math.min(dp[i-1][0], matrix[i][0]);
		}
	
		for (int j = 1; j < col; j++) {
			dp[0][j] = Math.min(dp[0][j], matrix[0][j]);
		}
	
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.max(Math.min(dp[i-1][j], matrix[i][j]), Math.min(dp[i][j-1], matrix[i][j]));
			}
		}
	
		return dp[row-1][col-1];
	}
	
	// Use DFS
	public int maxMinPathDFS(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
		
		int[] maxValue = new int[]{Integer.MIN_VALUE};
		dfs(matrix, maxValue, Integer.MAX_VALUE, 0, 0);
		
		return maxValue[0];
	}
	
	private void dfs(int[][] matrix, int[] maxValue, int minValue, int i, int j) {
		if (i == matrix.length || j == matrix[0].length) {
			return;
		}
		
		minValue = Math.min(minValue, matrix[i][j]);
		
		if (i == matrix.length - 1 && j == matrix[0].length - 1) {
			maxValue[0] = Math.max(maxValue[0], minValue);
		}
		
		dfs(matrix, maxValue, minValue, i + 1, j);
		dfs(matrix, maxValue, minValue, i, j + 1);
	}
	
	public static void main(String[] args) {
		MaxMinPath solution = new MaxMinPath();
		int[][] testCase = new int[][]{{8,4,7},{6,5,9}};
		System.out.println("Use dp:" + solution.maxMinPath(testCase));
		System.out.println("Use dfs:" + solution.maxMinPathDFS(testCase));
	}
}
