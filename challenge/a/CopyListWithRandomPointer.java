package a;

import java.util.HashMap;
import java.util.Map;

import helpers.RandomListNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
	private Map<Integer, RandomListNode> cache = new HashMap<Integer, RandomListNode>();
	
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
			return null;
		}
		
		if (cache.containsKey(head.label)) {
			return cache.get(head.label);
		}
		
		RandomListNode newNode = new RandomListNode(head.label);
		cache.put(head.label, newNode);
		newNode.next = copyRandomList(head.next);
		newNode.random = copyRandomList(head.random);
		
		return newNode;
    }
}
