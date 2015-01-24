package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * 
 * @author zz
 * Date: 01/15/2014 02:30
 *
 * Problem:
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * Solution:
 * A queue is used to do breadth first traversal.
 * A map is used to store the visited nodes. It's like a checker and it is the map between original node and copied node.
 * 
 */

public class CloneUndirectedGraphBFS {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
    if (node == null) {
      return null;
    }
    
    LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    
    UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
    queue.add(node);
    map.put(node, newHead);
    
    while (!queue.isEmpty()) {
      UndirectedGraphNode curr = queue.pop();
      ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors;
      
      for (UndirectedGraphNode neighbor : currNeighbors) {
        if (!map.containsKey(neighbor)) {
          UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
          map.put(neighbor, copy);
          map.get(curr).neighbors.add(copy);
          queue.add(neighbor);
        }else{
          map.get(curr).neighbors.add(map.get(neighbor));
        }
      }
    }
    return newHead;
  }
}
