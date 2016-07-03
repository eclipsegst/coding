package challenge;

import java.util.Stack;

/**
 * @author Zhaolong Zhong Jul 2, 2016
 * 
 * Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 *   2
 *  / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * 
 * Example 2:
 *   1
 *  / \
 * 2   3
 * Binary tree [1,2,3], return false.
 */
public class ValidateBST {
	
	public boolean isValidBSTInOrder(TreeNode root) {
		if (root == null) return true;
		return isValidBSTInOrderHelper(root, new long[]{Long.MIN_VALUE});
	}
	
	private boolean isValidBSTInOrderHelper(TreeNode root, long[] last) {
		if (root == null) return true;
		if (!isValidBSTInOrderHelper(root.left, last)) return false;
		if (root.val <= last[0]) {
			return false;
		} else {
			last[0] = root.val;
		}
		if (!isValidBSTInOrderHelper(root.right, last)) return false;
		
		return true;
	}
	
	//O(N)
	private boolean isValidBSTDFS(TreeNode root) {
		return isValidBSTDFSHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean isValidBSTDFSHelper(TreeNode root, long min, long max) {
		if (root == null) return true;
		if (root.val > min 
				&& root.val < max
				&& isValidBSTDFSHelper(root.left, min, root.val)
				&& isValidBSTDFSHelper(root.right, root.val, max)) {
			return true;
		}
		
		return false;
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
		ValidateBST solution = new ValidateBST();
		TreeNode root = new TreeNode(2);
		TreeNode r1 = new TreeNode(1);
		TreeNode r3 = new TreeNode(3);
		root.left = r3;
		root.right = r1;
		
		System.out.println(solution.isValidBSTInOrder(root));
		System.out.println(solution.isValidBSTDFS(root));
		System.out.println(solution.isValidBST(root));
	}
}
