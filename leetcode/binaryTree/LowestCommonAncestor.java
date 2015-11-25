package binaryTree;

import tree.TreeNode;

/**
 * Problem: Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor(LCA)of two given nodes in the BST.
 * For example,
 *            6
 *         /     \
 *       2        8
 *     /   \    /   \
 *    0     4  7     9
 *         / \
 *        3   5
 *	LCA(3, 5) = 4
 *	LCA(2, 8) = 6
 *  LCA(0, 3) = 2
 *  LCA(2, 9) = 6
 *  LCA(2, 4) = 2
 *  
 *  Solutions:
 *  Root to bottom traversal, stop when p.val <= root.val <= q.val
 * 
 */
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        
        while (!(p.val <= root.val && root.val <= q.val)) {
            if (q.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return root;
	}
}
