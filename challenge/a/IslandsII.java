package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhaolong Zhong Jun 20, 2016
 */
public class IslandsII {
	
	static class IslandsIIUnionFind {
		private int[] id;
		private int[] size;
		private int count;
		private int rows;
		private int cols;
		
		public IslandsIIUnionFind(int rows, int cols) {
			this.id = new int[rows * cols + 1];
			this.size = new int[rows * cols + 1];
			this.rows = rows;
			this.cols = cols;
		}
		
		public int find(int p) {
			while (p != id[p]) {
				p = id[id[p]];
			}
			
			return p;
		}
		
		public void union(int p, int q) {
			int i = find(p);
			int j = find(q);
			
			if (i == j) {
				return;
			}
			
			if (size[i] > size[j]) {
				id[j] = i;
				size[i] += size[j];
			} else {
				id[i] = j;
				size[j] += size[i];
			}
			
			count--;
		}
		
		public int add(int i, int j) {
			int p = i * cols + j + 1;
			id[p] = p;
			size[p] = 1;
			count++;
			
			return p;
		}
		
		public boolean isConnected(int p, int q) {
			return find(p) == find(q);
		}
		
		public int getIdAtPosition(int x, int y) {
			if (x >= 0 && x < rows && y >= 0 && y < cols) {
				return id[x * cols + y + 1];
			}
			
			return -1;
		}
		
		public int size() {
			return this.count;
		}
	}
	
	public List<Integer> numIslands(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<Integer>();
		IslandsIIUnionFind islands = new IslandsIIUnionFind(m, n);
		
		int[][] distances = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		for (int[] position : positions) {
			int x = position[0], y = position[1];
			int p = islands.add(x, y);
			for (int[] d : distances) {
				int q = islands.getIdAtPosition(x + d[0], y + d[1]);
				if (q > 0 && !islands.isConnected(p, q)) {
					islands.union(p, q);
				}
			}
			
			result.add(islands.size());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		IslandsII solution = new IslandsII();
		
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
