package google;

/**
 * @author Zhaolong Zhong Dec 27, 2015
 */
public class NumberOfIslands {
	
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int count = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					mergeDFS(grid, i, j);
				}
			}
		}
		
		return count;
	}
	
	private void mergeDFS(char[][] grid, int i, int j) {
		// check edge
		if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
			return;
		// if current cell is water or visited
		if (grid[i][j] != '1') return;
		
		grid[i][j] = '0';
		
		// merge all adjacent land
		mergeDFS(grid, i - 1, j);
		mergeDFS(grid, i + 1, j);
		mergeDFS(grid, i, j - 1);
		mergeDFS(grid, i, j + 1);
	}
}
