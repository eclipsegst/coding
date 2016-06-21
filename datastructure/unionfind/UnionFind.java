package unionfind;

/**
 * @author Zhaolong Zhong Apr 3, 2016
 * 
 * Runtime: (M + N) lg*N, M union on N objects.
 */
public class UnionFind {
	private int[] id; // id[p] is the id of the component containing p
	private int[] size; // count number of objects in the tree rooted at i
	
	// initialize
	public UnionFind (int N) {
		id = new int[N];
		size = new int[N];
		
		for (int i = 0; i < N; i++) {
			id[i] = i; // set id of each object to itself
		}
	}
	
	// find what is the root of i
	// path compression: one pass and two pass: add second loop to set id[] of each examined node to the root.
	public int find(int i) {
		while (i != id[i]) {
			// simpler one-pass variant (path halving): make every other node in path point to its grandparent
//			id[i] = id[id[i]];
//			i = id[i];
			i = id[id[i]];
		}
		
		return i;
	}
	
	// check if p and q have the same root
	// running time: lgN
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	// merge components containing p and q, set the id of p's root to the id of q's root
	// the depth of any node x is at most lgN
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		
		if (i == j) {
			return;
		}
		
		if (size[i] < size[j]) {
			id[i] = j;
			size[j] += size[i];
		} else {
			id[j] = i;
			size[i] += size[j];
		}
	}
}
