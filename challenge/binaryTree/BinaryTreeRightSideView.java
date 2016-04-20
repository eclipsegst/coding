package binaryTree;
/**
 * Author : Zhaolong Zhong
 * Date   : April 8, 2015 08:08:08 PM
 * Problem:
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return  the value of the nodes you can see ordered from top to bottom.
 * 
 */

import java.util.List;
import java.util.ArrayList;

public class BinaryTreeRightSideView {
  class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x; }
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    
    res.add(root.val);
    
    List<Integer> left = rightSideView(root.left);
    List<Integer> right = rightSideView(root.right);
    
    res.addAll(right);
    
    if (left.size() > right.size()) {
      res.addAll(left.subList(right.size(), left.size()));
    }
    
    return res;
  }
}
