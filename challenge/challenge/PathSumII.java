package challenge;

/**
 * @author Zhaolong Zhong Jun 20, 2016
 */
public class PathSumII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
        	return 0;
        }
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
        	return 0;
        }
        
        int dp[][] = new int[rows][cols];
        dp[0][0] = 1;
        
        for (int i = 1; i < rows; i++) {
        	if (obstacleGrid[i][0] == 1) {
        		dp[i][0] = 0;
        	} else {
        		dp[i][0] = dp[i - 1][0];
        	}
        }
        
        for (int j = 1; j < cols; j++) {
        	if (obstacleGrid[0][j] == 1) {
        		dp[0][j] = 0;
        	} else {
	        	dp[0][j] = dp[0][j - 1];
        	}
        }
        
        for (int i = 1; i < rows; i++) {
        	for (int j = 1; j < cols; j++) {
        		if (obstacleGrid[i][j] == 1) {
        			dp[i][j] = 0;
        		} else {
        			dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        		}
        	}
        }
        
        return dp[rows - 1][cols - 1];
    }
	
	public static void main(String[] args) {
		PathSumII solution = new PathSumII();
		
		int[][] grid1 = {
				{0,0,0},
				{0,1,0},
				{0,0,0}
		};
		
		System.out.println(solution.uniquePathsWithObstacles(grid1));
	}
}
