package g;

import java.util.Stack;

/**
 * @author Zhaolong Zhong Dec 21, 2015
 * 
 * Problem: Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * - push(x) -- Push element x onto stack.
 * - pop() -- Removes the element on top of the stack.
 * - top() -- Get the top element.
 * - getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || minStack.peek() >= x)
			minStack.push(x);
	}
	
	public void pop() {
		if (stack.isEmpty()) return;
		if (stack.pop().equals(minStack.peek()))
			minStack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack solution = new MinStack();
		int[] nums = new int[] {4, 1, 2, 5, 3};
		
		for (int n : nums) {
			solution.push(n);
			System.out.print(solution.getMin() + " ");
		}
		
		System.out.println();
		System.out.println("top: " + solution.top());
		System.out.println("min: " + solution.getMin());
		solution.pop();
		solution.pop();
		System.out.println("top: " + solution.top());
		System.out.println("min: " + solution.getMin());
	}
}
