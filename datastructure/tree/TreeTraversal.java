package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhaolong Zhong Dec 11, 2015
 * Tree Traversal
 * https://en.wikipedia.org/wiki/Tree_traversal
 * 
 * For example,
 * 		 F
 * 	   /   \
 *    B     G
 *   / \     \
 *  A   D     I
 *     / \   /
 *    C   E H
 *    
 * Depth First Search
 * Pre-order: F,B, A, D, C, E, G, I, H
 * In-order: A, B, C, E, F, G, H, I
 * Post-order: A, C, E, D, B, H, I, G, I
 * 
 * Breadth First Search
 * Level order: F, B, G, A, D, I C, E, H
 */
public class TreeTraversal {
	// Depth First Search
	public void preOrder(TreeNode root) {
		if (root == null) return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(TreeNode root) {
		if (root == null) return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if (root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}
	
	// Breadth First Search
	public void levelOrder(TreeNode root) {
		if (root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.remove();
			System.out.print(node.val + " ");
			if (node.left != null) q.add(node.left);
			if (node.right != null) q.add(node.right);
		}
	}
}
