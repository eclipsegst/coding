/**
 * Author : Zhaolong Zhong
 * Date   : Feb 2, 2015 10:34:47 PM
 * 
 * Problem:
 * Binary Tree Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22;
 *      5
 *     / \
 *    4   8
 *   /   / \
 *  11  13  4
 *  /\     / \
 * 7  2   5   1
 * return 
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 */
package binaryTree;

import java.util.List;
import java.util.ArrayList;
public class BinaryTreePathSumII {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(root == null) return res;
    
    return pathSum(root, sum, new ArrayList<Integer>());
  }
  List<List<Integer>> pathSum(TreeNode root, int sum, List<Integer> parent) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(root == null) return res;
    ArrayList<Integer> list = new ArrayList<Integer>(parent);
    list.add(root.val);
    if(root.left == null && root.right == null) {
      if(root.val == sum){
        res.add(list);
      }
      return res;
    }
    
    List<List<Integer>> left  =  pathSum(root.left, sum - root.val, list);
    List<List<Integer>> right = pathSum(root.right, sum- root.val, list);
    if(!left.isEmpty()) res.addAll(left);
    if(!right.isEmpty()) res.addAll(right);
    return res;
  }
  void addToList(List<List<Integer>> res, List<List<Integer>> temp) {
    if(!temp.isEmpty()) res.addAll(temp);
  }
}