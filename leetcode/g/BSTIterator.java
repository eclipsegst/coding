package g;

import java.util.Stack;

/**
 * @author Zhaolong Zhong Dec 28, 2015
 */
public class BSTIterator {
	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	
	/**@return whether we have next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	/**@return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		int res = node.val;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return res;
	}
}

/**
 * Your BSTItertor will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 * 
 */
