package challenge;

/**
 * @author Zhaolong Zhong Jun 30, 2016
 * 
 * Closest Binary Search Tree Value
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * 
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
        if (root == null) {
        	return 0;
        }
        
        long[] result = new long[]{Long.MAX_VALUE};
        double[] diff = new double[]{Double.MAX_VALUE};
        
        closestValueHelper(root, target, diff, result);
        
        return (int)result[0];
    }
	
	private void closestValueHelper(TreeNode root, double target, double[] diff, long[] result) {
		if (root == null || result[0] == target) {
			return;
		}
		
		double t = Math.abs(root.val - target);
		if (t < diff[0]) {
			diff[0] = t;
			result[0] = root.val;
		}
		
		closestValueHelper(root.left, target, diff, result);
		closestValueHelper(root.right, target, diff, result);
	}
	
	public static void main(String[] args) {
		ClosestBinarySearchTreeValue solution = new ClosestBinarySearchTreeValue();
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		root.left = left;
		System.out.println(solution.closestValue(root, 2147483647.0));
	}
}
