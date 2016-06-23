package a;

/**
 * @author Zhaolong Zhong Jun 20, 2016
 * 
 * Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
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
 */
public class Islands {
	//Runtime: O(M * N) since each element is visited once only.
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		
		int count = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					numIslandsHelper(grid, i, j); // find all the lands connected to current one.
				}
			}
		}
		
		return count;
	}
	
	private void numIslandsHelper(char[][] grid, int i, int j) {
		// edge case: out of boundary or current position is water, then return
		if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') {
			return;
		}
		
		grid[i][j] = '0';
		numIslandsHelper(grid, i + 1, j);
		numIslandsHelper(grid, i - 1, j);
		numIslandsHelper(grid, i, j + 1);
		numIslandsHelper(grid, i, j - 1);
	}
	
	public static void main(String[] args) {
		Islands solution = new Islands();
		
		char[][] grid1 = new char[][]{
			{'1', '1', '1', '1', '0'},
			{'1', '1', '0', '1', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '0', '0'}
		};
		
		char[][] grid2 = new char[][]{
			{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '1', '0', '0'},
			{'0', '0', '0', '1', '1'}
		};
		
		System.out.println(solution.numIslandsUF(grid1));
		System.out.println(solution.numIslandsUF(grid2));
		
		// it will change original grid values
		System.out.println(solution.numIslands(grid1));
		System.out.println(solution.numIslands(grid2));
	}
	
	public int numIslandsUF(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		IslandsUnionFind uf = new IslandsUnionFind(grid);
		
		int[][] distance = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '0') {
					continue;
				}
				
				for (int[] d : distance) {
					int x = i + d[0];
					int y = j + d[1];
					
					if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
						int p = i * cols + j;
						int q = x * cols + y;
						
						uf.union(p, q);
					}
				}
			}
		}
		
		return uf.count;
	}
	
	// Runtime: (M + N) lg*N, M union on N objects.
	static class IslandsUnionFind {
		int[] id;
		int[] size;
		int count = 0;
		
		IslandsUnionFind(char[][] grid) {
			int row = grid.length;
			int col = grid[0].length;
			
			id = new int[row * col];
			size = new int[row * col];
			
			// initialize
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (grid[i][j] == '1') {
						int p = i * col + j;
						id[p] = p;
						size[p] = 0;
						count++;
					}
				}
			}
		}
		
		// find root of i
		public int find(int i) {
			while (i != id[i]) {
				i = id[id[i]]; // path compression
			}
			
			return i;
		}
		
		public void union(int p, int q) {
			int i = find(p);
			int j = find(q);
			
			// They are already connected since they have same root.
			if (i == j) {
				return;
			}
			
			// weighted, make the child of root stay flat
			if (size[i] < size[j]) {
				id[i] = j;
				size[j] += size[i];
			} else {
				id[j] = i;
				size[i] += size[j];
			}
			
			count--;
		}
	}
}
