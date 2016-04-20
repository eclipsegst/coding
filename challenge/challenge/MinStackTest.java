package challenge;

public class MinStackTest {
	public static void main(String[] args){
		System.out.println("Test MinStack");
		MinStack stack = new MinStack();
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stack.push(5);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.top());
		
		System.out.println("Test MaxStack");
		MaxStack maxStack = new MaxStack();
		maxStack.push(2);
		maxStack.push(1);
		maxStack.push(5);
		maxStack.push(3);
		System.out.println(maxStack.top());
		System.out.println(maxStack.getMax());
		maxStack.pop();
		maxStack.pop();
		System.out.println(maxStack.getMax());
	}
}
