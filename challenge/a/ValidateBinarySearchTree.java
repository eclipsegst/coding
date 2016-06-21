package a;

import java.util.Stack;
import binaryTree.TreeNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		long last = Long.MIN_VALUE; // keep track of last min value
		
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (cur.value <= last) {
					return false;
				}
				
				last = cur.value;
				cur = cur.right;
			}
		}
		
		return true;
	}
}
