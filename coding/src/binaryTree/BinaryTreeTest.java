package binaryTree;

import binaryTree.BinaryTree.Node;
import binaryTree.BinaryTree;

public class BinaryTreeTest {
	public static void main(String[] args){
		Node root = new Node(5);
		BinaryTree tree = new BinaryTree();
		System.out.println("Building tree with root value " + root.value);
		tree.insert(root, 1);
		tree.insert(root, 8);
		tree.insert(root, 6);
		tree.insert(root, 3);
		tree.insert(root, 9);
		System.out.println("Traversing tree in order");
		tree.printInOrder(root);
		System.out.println("Traversing tree front-to-back from location 7");
		tree.printFrontToBack(root, 7);
	}
}
