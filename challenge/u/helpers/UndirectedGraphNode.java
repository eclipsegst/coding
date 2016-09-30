package u.helpers;

import java.util.ArrayList;

/**
 * @author Zhaolong Zhong Sep 29, 2016
 */
public class UndirectedGraphNode {
	public int label;
	public ArrayList<UndirectedGraphNode> neighbors;
	
	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
