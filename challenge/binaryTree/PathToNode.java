package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong May 26, 2016
 */
public class PathToNode {
	public List<TreeNode> path = new ArrayList<TreeNode>();
	
	public Boolean findPath(TreeNode root, TreeNode target) {
		if (root == null) {
			return false;
		}
		
		if (root == target || findPath(root.left, target) || findPath(root.right, target)) {
			path.add(root);
			return true;
		}
		
		return false;
	}
	
	public List<TreeNode> pathNodes(TreeNode root, TreeNode target) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		
		if (root == null) {
			return result;
		}
		
		findPath(root, target, result);
		
		return result;
	}
	
	public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> result) {
		if (root == null) {
			return false;
		}
		
		if (root == target || findPath(root.left, target, result) || findPath(root.right, target, result)) {
			result.add(root);
			return true;
		}
		
		return false;
	}
}
