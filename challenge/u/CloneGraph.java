package u;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import helpers.UndirectedGraphNode;

/**
 * @author Zhaolong Zhong Sep 29, 2016
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		
		queue.add(node);
		map.put(node, head);
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode currentNode = queue.poll();
			ArrayList<UndirectedGraphNode> currentNeighbors = currentNode.neighbors;
			
			for (UndirectedGraphNode neighbor : currentNeighbors) {
				if (!map.containsKey(neighbor)) {
					UndirectedGraphNode copiedNode = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, copiedNode);
					map.get(currentNode).neighbors.add(copiedNode);
					queue.offer(neighbor);
				} else {
					map.get(currentNode).neighbors.add(map.get(neighbor));
				}
			}
		}
		
		return head;
	}
	
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, head);
		cloneGraphDFSHelper(node, map);
		
		return head;
	}
	
	private void cloneGraphDFSHelper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (node == null) {
			return;
		}
		
		ArrayList<UndirectedGraphNode> neighbors = node.neighbors;
		
		for (UndirectedGraphNode neighbor : neighbors) {
			if (!map.containsKey(neighbor)) {
				UndirectedGraphNode copiedNode = new UndirectedGraphNode(neighbor.label);
				map.put(neighbor, copiedNode);
				map.get(node).neighbors.add(copiedNode);
				cloneGraphDFSHelper(neighbor, map);
			} else {
				map.get(node).neighbors.add(map.get(neighbor));
			}
		}
		
	}
	
	public void traverseGraphBFS(UndirectedGraphNode node) {
		if (node == null) {
			return;
		}
		
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		
		queue.add(node);
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode currentNode = queue.poll();
			if (!set.contains(currentNode)) {
				System.out.print(currentNode.label + " ");
				set.add(currentNode);
			}
			
			ArrayList<UndirectedGraphNode> currentNeighbors = currentNode.neighbors;
			
			for (UndirectedGraphNode neighbor : currentNeighbors) {
				if (!set.contains(neighbor)) {
					queue.offer(neighbor);
				}
			}
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		CloneGraph solution = new CloneGraph();
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode n3 = new UndirectedGraphNode(3);
		UndirectedGraphNode n4 = new UndirectedGraphNode(4);
		
		n1.neighbors.add(n2);
		n1.neighbors.add(n3);
		
		n2.neighbors.add(n1);
		n2.neighbors.add(n3);
		n2.neighbors.add(n4);
		
		n3.neighbors.add(n1);
		n3.neighbors.add(n2);
		n3.neighbors.add(n4);
		
		n4.neighbors.add(n2);
		n4.neighbors.add(n3);
		
		UndirectedGraphNode resultBFS = solution.cloneGraphBFS(n1);
		UndirectedGraphNode resultDFS = solution.cloneGraphDFS(n1);
		
		System.out.println("BFS:");
		solution.traverseGraphBFS(resultBFS);
		System.out.println("DFS:");
		solution.traverseGraphBFS(resultDFS);
	}
}
