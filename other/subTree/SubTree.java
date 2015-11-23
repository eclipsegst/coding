package subTree;

/**
 * @author Zhaolong Zhong Nov 23, 2015
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) { val = x; }
}
public class SubTree {
	public static boolean isSubTree(TreeNode t1, TreeNode t2) {
		if (t1 == null) return false;
		if (t2 == null) return true;
		return (isSameTree(t1, t2) || isSubTree(t1.left, t2) || isSubTree(t1.right, t2));
	}
	
	public static boolean isSameTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return true;
		if (t1 == null || t2 == null) return false;
		if (t1.val != t2.val) return false;
		return (isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right));
	}
	
	public static void main (String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		root.left = node1;
		node1.left = node2;
		node1.right = node3;
		
		TreeNode child = new TreeNode(1);
		child.left = node2;
		child.right = node3;
		
		System.out.println(isSubTree(root, child));
	}
}
