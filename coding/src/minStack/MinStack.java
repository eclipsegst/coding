package minStack;

import java.util.ArrayList;

/*
 * Problem:
 * Design a stack that supports push, pop, top and retrieving the minimum element in constant time
 * push(x) -- push element x onto stack
 * pop() -- remove the element on top of the stack
 * top() -- get the top element
 * getMin() -- retrieve the minimum element in the stack.
 */

public class MinStack {
	ArrayList<Integer> stack = new ArrayList<Integer>();
	ArrayList<Integer> minStack = new ArrayList<Integer>();
	
	void push(int x){
		stack.add(x);
		if(minStack.isEmpty() || minStack.get(minStack.size()-1)>=x){
			minStack.add(x);
		}
	}
	
	void pop(){
		if(stack.isEmpty()){
			return;
		}
		int tmp = stack.remove(stack.size()-1);
		if(!minStack.isEmpty() && tmp == minStack.get(minStack.size()-1)){
			minStack.remove(minStack.size()-1);
		}
	}
	
	int top(){
		if(!stack.isEmpty()){
			return stack.get(stack.size()-1);
		}
		return 0;
	}
	
	int getMin(){
		if(!minStack.isEmpty()){
			return minStack.get(minStack.size()-1);
		}
		return 0;
	}
}
