package a;

import java.util.Scanner;
import binaryTree.TreeNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Serialize and Deserialize Binary Tree
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * 
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * 
 * Reference: 
 * https://leetcode.com/discuss/66117/easy-to-understand-java-solution
 * https://leetcode.com/discuss/81392/short-and-clear-recursive-java-solution
 */
public class SerializeBinaryTree {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
        	return "#";
        }
        
        return  "" + root.value + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return build(new Scanner(data));
    }
    
    private TreeNode build(Scanner scanner) {
    	if (!scanner.hasNext()) {
    		return null;
    	}
    	
    	String next = scanner.next();
    	if (next.equals("#")) {
    		return null;
    	}
    	
    	TreeNode root = new TreeNode(Integer.parseInt(next));
    	root.left = build(scanner);
    	root.right = build(scanner);
    	
    	return root;
    }
}

//Your SerializeBinaryTree object will be instantiated and called as such:
//SerializeBinaryTree codec = new SerializeBinaryTree();
//codec.deserialize(codec.serialize(root));
