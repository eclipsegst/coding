package challenge;

/**
 * @author Zhaolong Zhong Jun 30, 2016
 * 
 * Bomb Enemy
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * 
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * 
 * Note that you can only put the bomb at an empty cell.
 * 
 * Example:
 * 
 * For the given grid
 * 
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * 
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 * Reference:
 * https://leetcode.com/discuss/109116
 * https://leetcode.com/discuss/109134
 */
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        	return 0;
        }
        
        int result = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int rowCache = 0;
        int[] colCache = new int[cols];
        
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (j == 0 || grid[i][j - 1] == 'W') {
        			rowCache = 0;
        			for (int k = j; k < cols && grid[i][k] != 'W'; k++) {
        				rowCache += grid[i][k] == 'E' ? 1 : 0;
        			}
        		}
        		
        		if (i == 0 || grid[i - 1][j] == 'W') {
        			colCache[j] = 0;
        			for (int k = i; k < rows && grid[k][j] != 'W'; k++) {
        				colCache[j] += grid[k][j] == 'E' ? 1 : 0;
        			}
        		}
        		
        		if (grid[i][j] == '0') {
        			result = Math.max(result, rowCache + colCache[j]);
        		}
        	}
        }
        
        return result;
    }
}
