package queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
		
		PriorityQueue<Airport> priorityQueue = new PriorityQueue<Airport>(new Comparator<Airport>() {
			@Override
			public int compare(Airport a1, Airport a2) {
				return a1.distance <= a2.distance ? 1 : -1;
			}
		});
		
		for (int i = 0; i < 50; i++) {
			Airport airport = new Airport(i, i);
			priorityQueue.add(airport);
			if (priorityQueue.size() > 20) priorityQueue.poll();
		}
		
		Iterator<Airport> iterator = priorityQueue.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Airport airport = (Airport)iterator.next();
			System.out.println("i = " + i + ", " + "airport id: " + airport.id + ", distance: " + airport.distance);
			i++;
		}
	}
	
	private static void printQueue(Queue<Integer> queue) {
		Iterator<Integer> iterator = queue.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}

class Airport {
	int id;
	double distance;
	Airport(int id, double distance) {
		this.id = id;
		this.distance = distance;
	}
}
