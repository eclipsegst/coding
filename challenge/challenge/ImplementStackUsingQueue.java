package challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhaolong Zhong
 * Date: 2:38:35 PM Jul 8, 2015
 * 
 * Problem: Implement Stack using Queues
 * 
 */
public class ImplementStackUsingQueue {

	Queue<Integer> queue = new LinkedList<>();
	    
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> tmp = new LinkedList<>();
        
        tmp.add(x);
        
        while(!queue.isEmpty()) {
            tmp.add(queue.remove());
        }
        
        queue = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
