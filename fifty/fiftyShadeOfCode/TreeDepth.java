package fiftyShadeOfCode;

/**
 * @author Zhaolong Zhong Dec 10, 2015
 */
public class TreeDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth(root.left),  maxDepth(root.right)) + 1;
	}
}
