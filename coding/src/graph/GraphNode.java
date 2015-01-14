package graph;

public class GraphNode {
  int val;
  GraphNode next;
  GraphNode [] neightbors;
  boolean visited;
  
  GraphNode (int x) {
    this.val = x;
  }
  
  GraphNode (int x, GraphNode [] n) {
    this.val = x;
    this.neightbors = n;
  }
  
  public String toString() {
    return "value: " + this .val;
  }
}
