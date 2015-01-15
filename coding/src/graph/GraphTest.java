package graph;

public class GraphTest {
  public static void main(String[] args) {
    DirectedGraphNode n1 = new DirectedGraphNode(1);
    DirectedGraphNode n2 = new DirectedGraphNode(2);
    DirectedGraphNode n3 = new DirectedGraphNode(3);
    DirectedGraphNode n4 = new DirectedGraphNode(4);
    DirectedGraphNode n5 = new DirectedGraphNode(5);
    
    n1.neightbors = new DirectedGraphNode[]{n2,n3,n5};
    n2.neightbors = new DirectedGraphNode[]{n1,n4};
    n3.neightbors = new DirectedGraphNode[]{n1,n4,n5};
    n4.neightbors = new DirectedGraphNode[]{n2,n3,n4};
    n5.neightbors = new DirectedGraphNode[]{n1,n3,n4};
    
    breadthFirstSearch(n1, 5);
  }
  
  public static void breadthFirstSearch(DirectedGraphNode root, int x) {
    if (root.val == x) {
      System.out.println("find in root");
    }
    
    Queue queue = new Queue();
    root.visited = true;
    queue.enqueue(root);
    
    while (queue.first != null) {
      DirectedGraphNode c = (DirectedGraphNode) queue.dequeue();
      for(DirectedGraphNode n : c.neightbors) {
        if (!n.visited) {
          System.out.println(n + " ");
          n.visited = true;
          if (n.val == x){
            System.out.println("Find " + n);
            queue.enqueue(n);
          }
        }
      }
    }
  }
}
