/**
 * Author : Zhaolong Zhong
 * Date   : Feb 10, 2015 10:24:13 PM
 * Problem:
 * Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 */
package challenge;

public class ValidateBinarySearchTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public boolean isValidBST(TreeNode root) {
    int last = Integer.MIN_VALUE;
    boolean failed = false;
    if (root == null) return true;
    inorder(root, last, failed);
    
    return !failed;
  }
  
  void inorder(TreeNode root, int last, boolean failed) {
    if (root == null) return;
    if (failed) return;
    inorder(root.left, last, failed);
    if (last >= root.val) failed = true;
    last = root.val;
    inorder(root.right, last, failed);
  }
}
