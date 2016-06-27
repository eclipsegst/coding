package gst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Clone Graph
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	
	UndirectedGraphNode(int x ) {
		this.label = x;
		this.neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class CloneGraph {
	// BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
        	return null;
        }
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        //map of original node and copied node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        
        queue.add(node);
        map.put(node, head);
        
        while (!queue.isEmpty()) {
        	UndirectedGraphNode cur = queue.pop();
        	
        	List<UndirectedGraphNode> neighbors = cur.neighbors;
        	
        	for (UndirectedGraphNode neighbor: neighbors) {
        		if (!map.containsKey(neighbor)) {
        			UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
        			map.put(neighbor, newNode);
        			map.get(cur).neighbors.add(newNode);
        			queue.add(neighbor);
        		} else {
        			// if we have already visited the node, which means we have already copied the node.
        			// then we just get the copied node and add to current neighbors 
        			map.get(cur).neighbors.add(map.get(neighbor));
        		}
        	}
        }
        
        return head;
	}
	
	// DFS
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null) {
        	return null;
        }
        
        //map of original node and copied node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        
        cloneGraphDFSHelper(map, node);
        
        return head;
	}
	
	private void cloneGraphDFSHelper(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
		if (node == null) {
			return;
		}
		
		for (UndirectedGraphNode neighbor: node.neighbors) {
    		if (!map.containsKey(neighbor)) {
    			UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
    			map.put(neighbor, newNode);
    			cloneGraphDFSHelper(map, neighbor);
    		}
    		
    		map.get(node).neighbors.add(map.get(neighbor));
    	}
	}
	
	// DFS II
	public UndirectedGraphNode cloneGraphDFSII(UndirectedGraphNode node) {
        if (node == null) {
        	return null;
        }
        
        //map of original node and copied node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        stack.push(node);
        
        while (!stack.isEmpty()) {
        	UndirectedGraphNode cur = stack.pop();
        	
        	for (UndirectedGraphNode neighbor : cur.neighbors) {
        		if (!map.containsKey(neighbor)) {
        			stack.push(neighbor);
        			UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
        			map.put(neighbor, newNode);
        		}
        		
        		map.get(cur).neighbors.add(map.get(neighbor));
        	}
        }
        
        return head;
	}
}
