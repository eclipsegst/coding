package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong May 26, 2016
 */
public class PathToNode {
	public List<TreeNode> path = new ArrayList<TreeNode>();
	
	public Boolean findPath(TreeNode root, TreeNode dest) {
		if (root == null) {
			return false;
		}
		
		if (root == dest || findPath(root.left, dest) || findPath(root.right, dest)) {
			path.add(root);
			return true;
		}
		
		return false;
	}
}
