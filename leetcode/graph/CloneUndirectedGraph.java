package graph;

import java.util.HashMap;
/**
 * 
 * @author zz
 * Date: 01/15/2014 02:00
 * 
 * Problem: 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * Solution: 
 * DFS traverse all nodes, meanwhile use HashMap to record the node which has been cloned. 
 * Use label as key and the new created node as value.
 *
 */

/* Definition of undirected graph
 * class UndirectedGraphNode{
 *   int label;
 *   ArrayList<UndirectedGraphNode> neighbors;
 *   UndirectedGraphNode(int x) {
 *     label = x;
 *     neighbors = new ArrayList<UndirectedGraphNode>();
 *   }
 * }
*/
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