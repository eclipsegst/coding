package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhaolong Zhong Apr 3, 2016
 * A 2d grid map of m rows and n columns is initially filled with water. 
 * We may perform an addLand operation which turns the water at position (row, col) into a land. 
 * Given a list of positions to operate, count the number of islands after each addLand operation. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example:
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land
 * 1 0 0
 * 0 0 0
 * 0 0 0 Number of islands = 1
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land
 * 1 1 0
 * 0 0 0
 * 0 0 0 Number of islands = 1
 * Operation #3: addLand(1, 2) turns the water at grid[0][1] into a land
 * 1 1 0
 * 0 0 1
 * 0 0 0 Number of islands = 2
 * Operation #4: addLand(2, 1) turns the water at grid[0][1] into a land
 * 1 1 0
 * 0 0 1
 * 0 1 0 Number of islands = 3
 * Return [1, 1, 2, 3]
 */
public class NumberOfIslandsII {
	static class UnionFind {
		private int[] id;
		private int[] sz;
		private int m, n, count;
		
		public UnionFind (int m, int n) {
			this.m = m;
			this.n = n;
			this.count = 0;
			this.id = new int[m * n + 1];
			this.sz = new int[m * n + 1];
		}
		
		public int find (int i) {
			while (i != id[i]) {
				id[i] = id[id[i]];
				i = id[i];
			}
			
			return i;
		}
		
		public boolean isConnected(int p, int q) {
			return find(p) == find(q);
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
		
		public int add (int x, int y) {
			int i = x * n + y + 1;
			id[i] = i;
			sz[i] = 1;
			count++;
			
			return i;
		}
		
		public int getId(int x, int y) {
			if (x >= 0 && x < m && y >= 0 && y < n) {
				return id[x * n + y + 1];
			}
			
			return 0;
		}
		
		public int size() {
			return this.count;
		}
	}
	
	private int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public List<Integer> numIslands(int m, int n, int[][] positions) {
		UnionFind islands = new UnionFind(m, n);
		List<Integer> result = new ArrayList<Integer>();
		for (int[] position : positions) {
			int x = position[0], y = position[1];
			int p = islands.add(x, y);
			
			for (int[] d : direction) {
				int q = islands.getId(x + d[0], y + d[1]);
				if (q > 0 && !islands.isConnected(p, q)) {
					islands.union(p, q);
				}
			}
			
			result.add(islands.size());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		NumberOfIslandsII solution = new NumberOfIslandsII();
		
		int m = 3, n = 3;
		int[][] positions = {
				{0, 0},
				{0, 1},
				{1, 2},
				{2, 1},
		};
		
		List<Integer> result = solution.numIslands(m, n, positions);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
