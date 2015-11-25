package treeAmplitude;

import tree.TreeNode;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 */
public class TreeAmplitude {
	public int treeAmplitude(TreeNode root) {
		if (root == null) return 0;
		return dfsGetAmplitude(root, root.val, root.val);
	}
	
	private int dfsGetAmplitude(TreeNode root, int min, int max) {
		if (root == null) return max - min;
		
		if (root.val < min) min = root.val;
		if (root.val > max) max = root.val;
		
		return Math.max(dfsGetAmplitude(root.left, min, max), dfsGetAmplitude(root.right, min, max));
	}
}
