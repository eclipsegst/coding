package linkedLists;

class Node {
	Node next = null;
	int data;
	public Node(int d) {
		data = d;
	}
	void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while (n.next != null){
			n.next = end;
		}
	}
	public void printNode() {
	    System.out.print("{" + data + "} ");
    }
}

class LinkedList {
	private Node first;
	public void insert(int d) {
		Node node = new Node(d);
	    node.next = first;
	    first = node;
	}
	public void printList() {
		Node currentNode = first;
		System.out.print("List: ");
		while(currentNode != null) {
			currentNode.printNode();
			currentNode = currentNode.next;
		    }
		    System.out.println("");
	    }
}

class TestLinkedLists {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.printList();
	}
}