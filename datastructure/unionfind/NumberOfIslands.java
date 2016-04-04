package unionfind;

/**
 * @author Zhaolong Zhong Apr 3, 2016
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surround by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surround by water.
 * 
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * 
 */
public class NumberOfIslands {
	
	static class UnionFind {
		private int[] id;
		private int[] sz;
		private int count = 0;
		
		UnionFind(char[][] grid) {
			int row = grid.length;
			int col = grid[0].length;
			this.id = new int[row * col];
			this.sz = new int[row * col];
			
			// initialize
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (grid[i][j] == '1') {
						int p = i * col + j;
						id[p] = p;
						sz[p] = 0;
						count++;
					}
				}
			}
		}
		
		public int find (int i) {
			while (i != id[i]) {
				id[i] = id[id[i]];
				i = id[i];
			}
			
			return i;
		}
		
		public void union(int p, int q) {
			int i = find(p);
			int j = find(q);
			
			if (i == j) {
				return;
			}
			
			if (sz[i] < sz[j]) {
				id[i] = j;
				sz[j] += sz[i];
			} else {
				id[j] = i;
				sz[i] += sz[j];
			}

			count--;
		}
		
		public int size() {
			return this.count;
		}
	}
	
	private int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		UnionFind islands = new UnionFind(grid);
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '0') {
					continue;
				}
				
				for (int[] d : direction) {
					int x = i + d[0];
					int y = j + d[1];
					
					if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
						int p = i * cols + j;
						int q = x * cols + y;
						islands.union(p, q);
					}
				}	
			}
		}
		
		return islands.size();
	}
	
	public static void main(String[] args) {
		char[][] grid1 = {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'},
		};
		
		char[][] grid2 = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'},
		};
		
		NumberOfIslands solution = new NumberOfIslands();
		System.out.println("using union-find test case 1:" + solution.numIslands(grid1));
		System.out.println("using union-find test case 2:" + solution.numIslands(grid2));
		
		System.out.println("using dfs test case 1:" + solution.numIslandsDFS(grid1));
		System.out.println("using dfs test case 2:" + solution.numIslandsDFS(grid2));
	}
	
	// Depth First Search
	public int numIslandsDFS(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int count = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfsHelper(grid, i, j);
				}
			}
		}
		
		return count;
	}
	
	private void dfsHelper(char[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') {
			return;
		}
		
		grid[i][j] = '0';
		
		dfsHelper(grid, i + 1, j);
		dfsHelper(grid, i - 1, j);
		dfsHelper(grid, i, j + 1);
		dfsHelper(grid, i, j - 1);
	}
}

