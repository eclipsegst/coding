package graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
public class DFSUndirected {
  public static void main(String[] args) {
    UndirectedGraphNode n1 = new UndirectedGraphNode(1);
    UndirectedGraphNode n2 = new UndirectedGraphNode(2);
    UndirectedGraphNode n3 = new UndirectedGraphNode(3);
    UndirectedGraphNode n4 = new UndirectedGraphNode(4);
    UndirectedGraphNode n5 = new UndirectedGraphNode(5);
    UndirectedGraphNode n6 = new UndirectedGraphNode(6);
    
    n1.neighbors.add(n2);
    n1.neighbors.add(n3);
    n1.neighbors.add(n4);
    
    n2.neighbors.add(n5);
    n2.neighbors.add(n6);
    n3.neighbors.add(n6);
    
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    list = dfsUndirected(n1);
    
    System.out.println(list.toString());
   }
  public static ArrayList<Integer> dfsUndirected(UndirectedGraphNode root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    Stack<UndirectedGraphNode> s = new Stack<UndirectedGraphNode>();
    s.push(root);
    root.visited = true;
    list.add(root.label);
    while (!s.isEmpty()) {
      UndirectedGraphNode node = (UndirectedGraphNode)s.peek();
      if(!node.visited){
        list.add(node.label);
        node.visited = true;
        System.out.println(node.label);
      }
      
      boolean check =false;
      if (!node.neighbors.isEmpty()){
        for (UndirectedGraphNode temp : node.neighbors) {
          if(!temp.visited){
            s.push(temp); 
            check = true;
          }
        }
        if(!check){
          s.pop();
        }
      }else{
        s.pop();
      }
    }
    return list;
  }
}
