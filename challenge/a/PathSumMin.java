package a;

import binaryTree.TreeNode;

/**
 * @author Zhaolong Zhong Jun 20, 2016
 */
public class PathSumMin {
	public int minPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		if (root.left != null && root.right == null) {
			return minPathSum(root.left) + root.val;
		}
		
		if (root.right != null && root.left == null) {
			return minPathSum(root.right) + root.val;
		}
		
		return Math.min(minPathSum(root.left), minPathSum(root.right)) + root.val;
	}
}
