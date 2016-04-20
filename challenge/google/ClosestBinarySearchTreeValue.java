package google;

/**
 * @author Zhaolong Zhong Dec 23, 2015
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * 
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		int closest = root.val;
		if (root.left != null) {
			closest = closestValue(closestValue(root.left, target), closest, target);
		}
		
		if (root.right != null) {
			closest = closestValue(closestValue(root.right, target), closest, target);
		}
		return closest;
	}
	
	private int closestValue(int v1, int v2, double target) {
		if (Math.abs(target - v1) < Math.abs(target - v2))
			return v1;
		else return v2;
	}
}
