package challenge;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jul 3, 2016
 * 
 * Number of Connected Components in an Undirected Graph
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.
 * 
 * Example 1:
 * 0          3
 * |          |
 * 1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * 
 * Example 2:
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * 
 * Note:
 * You can assume that no duplicate edges will appear in edges. 
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class CountComponents {
	public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < n; i++) roots[i] = i;
        Arrays.fill(size, 1);
        
        for (int[] edge : edges) {
        	int p = find(roots, edge[0]);
        	int q = find(roots, edge[1]);
        	if (p != q) {
        		if (size[p] > size[q]) {
        			roots[q] = p;
        			size[p] += size[q];
        		} else {
        			roots[p] = q;
        			size[q] += size[p];
        		}
        		
        		n--;
        	}
        }
        
		return n;
    }
	
	public int find(int[] roots, int p) {
		while (roots[p] != p) {
			p = roots[roots[p]];
		}
		
		return p;
	}
	
	public static void main(String[] args) {
		CountComponents solution = new CountComponents();
		
		int[][] edges1 = new int[][]{{0, 1}, {1, 2}, {3, 4}};
		int[][] edges2 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
		System.out.println(solution.countComponents(5, edges1));
		System.out.println(solution.countComponents(5, edges2));
	}
}
