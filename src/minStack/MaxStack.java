package minStack;

import java.util.ArrayList;

public class MaxStack {
	ArrayList<Integer> stack = new ArrayList<Integer>();
	ArrayList<Integer> maxStack = new ArrayList<Integer>();
	
	void push(int x){
		stack.add(x);
		if(maxStack.isEmpty() || maxStack.get(maxStack.size()-1) <= x){
			maxStack.add(x);
		}
	}
	
	int top(){
		if(!stack.isEmpty()){
			return stack.get(stack.size()-1);
		}
		return 0;
	}
	
	void pop(){
		if(stack.isEmpty()){
			return;
		}
		
		int tmp = stack.remove(stack.size()-1);
		if(!maxStack.isEmpty() && maxStack.get(maxStack.size()-1)==tmp){
			maxStack.remove(maxStack.size()-1);
		}
	}
	
	int getMax(){
		if(!maxStack.isEmpty()){
			return maxStack.get(maxStack.size()-1);
		}
		return 0;
	}
}
