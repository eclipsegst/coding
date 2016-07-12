package challenge;

/**
 * @author Zhaolong Zhong Jul 12, 2016
 * 
 * Binary Tree Longest Consecutive Sequence
 * 
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * For example,
 * 	 1
 *    \
 *     3
 *    / \
 *   2   4
 *        \
 *         5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *   2
 *    \
 *     3
 *    /
 *   2
 *  / 
 * 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/28234
 */
public class LongestConsecutiveBinaryTree {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, 0, root.val, max);
        return max[0];
    }
    
    private void helper(TreeNode root, int cur, int target, int[] max) {
    	if (root == null) return;
    	cur = root.val == target ? cur + 1 : 1;
    	
    	max[0] = Math.max(cur, max[0]);
    	helper(root.left, cur, root.val + 1, max);
    	helper(root.right, cur, root.val + 1, max);
    }
}
