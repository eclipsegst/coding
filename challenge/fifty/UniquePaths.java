package fifty;

/**
 * @author Zhaolong Zhong Dec 17, 2015
 */
public class UniquePaths {
	
	// O(mn) runtime, O(mn) space - Bottom-up dynamic programming
	public int uniquePaths(int m, int n) {
		int[][] mat = new int[m + 1][n + 1];
		mat[m-1][n] = 1;
		for (int r = m - 1; r >= 0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				mat[r][c] = mat[r + 1][c] + mat[r][c + 1];
			}
		}
		return mat[0][0];
	}
	
	// O(mn) runtime, O(mn) space - Bottom-up dynamic programming with obstacle
	public int uniquePathsWithObstacles(int[][] grid) {
		int m = grid.length;
		if (m == 0) return 0;
		int n = grid[0].length;
		int [][] mat = new int[m + 1][n + 1];
		mat[m - 1][n] = 1;
		for (int r = m - 1; r >=0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				mat[r][c] = (grid[r][c] == 1) ? 0 : mat[r + 1][c] + mat[r][c + 1];
			}
		}
		return mat[0][0];
	}
}
