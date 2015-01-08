package binaryTree;

public class BinaryTree {
	static class Node{
		int value;
		Node left;
		Node right;
	
		public Node(int value){
			this.value = value;
		}
	}
	
	public void insert(Node node, int value){
		if(value < node.value){
			if(node.left != null){
				insert(node.left, value);
			}else{
				node.left = new Node(value);
			}
		}else if(value > node.value){
			if(node.right != null){
				insert(node.right, value);
			}else{
				node.right = new Node(value);
			}
		}else{
			System.out.println("There exists a node that has the same value.");
		}
	}
	
	public void printInOrder(Node node) {
	    if (node != null) {
	      printInOrder(node.left);
	      System.out.println("  Traversed " + node.value);
	      printInOrder(node.right);
	    }
	}
	
	public void printFrontToBack(Node node, int camera) {
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
	public int heightOfBinaryTree(Node node){
		if(node == null){
			return 0;
		}else{
			return 1 + Math.max(heightOfBinaryTree(node.left), heightOfBinaryTree(node.right));
		}
	}

}
