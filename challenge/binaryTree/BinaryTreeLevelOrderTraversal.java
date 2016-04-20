/**
 * Author : Zhaolong Zhong
 * Date   : Feb 2, 2015 7:50:55 PM
 * 
 * Problem:
 * Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree:
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its lever order traversal as:
 * [
 *  [3],
 *  [9, 20],
 *  [15,7]
 */
package binaryTree;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> lists = new LinkedList<List<Integer>>();
    if(root == null) return lists;
    TreeNode END = new TreeNode(0);
    Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
    queue.add(root);
    queue.add(END);
    List<Integer> level = new LinkedList<Integer>();
    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if(node == END){
        lists.add(new LinkedList<Integer>(level));
        level.clear();
        if(!queue.isEmpty()) queue.add(END);
      } else {
        level.add(node.val);
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
      }
    }
    return lists;
  }
}
