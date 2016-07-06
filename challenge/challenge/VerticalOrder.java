package challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Zhaolong Zhong Jul 6, 2016
 * 
 * Binary Tree Vertical Order Traversal
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * 
 * Examples:
 * Given binary tree [3,9,20,null,null,15,7],
 *   3
 *  / \
 * /   \
 * 9   20
 *     /\
 *    /  \
 *   15   7
 * return its vertical order traversal as:
 * [
 *  [9],
 *  [3,15],
 *  [20],
 *  [7]
 * ]
 * 
 * Given binary tree [3,9,8,4,0,1,7],
 *      3
 *     / \
 *    /   \
 *   9    8
 *   /\   /\
 *  /  \ /  \
 * 4    01   7
 * return its vertical order traversal as:
 * [
 *  [4],
 *  [9],
 *  [3,0,1],
 *  [8],
 *  [7]
 * ]
 * 
 * Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 *     3
 *    /\
 *   /  \
 *   9   8
 *  /\  /\
 * /  \/  \
 * 4  01   7
 *    /\
 *   /  \
 *   5   2
 * return its vertical order traversal as:
 * [
 *  [4],
 *  [9,5],
 *  [3,0,1],
 *  [8,2],
 *  [7]
 * ]
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/31954
 */
public class VerticalOrder {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();
        
        queue.add(root);
        cols.add(0);
        
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	int col = cols.poll();
        	
        	if (!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
        	map.get(col).add(node.val);
        	
        	if (node.left != null) {
        		queue.add(node.left);
        		cols.add(col - 1);
        		if (col <= min) min = col - 1;
        	}
        	
        	if (node.right != null) {
        		queue.add(node.right);
        		cols.add(col + 1);
        		if (col >= max) max = col + 1;
        	}
        }
        
        for (int i = min; i <= max; i++) {
        	result.add(map.get(i));
        }
        
        return result;
	}
}
