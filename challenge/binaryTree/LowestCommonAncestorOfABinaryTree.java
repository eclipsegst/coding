package binaryTree;

import tree.TreeNode;

/**
 * Problem: Lowest Common Ancestor of a Binary Search Tree
 * Given a binary tree (BST), find the lowest common ancestor(LCA)of two given nodes in the tree.
 * 
 * Solution:
 * Use inorder traversal
 * If a root is the lca, then we can find a given node in root.left and (root == other node or root.right contains other node).
 * We use check if root.right contain other if we find a given node in root.left.
 * We inorder root.right only if we cannot find a given node in root.left.
 * If we find the lca, all the sub routine must be terminated.
 * 
 */

public class LowestCommonAncestorOfABinaryTree {
    
	TreeNode lca;
    TreeNode other;
    
    boolean containOther(TreeNode root) {
        if (root == null) return false;
        if (root == other) return true;
        return containOther(root.left) || containOther(root.right);
    }
    
    void inorder(TreeNode root, TreeNode p, TreeNode q) {
        if (lca != null) return;
        if (root == null) return;
        
        if (other == null) inorder(root.left, p, q);
        
        // This is the first time to find p or q.
        if (other == null) {
            if (root == p) {
                other = q;
            } else if (root == q) {
                other = p;
            }
        }
        
        // Determine whether the root is lca or not.
        if (other != null) {
            if (root == other || containOther(root.right)) {
                lca = root;
            }
        }
        
        // Only traverse root.right when there is no p or q in root.left.
        if (other == null) inorder(root.right, p, q);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inorder(root, p, q);
        return lca;
    }
}
