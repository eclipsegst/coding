package a;

import java.util.Stack;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {
	// handle push, pop, top
	Stack<Integer> stack = new Stack<Integer>();
	// handle getMin
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || minStack.peek() > x) {
			minStack.push(x);
		}
	}
	
	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		
		if (stack.pop().equals(minStack.peek())) {
			minStack.pop();
		}
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
}
