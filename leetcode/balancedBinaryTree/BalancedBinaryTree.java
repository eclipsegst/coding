/**
 * Author: Zhaolong Zhong
 * Date  : Jan 28, 2015 10:22:33 PM
 *
 * Problem:
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two substrees of every node never differ by more than 1.
 */
package balancedBinaryTree;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x;}
}

public class BalancedBinaryTree {
  public 
  
  static int height(TreeNode root) {
    if (root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
  }
  
  public static boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left)&& isBalanced(root.right); 
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(4);
    root.right = new TreeNode(12);
    root.left.left = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.left.left.left = new TreeNode(1);
    System.out.println(isBalanced(root)); // false
  }
}
