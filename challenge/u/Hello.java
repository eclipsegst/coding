package u;

import java.util.ArrayDeque;

/**
 * @author Zhaolong Zhong Sep 27, 2016
 */

public class Hello {
	private ArrayDeque<Long> deque;
	
	public Hello() {
		deque = new ArrayDeque<Long>();
	}
	
	public void sayHello() {
		long currentTime = System.currentTimeMillis();
		
		if (deque.size() < 3) {
			System.out.println("hello");
			deque.addLast(currentTime);
			return;
		}
		
		long firstTime = deque.getFirst();
		
		if (currentTime - firstTime < 1000) {
			System.out.println("error");
		} else {
			System.out.println("hello");
		}
		
		deque.removeFirst();
		deque.addLast(currentTime);
	}
	
	public static void main(String[] args) {
		int[] times = new int[]{100, 200, 400, 50, 550};
		
		Hello hello = new Hello();
		hello.sayHello();
		
		for (int i : times) {
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			hello.sayHello();
		}
	}
}
