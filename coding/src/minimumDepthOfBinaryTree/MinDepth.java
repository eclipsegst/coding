/**
 * Author : Zhaolong Zhong
 * Date   : Feb 1, 2015 7:24:26 PM
 * 
 * Problem:
 * Given  binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 */
package minimumDepthOfBinaryTree;

public class MinDepth {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
    }
  }
  
  public static int minDepth(TreeNode root) {
    if(root == null) return 0;
    if(root.left == null && root.right == null) return 1;
    if(root.left != null && root.right == null) return minDepth(root.left) + 1;
    if(root.left == null && root.right != null) return minDepth(root.right) + 1;
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1; 
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(10);
    System.out.println(minDepth(root));
  }
}
