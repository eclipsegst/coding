package invertbinarytree;

public class InvertTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);
        
        root.left = newLeft;
        root.right = newRight;
        
        return root;
    }

}
