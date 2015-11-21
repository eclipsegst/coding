package pathMinSum;

/**
 * @author Zhaolong Zhong Nov 21, 2015
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class PathMinSum {
	public int pathMinSum(TreeNode root) {
		if (root == null) return 0;
		if (root.left != null && root.right == null)
			return pathMinSum(root.left) + root.val;
		if (root.left == null && root.right != null)
			return pathMinSum(root.right) + root.val;
		return Math.min(pathMinSum(root.left), pathMinSum(root.right)) + root.val;
	}
}
