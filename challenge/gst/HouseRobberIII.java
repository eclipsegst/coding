package gst;

import binaryTree.TreeNode;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * House Robber III
 * 
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
 * 	   3
 * 	  / \
 *   2   3
 *    \   \ 
 *     3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *     3
 *    / \
 *   4   5
 *  / \   \ 
 * 1   3   1
 *
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * Solution:
 * DFS search all the nodes of the tree. 
 * Each node return two number int[] num. 
 * num[0] is the maximum value while rob this node.
 * num[1] is the maximum value while not rob this node.
 * Current node return value only depend on its children's value.
 * 
 * Reference: 
 * https://leetcode.com/discuss/91597
 * https://leetcode.com/discuss/91899
 */
public class HouseRobberIII {
	// DFS
	public int rob(TreeNode root) {
		int[] num = robHelper(root);
		return Math.max(num[0], num[1]);
	}
	
	private int[] robHelper(TreeNode root) {
		if (root == null) {
			return new int[2];
		}
		
		int[] left = robHelper(root.left);
		int[] right = robHelper(root.right);
		int[] result = new int[2];
		
		result[0] = left[1] + right[1] + root.val;
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		return result;
	}
	
	// Simple recursive solution
	public int robRecursive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int val = 0;
		
		if (root.left != null) {
			val += rob(root.left.left) + rob(root.left.right);
		}
		
		if (root.right != null) {
			val += rob(root.right.left) + rob(root.right.right);
		}
		
		return Math.max(val + root.val, rob(root.left) + rob(root.right));
	}
	
	public static void main(String[] args) {
		HouseRobberIII solution = new HouseRobberIII();
		TreeNode root1 = new TreeNode(3);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(1);
		
		root1.left = n1;
		root1.right = n2;
		n1.right = n3;
		n2.right = n4;
		
		System.out.println(solution.rob(root1));
		
		TreeNode root2 = new TreeNode(3);
		TreeNode n11 = new TreeNode(4);
		TreeNode n12 = new TreeNode(5);
		TreeNode n13 = new TreeNode(1);
		TreeNode n14 = new TreeNode(3);
		TreeNode n15 = new TreeNode(1);
		
		root2.left = n11;
		root2.right = n12;
		n11.left = n13;
		n11.right = n14;
		n2.right = n15;
		
		System.out.println(solution.rob(root2));
	}
}
