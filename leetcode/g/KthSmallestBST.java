package g;

import java.util.Stack;

/**
 * @author Zhaolong Zhong Dec 28, 2015
 */
public class KthSmallestBST {
	public int kthSmallest(TreeNode root, int k) {
		int res = root.val;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		
		for (int i = 0; i < k; i++) {
			TreeNode node = stack.pop();
			res = node.val;
			if (node.right != null) {
				node = node.right;
				while(node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
		
		return res;
	}
}
