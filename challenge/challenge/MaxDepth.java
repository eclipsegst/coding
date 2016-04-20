/**
 * Author : Zhaolong Zhong
 * Date   : Feb 1, 2015 8:11:11 PM
 * 
 * Problem:
 * Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the fathest leaf node.
 * 
 */
package challenge;

public class MaxDepth {
  public static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
    }
  }
  
  public static int maxDepth(TreeNode root) {
    if(root == null) return 0;
    return Math.max(maxDepth(root.left),  maxDepth(root.right)) + 1;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    System.out.println(maxDepth(root));
  }
}
