package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

import binaryTree.TreeNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 	 3
 * 	/ \
 * 9   20
 * 	  /  \
 * 	 15   7
 * 
 * return its level order traversal as:
 * [
 * 	[3],
 * 	[9,20],
 * 	[15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        	return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // end flag of current level
        TreeNode END = new TreeNode(0);
       
        queue.add(root);
        queue.add(END);
        
        // keep track of current level node
        List<Integer> currentLevel = new LinkedList<Integer>();
        
        while (!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	// if we find the END of current level, then we add current level to result
        	// and clear current level
        	// we add END flag again only if the queue is not empty.
        	if (node == END) {
        		result.add(new LinkedList<Integer>(currentLevel));
        		currentLevel.clear();
        		if (!queue.isEmpty()) {
        			queue.add(END);
        		}
        	} else {
        		currentLevel.add(node.value);
        		if (node.left != null) {
        			queue.add(node.left);
        		}
        		
        		if (node.right != null) {
        			queue.add(node.right);
        		}
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
		TreeNode n3 = new TreeNode(3);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		TreeNode n15 = new TreeNode(15);
		TreeNode n20 = new TreeNode(20);
		
		n3.left = n9;
		n3.right = n20;
		n20.left = n15;
		n20.right = n7;
		
		List<List<Integer>> result = solution.levelOrder(n3);
		
		System.out.println(Arrays.deepToString(result.toArray()));
	}

}
