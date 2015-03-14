/**
 * Author: Zhaolong Zhong
 * Date  : Mar 14, 2015 3:56:47 PM
 *
 */
package isValidBST;

public class IsValidBST {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
  }
  private boolean failed;
  private long last;
  void inorder(TreeNode root) {
    if (root == null) return;
    if (failed) return;
    inorder(root.left);
    if (last >= root.val) failed = true;
    last = root.val;
    inorder(root.right);
  }
  
  public boolean isValidBST(TreeNode root) {
    last = Long.MIN_VALUE;
    failed = false;
    if (root == null ) return true;
    if (root.left == null && root.right == null) return true;
    inorder(root);
    return !failed;
  }
}
