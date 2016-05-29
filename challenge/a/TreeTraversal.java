package a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

import binaryTree.TreeNode;

/**
 * @author Zhaolong Zhong May 26, 2016
 */
public class TreeTraversal {
	public List<Integer> list = new ArrayList<>();
	
	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		inorder(root.left);
		list.add(root.value);
		inorder(root.right);
	}
	
	public void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		list.add(root.value);
		preorder(root.left);
		preorder(root.right);
	}
	
	public void postorder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);
		list.add(root.value);
	}
	
	public void levelorder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode tree = queue.getFirst();
			queue.removeFirst();
			list.add(tree.value);
			
			if (tree.left != null) {
				queue.add(tree.left);
			}
			
			if (tree.right != null) {
				queue.add(tree.right);
			}
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		travel(result, 0, root);
		
		return result;
	}
	
	private void travel(List<List<Integer>> result, int level, TreeNode cur) {
		if (cur == null) {
			return;
		}
		
		if (result.size() <= level) {
			result.add(new ArrayList<Integer>());
		}
		
		if (level % 2 == 0) {
			result.get(level).add(cur.value);
		} else {
			result.get(level).add(0, cur.value);
		}
		
		travel(result, level + 1, cur.left);
		travel(result, level + 1, cur.right);
	}
	
	public List<List<Integer>> zigzagLevelOrderDeque(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.add(null);
		deque.add(root);
		
		while (deque.size() > 1) {
			TreeNode node = deque.poll();
			if (node == null && deque.getFirst() == null) {
				break;
			} else if (node == null) {
				result.add(new ArrayList<Integer>());
				deque.add(null);
				continue;
			}
			
			result.get(result.size() - 1).add(node.value);
			
			if (node.left != null) {
				deque.add(node.left);
			}
			
			if (node.right != null) {
				deque.add(node.right);
			}
		}
		
		return result;
	}
	
	public void clear() {
		list.clear();
	}
	
	public static void main(String[] args) {
		TreeTraversal solution = new TreeTraversal();
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
		
		solution.inorder(r3);
		System.out.println(Arrays.toString(solution.list.toArray()));
		
		solution.clear();
		solution.preorder(r3);
		System.out.println(Arrays.toString(solution.list.toArray()));
		
		solution.clear();
		solution.postorder(r3);
		System.out.println(Arrays.toString(solution.list.toArray()));
		
		solution.clear();
		solution.levelorder(r3);
		System.out.println(Arrays.toString(solution.list.toArray()));
		
		List<List<Integer>> result = solution.zigzagLevelOrder(r3);
		System.out.println(Arrays.toString(result.toArray()));
		
		List<List<Integer>> result2 = solution.zigzagLevelOrderDeque(r3);
		System.out.println(Arrays.toString(result2.toArray()));
	}
}
