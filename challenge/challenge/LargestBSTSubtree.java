package challenge;

import java.util.Stack;

/**
 * @author Zhaolong Zhong Jul 2, 2016
 * 
 * Largest BST Subtree
 * 
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 * Note:
 * A subtree must include all of its descendants.
 * 
 * Here's an example:
 * 	  10
 *    / \
 *   5  15      5
 *  / \   \    / \
 * 1   8   7  1   8
 * 
 * The Largest BST Subtree in this case is the highlighted one. 
 * The return value is the subtree's size, which is 3.
 * 
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubtree {
	public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[]{0};
        largestBSTSubtreeHelper(root, new long[]{Long.MIN_VALUE}, new long[]{Long.MAX_VALUE}, result);
        return result[0];
    }
	
	// O(n) bottom up
	private boolean largestBSTSubtreeHelper(TreeNode root, long[] min, long[] max, int[] result) {
		if (root == null) return true;
		
		int[] leftResult = new int[]{0};
		int[] rightResult = new int[]{0};
		long[] leftMax = new long[]{Long.MAX_VALUE}, leftMin = new long[]{Long.MIN_VALUE};
		long[] rightMax = new long[]{Long.MAX_VALUE}, rightMin = new long[]{Long.MIN_VALUE};
		
		boolean left = largestBSTSubtreeHelper(root.left, leftMin, leftMax, leftResult);
		boolean right = largestBSTSubtreeHelper(root.right, rightMin, rightMax, rightResult);

		if (left && right) {
			if ((root.left == null || root.val > leftMax[0]) && (root.right == null || root.val < rightMin[0])) {
				result[0] = leftResult[0] + rightResult[0] + 1;
				min[0] = root.left != null ? leftMin[0] : root.val;
				max[0] = root.right != null ? rightMax[0] : root.val;
				
				return true;
			}
		}
		
		result[0] = Math.max(leftResult[0], rightResult[0]);
		
		return false;
	}
	
	// O(n Log n)
	public int largestBSTSubtreeSlow(TreeNode root) {
        if (root == null) return 0;
        
        int[] max = new int[]{0};
        largestBSTSubtreeHelperDFS(root, max);
        return max[0];
    }
	
	// Recursively calling isValid()
	private void largestBSTSubtreeHelperDFS(TreeNode root, int[] max) {
		if (root == null) return;
		if (isValidBST(root)) {
			int size = size(root);
			if (max[0] < size) max[0] = size;
			return;
		}
		
		largestBSTSubtreeHelperDFS(root.left, max);
		largestBSTSubtreeHelperDFS(root.right, max);
	}
	
	private int size(TreeNode root) {
		int[] result = new int[]{0};
		sizeHelper(root, result);
		return result[0];
	}
	
	private void sizeHelper(TreeNode root, int[] result) {
		if (root == null) return;
		result[0] += 1;
		sizeHelper(root.left, result);
		sizeHelper(root.right, result);
	}
	
	private boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		long last = Long.MIN_VALUE;
		
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (cur.val <= last) {
					return false;
				}
				
				last = cur.val;
				cur = cur.right;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LargestBSTSubtree solution = new LargestBSTSubtree();
		TreeNode root = new TreeNode(10);
		TreeNode r1 = new TreeNode(1);
		TreeNode r5 = new TreeNode(5);
		TreeNode r7 = new TreeNode(7);
		TreeNode r8 = new TreeNode(8);
		TreeNode r15 = new TreeNode(15);
		
		root.left = r5;
		root.right = r15;
		r5.left = r1;
		r5.right = r8;
		r15.right = r7;
		
		System.out.println(solution.largestBSTSubtree(root));
		System.out.println(solution.largestBSTSubtreeSlow(root));
		
		TreeNode r2 = new TreeNode(2);
		r1.left = r2;
		
		System.out.println(solution.largestBSTSubtree(r1));
		System.out.println(solution.largestBSTSubtreeSlow(r1));
	}
}
