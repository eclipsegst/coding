/**
 * Author : Zhaolong Zhong
 * Date   : Jan 31, 2015 7:43:25 PM
 * 
 * Problem:
 * Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' value.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *  2
 *  /
 * 3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively? 
 */
package binaryTree;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
  public static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
  public static List<Integer> inorderTraversalIteratively(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode temp = root;
    while(!stack.isEmpty() || temp != null){
      
      if(temp != null) {
        stack.push(temp);
        temp = temp.left;
      } else{
        temp = stack.pop();
        list.add(temp.val);
        temp = temp.right;
      }
    }
    return list;
  }
  
  public static List<Integer> inorderTraversalRecursive(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    if(root != null){
      traversalRecursive(root.left, list);
      list.add(root.val);
      traversalRecursive(root.right, list);
    }
    return list;
  }
  
  private static void traversalRecursive(TreeNode root, List<Integer> list) {
    if(root != null) {
      traversalRecursive(root.left, list);
      list.add(root.val);
      traversalRecursive(root.right, list);
    }
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.right.left = new TreeNode(6);
    root.right.right.right = new TreeNode(8);
    
    List<Integer> list = new ArrayList<Integer>();
    //list = inorderTraversalRecursive(root);
    list = inorderTraversalIteratively(root);
    System.out.println(Arrays.toString(list.toArray()));
  }
}
