package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 *               1
 *            /  |  \
 *           2   3   4
 *          / \ / \ /
 *         5   6   7
 *          \ /
 *           8
 * DFS: 14736825
 * BFS: 12345678
 * 
 * DEF Solution:
 * Push root to the stack
 * 
 * If stack is not empty, loop
 * get the head of the stack by peek the stack
 * 
 * add the label to the list
 * set visited to true
 * push all the neighbors to the stack
 * 
 * if all neighbors are visited then pop the stack
 * if neighbors empty pop stack
 * 
 * 
 * BFS Solution:
 * add root to the queue
 * 
 * if queue is not empty, loop
 * get the head of the stack by peek the queue
 * 
 * add all neighbors lable to the list
 * add all neighbors to the queue
 * 
 * if all neighbors are visited then poll the queue
 * if neighbors are empty, then poll the queue
 *           
 */
public class UndirectedGraphSearch {
  public static void main(String[] args) {
    UndirectedGraphNode n1 = new UndirectedGraphNode(1);
    UndirectedGraphNode n2 = new UndirectedGraphNode(2);
    UndirectedGraphNode n3 = new UndirectedGraphNode(3);
    UndirectedGraphNode n4 = new UndirectedGraphNode(4);
    UndirectedGraphNode n5 = new UndirectedGraphNode(5);
    UndirectedGraphNode n6 = new UndirectedGraphNode(6);
    UndirectedGraphNode n7 = new UndirectedGraphNode(7);
    UndirectedGraphNode n8 = new UndirectedGraphNode(8);
    n1.neighbors.add(n2);
    n1.neighbors.add(n3);
    n1.neighbors.add(n4);
    
    n2.neighbors.add(n5);
    n2.neighbors.add(n6);
    n3.neighbors.add(n6);
    n3.neighbors.add(n7);
    n4.neighbors.add(n7);
    n5.neighbors.add(n8);
    n6.neighbors.add(n8);
    
//    ArrayList<Integer> listdfs = new ArrayList<Integer>();
//    listdfs = dfsUndirected(n1);
//    System.out.println(listdfs.toString());
    
    ArrayList<Integer> listbfs = new ArrayList<Integer>();
    listbfs = bfsUndirected(n1);
    System.out.println(listbfs.toString());
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
  
  public static ArrayList<Integer> bfsUndirected(UndirectedGraphNode root) {
    if (root == null) {
      return null;
    }
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(root.label);
    root.visited = true;
    Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
    q.add(root);
    
    while(!q.isEmpty()){
      boolean checker = false;
      UndirectedGraphNode node = (UndirectedGraphNode)q.peek();
      
      if(!node.neighbors.isEmpty()) {
        for(UndirectedGraphNode temp : node.neighbors){
          if (!temp.visited) {
            list.add(temp.label);
            temp.visited = true;
            q.add(temp);
            checker = true;
          }
        }
        if (!checker) {
          q.poll();
        }
      }else{
        q.poll();
      }
    }
    
    return list;
  }
}
