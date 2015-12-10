package fiftyShadeOfCode;

/**
 * @author Zhaolong Zhong Dec 9, 2015
 */

public class BinaryTree {
	
	// O(n^2) runtime - brute force
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		return isSubtreeLessThan(root.left, root.val)
				&& isSubtreeGreaterThan(root.right, root.val)
				&& isValidBST(root.left) && isValidBST(root.right);
	}
	
	private boolean isSubtreeLessThan(TreeNode p, int val) {
		if (p == null) return true;
		return p.val < val
				&& isSubtreeLessThan(p.left, val)
				&& isSubtreeLessThan(p.right, val);
	}
	
	private boolean isSubtreeGreaterThan(TreeNode p, int val) {
		if (p == null) return true;
		return p.val > val
				&& isSubtreeGreaterThan(p.left, val)
				&& isSubtreeGreaterThan(p.right, val);
	}
	
	// O(n) runtime, O(n) stack space - Top-down recursion:
	public boolean isValidBSTRecursion(TreeNode root) {
		return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean valid(TreeNode p, int low, int high) {
		if (p == null) return true;
		return p.val > low && p.val < high
				&& valid(p.left, low, p.val)
				&& valid(p.right, p.val, high);
	}
	
	// O(n) runtime, O(n) stack space - In-order traversal
	private TreeNode pre;
	public boolean isValidBSTInOrder(TreeNode root) {
		pre = null;
		return isMonotonicIncreasing(root);
	}
	
	private boolean isMonotonicIncreasing(TreeNode p) {
		if (p == null) return true;
		if (isMonotonicIncreasing(p.left)) {
			if (pre != null && p.val <= pre.val) return false;
			pre = p;
			return isMonotonicIncreasing(p.right);
		}
		return false;
	}
}
