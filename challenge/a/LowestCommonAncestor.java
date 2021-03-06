package a;

import binaryTree.TreeNode;

/**
 * @author Zhaolong Zhong May 26, 2016
 * 
 * Lowest Common Ancestor of a Binary Tree
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 */
public class LowestCommonAncestor {

	// Bottom-up approach O(n)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		if (left != null && right != null) {
			return root;
		}
		
		return left == null ? right : left;
	}
	
	public TreeNode lowestCommonAncestorInBinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestorInBinarySearchTree(root.left, p, q);
		}
		
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestorInBinarySearchTree(root.left, p, q);
		}
		
		return root;
	}
}
