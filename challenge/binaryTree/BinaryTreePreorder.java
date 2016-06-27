package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Zhaolong Zhong Jun 22, 2016
 */
public class BinaryTreePreorder {
	
	public List<Integer> preorder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (root == null) {
			return result;
		}
		
		preorderHelper(root, result);
		
		return result;
	}
	
	private void preorderHelper(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		
		result.add(root.val);
		preorderHelper(root.left, result);
		preorderHelper(root.right, result);
	}
	
	//iteratively
	public List<Integer> preorderIter(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (root == null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur.left);
				cur = cur.left;
			} else {
				cur = stack.pop();
				result.add(cur.val);
				cur = cur.right;
			}
		}
		
		return result;
	}
}
