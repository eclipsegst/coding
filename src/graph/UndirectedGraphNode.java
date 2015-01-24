package graph;

import java.util.ArrayList;

public class UndirectedGraphNode {
  int label;
  ArrayList<UndirectedGraphNode> neighbors;
  boolean visited;
  UndirectedGraphNode(int x){
    label = x;
    neighbors = new ArrayList<UndirectedGraphNode>();
  }
}