package challenge;

import java.util.Stack;

/**
 * @author Zhaolong Zhong Jul 2, 2016
 * 
 * Verify Preorder Serialization of a Binary Tree
 * 
 * One way to serialize a binary tree is to use pre-order traversal. 
 * When we encounter a non-null node, we record the node's value. 
 * If it is a null node, we record using a sentinel value such as #.
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * 
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * 
 * Example 2:
 * "1,#"
 * Return false
 * 
 * Example 3:
 * "9,#,#,1"
 * Return false
 * 
 * Solution:
 * we can keep removing the leaf node until there is no leaf to remove, replace leaf node (like 4 # #) with "#" for example,
 * 
 * 9 3 4 # # 1 # # 2 # 6 # #
 * | | |___| |___| |   |___|
 * | |   #     #   |    #
 * | |___|_____|   |____|
 * |     #            #
 * |__________________|
 *          #
 *
 */
public class VerifyPreorderSerialization {
	
	// Stack
	public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<String>();
        
        String[] strs = preorder.split(",");
        
        for (String str : strs) {
        	stack.push(str);
        	
        	while (stack.size() >= 3 
        			&& stack.get(stack.size() - 1).equals("#")
        			&& stack.get(stack.size() - 2).equals("#")
        			&& !stack.get(stack.size() - 3).equals("#")) {
        		stack.pop();
        		stack.pop();
        		stack.pop();
        		stack.add("#");
        	}
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
	
	public boolean isValidSerializationFast(String preorder) {
		String[] strs = preorder.split(",");
		
		int diff = 1;
		
		for (String str : strs) {
			if (--diff < 0) return false;
			if (!str.equals("#")) diff += 2;
		}
		
		return diff == 0;
	}
	
	public static void main(String[] args) {
		VerifyPreorderSerialization solution = new VerifyPreorderSerialization();
		
		String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//		String s = "9,3,4,#,#,#,2,#,#";
		System.out.println(solution.isValidSerialization(s));
		System.out.println(solution.isValidSerializationFast(s));
	}
}
