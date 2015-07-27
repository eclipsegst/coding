package implementqueueusingstacks;

import java.util.Stack;

/**
 * @author Zhaolong Zhong
 * Date: 1:50:12 PM Jul 8, 2015
 * 
 * Problem: Implement Queue using Stacks
 * Implement the following operations of a queue using stacks.
 * - push(x) -- Push element x to the back of queue.
 * - pop() -- Removes the element from in front of queue.
 * - peek() -- Get the front element.
 * - empty() -- Return whether the queue is empty.
 * 
 */
public class MyQueue {
	
	Stack<Integer> stack = new Stack<>();
	
	// Push element x to the back of queue.
	public void push(int x) {
		Stack<Integer> rev = new Stack<>();
		
		while(!stack.empty()) {
			rev.push(stack.pop());
		}
		
		rev.push(x);
		
		while(!rev.empty()) {
			stack.push(rev.pop());
		}
	}
	
	// Removes the element from in front of queue.
	public void pop() {
		stack.pop();
	}
	
	// Get the front element.
	public int peek() {
		return stack.peek();
	}
	
	// Return whether the queue is empty.
	public boolean empty() {
		return stack.empty();
	}
}
