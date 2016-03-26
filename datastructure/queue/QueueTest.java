package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhaolong Zhong Dec 12, 2015
 */
public class QueueTest {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		// add, remove, element will throws exception
		// offer, poll, peek will return value
		
		System.out.println("examine");
		System.out.println(queue.element());
		printQueue(queue);
		System.out.println(queue.peek());
		printQueue(queue);
		
		System.out.println("remove");
		System.out.println(queue.remove());
		printQueue(queue);
		System.out.println(queue.poll());
		printQueue(queue);
		
		System.out.println("insert");
		System.out.println(queue.add(1));
		printQueue(queue);
		System.out.println(queue.offer(0));
		printQueue(queue);
	}
	
	private static void printQueue(Queue<Integer> queue) {
		Iterator<Integer> iterator = queue.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}