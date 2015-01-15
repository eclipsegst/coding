package graph;

import java.util.ArrayList;
import java.util.HashMap;

/* Definition of undirected graph */
class UndirectedGraphNode{
  int label;
  ArrayList<UndirectedGraphNode> neighbors;
  UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<UndirectedGraphNode>();
  }
}

public class CloneUndirectedGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    
    HashMap<Integer, UndirectedGraphNode> checker = new HashMap<Integer, UndirectedGraphNode>();
    return clone(node, checker);
  }
  
  private UndirectedGraphNode clone (UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> checker) {
    if (checker.containsKey(node.label)) {
      return checker.get(node.label);
    }
    
    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    checker.put(newNode.label, newNode);
    for (UndirectedGraphNode tempNode : node.neighbors) {
      newNode.neighbors.add(clone(tempNode,checker));
    }
    
    return newNode;
  }
}