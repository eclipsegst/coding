package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree {
//  public Node root;
  public static void main(String[] args){
    TreeNode root = new TreeNode(5);
    System.out.println("Building tree with root value " + root.value);
    insert(root, 1);
    insert(root, 8);
    insert(root, 6);
    insert(root, 3);
    insert(root, 9);
    System.out.println("In-Order Traversal Recursive Solution");
    inOrderTraversalRecursive(root);
    System.out.println();
    System.out.println("In-Order Traversal Stack Iterative solution");
    System.out.println(inOrderTraversal(root).toString());
    System.out.println("In-Order Traversal Morris solution");
    System.out.println(inOrderTraversalMorris(root).toString());
    System.out.println("Pre-Order Traversal Recursive Solution");
    preOrderTraversalRec(root);
    System.out.println();
    System.out.println("Post-Order Traversal Recursive Solution");
    postOrderTraverseRec(root);
    System.out.println();
    System.out.println("Find Minimum");
    System.out.println(findMinimum(root));
    System.out.println("Traversing tree front-to-back from location 7");
    printFrontToBack(root, 7);
    System.out.println(heightOfBinaryTree(root));
  }
  
  public static void insert(TreeNode node, int value){
    if(value < node.value){
      if(node.left != null){
        insert(node.left, value);
      }else{
        node.left = new TreeNode(value);
      }
    }else if(value > node.value){
      if(node.right != null){
        insert(node.right, value);
      }else{
        node.right = new TreeNode(value);
      }
    }else{
      System.out.println("There exists a node that has the same value.");
    }
  }
  
  public static int findMinimum(TreeNode node){
    if (node == null) {
      return 0;
    }
    TreeNode currNode = node;
    while(currNode.left != null){
      currNode = currNode.left;
    }
    return currNode.value;
  }
  
  public static int findMaxium(TreeNode node){
    if (node == null) {
      return 0;
    }
    TreeNode currNode = node;
    while(currNode.right != null){
      currNode = currNode.right;
    }
    return currNode.value;
  }
  
  /*In-Order traverse the tree in recursive way*/
  public static void inOrderTraversalRecursive(TreeNode node) {
    if (node != null) {
      inOrderTraversalRecursive(node.left);
      System.out.print(node.value);
      inOrderTraversalRecursive(node.right);
    }
  }

  /*Solution 1: Use a stack. Time: O(n), Space: O(log n)*/
  public static ArrayList<Integer> inOrderTraversal(TreeNode root) {
	ArrayList<Integer> res = new ArrayList<Integer>();
	if (root == null) return res;
	
	Stack<TreeNode> s = new Stack<TreeNode>();
	TreeNode cur = root;
	while (!s.isEmpty() || cur != null){
		if (cur != null){
			s.push(cur);
			cur = cur.left;
		}else{
			cur = s.pop();
			res.add(cur.value);
			cur = cur.right;
		}
	}
	return res;
  }
  
  /*Morris algorithm. Time:O(n), Space: O(1) cause only use two pointers.*/
  public static ArrayList<Integer> inOrderTraversalMorris(TreeNode root){
	ArrayList<Integer> res = new ArrayList<Integer>();
	TreeNode cur = root, next = null;
	while (cur != null) {
	  if (cur.left != null) {
		  next = cur.left; // next pointer to cur.left
		  while (next.right != null && next.right != cur) {
			  next = next.right;
		  }
		  
		  if(next.right == null){
			  next.right = cur; // connect right bottom node of left root to root
			  cur = cur.left;
		  }else{
			  next.right = null;
			  res.add(cur.value);
			  cur = cur.right;
		  }
	  }else{
		  res.add(cur.value);
		  cur = cur.right;
	  }
	}
	return res;
  }
  
  /*Pre-Order traverse the tree in recursive way*/
  public static void preOrderTraversalRec(TreeNode node){
    if (node != null) {
      System.out.print(node.value);
      preOrderTraversalRec(node.left);
      preOrderTraversalRec(node.right);
    }
  }
  
  /*Post-Order traverse the tree in recursive way*/
  public static void postOrderTraverseRec(TreeNode node) {
    if (node != null) {
      postOrderTraverseRec(node.left);
      postOrderTraverseRec(node.right);
      System.out.print(node.value);
    }
  }

  public static void printFrontToBack(TreeNode node, int camera) {
    if (node == null)
      return;
    if (node.value > camera) {
      // print in order
      printFrontToBack(node.left, camera);
      System.out.println("  Traversed " + node.value);
      printFrontToBack(node.right, camera);
    } else if (node.value < camera) {
      // print reverse order
      printFrontToBack(node.right, camera);
      System.out.println("  Traversed " + node.value);
      printFrontToBack(node.left, camera);
    } else {
      // order doesn't matter
      printFrontToBack(node.left, camera);
      printFrontToBack(node.right, camera);
    }
  }
  public static int heightOfBinaryTree(TreeNode node){
    if(node == null){
      return 0;
    }else{
      return 1 + Math.max(heightOfBinaryTree(node.left), heightOfBinaryTree(node.right));
    }
  }

}
