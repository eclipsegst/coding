/**
 * Author : Zhaolong Zhong
 * Date   : Feb 2, 2015 9:37:35 PM
 *
 * Problem:
 * Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree:
 *     3
 *    / \
 *   9  20
 *      / \
 *     15  7
 * retrn its bottom-up lever order traversal as:
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 */
package binaryTree;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalTwo {
  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    if(root == null) return res;
    TreeNode END = new TreeNode(0);
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    Stack<List<Integer>> stack = new Stack<List<Integer>>();
    List<Integer> level = new LinkedList<Integer>();
    queue.add(root);
    queue.add(END);
    while(!queue.isEmpty()){
      TreeNode node = queue.poll();
      if(node != END){
        level.add(node.val);
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
      } else {
        stack.add(new LinkedList<Integer>(level));
        level.clear();
        if(!queue.isEmpty()) queue.add(END);
      }
    }
    while(!stack.isEmpty()){
      res.add(stack.pop());
    }
    return res;
  }
}
