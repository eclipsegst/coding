package challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Jun 28, 2016
 * 
 * Find Leaves of Binary Tree
 * 
 * Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.
 * Example:
 * Given binary tree 
 *        1
 *       / \
 *      2   3
 *     / \     
 *    4   5    
 *    Returns [4, 5, 3], [2], [1].
 * 
 * Explanation:
 * 1. Remove the leaves [4, 5, 3] from the tree
 *        1
 *       / 
 *      2          
 * 2. Remove the leaf [2] from the tree
 *        1          
 * 3. Remove the leaf [1] from the tree
 *       []   
 *    Returns [4, 5, 3], [2], [1].
 *    
 * Reference:
 * https://leetcode.com/discuss/110800
 */
public class FindLeavesofBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> leaves = new ArrayList<Integer>();
		
		while (root != null) {
			if (isLeave(root, leaves)) {
				root = null;
			}
			
			result.add(leaves);
			leaves = new ArrayList<Integer>();
		}
		
		return result;
    }
	
	public boolean isLeave(TreeNode node, List<Integer> leaves) {
		if (node.left == null && node.right == null) {
			leaves.add(node.val);
			return true;
		}
		
		if (node.left != null) {
			if (isLeave(node.left, leaves)) {
				node.left = null;
			}
		}
		
		if (node.right != null) {
			if(isLeave(node.right, leaves)) {
				node.right = null;
			}
		}
		
		return false;
	}
}
