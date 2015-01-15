package graph;

public class Queue {
  DirectedGraphNode first, last;
  public void enqueue (DirectedGraphNode n) {
    if (first == null) {
      first = n;
      last = first;
    }else{
      last.next = n;
      last = n;
    }
  }
  
  public DirectedGraphNode dequeue() {
    if (first == null) {
      return null;
    }else{
      DirectedGraphNode temp = new DirectedGraphNode(first.val, first.neightbors);
      first = first.next;
      return temp;
    }
  }
}
