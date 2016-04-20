package google;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Dec 22, 2015
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * 
 *    1
 *  /   \
 * 2     3
 * \
 *  5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> path = new ArrayList<>();
		if (root == null) return path;
		
		findPaths(root, new StringBuilder(), path);
		return path;
	}
	
	// depth first search
	private void findPaths(TreeNode root, StringBuilder sb, List<String> path) {
		if (root.left == null && root.right == null) {
			sb.append(root.val);
			path.add(sb.toString());
			return;
		}
		
		sb.append(root.val);
		sb.append("->");
		
		if (root.left != null) {
			findPaths(root.left,  new StringBuilder(sb), path);
		}
		
		if (root.right != null) {
			findPaths(root.right, new StringBuilder(sb), path);
		}
	}
}
