package a;

import java.util.Stack;

import binaryTree.TreeNode;

/**
 * @author Zhaolong Zhong Jun 1, 2016
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidBST {
	// In order iterative traversal
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        long last = Long.MIN_VALUE; // use Long.MIN_VALUE to handle edge case
        
        while (!stack.isEmpty() || cur != null) {
        	 if (cur != null) {
        		 stack.push(cur);
        		 cur = cur.left;
        	 } else {
        		 cur = stack.pop();
        		 if (cur.value <= last) {
        			 return false;
        		 }
        		 
        		 last = cur.value;
        		 
        		 cur = cur.right;
        	 }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	ValidBST solution = new ValidBST();
		TreeNode r0 = new TreeNode(0);
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		
		r3.left = r1;
		r3.right = r5;
		r1.left = r0;
		r1.right = r2;
		r5.left = r4;
		r5.right = r6;
		
		System.out.println(solution.isValidBST(r3));
    }
}
