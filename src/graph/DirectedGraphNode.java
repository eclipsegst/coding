package graph;
/*
 * Date: 01/14/2015 16:00
 * 
 * Directed Graph
 */
public class DirectedGraphNode {
  int val;
  DirectedGraphNode next;
  DirectedGraphNode [] neightbors;
  boolean visited;
  
  DirectedGraphNode (int x) {
    this.val = x;
  }
  
  DirectedGraphNode (int x, DirectedGraphNode [] n) {
    this.val = x;
    this.neightbors = n;
  }
  
  public String toString() {
    return "value: " + this .val;
  }
}
