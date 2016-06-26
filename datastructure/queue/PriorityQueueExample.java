package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zhaolong Zhong Jun 25, 2016
 * 
 * PriorityQueue
 * 
 * An unbounded priority queue based on a priority heap.
 * 
 * Note that this implementation is not synchronized, Instead, use the thread-safe PriorityBlockingQueue;
 * 
 * Implementation note: this implementation provides O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add); 
 * linear time for the remove(Object) and contains(Object) methods; 
 * and constant time for the retrieval methods (peek, element, and size).
 * 
 */
public class PriorityQueueExample {
	public static void main(String[] args) {
		int[] nums = {2, 1, 4, 5, 7, 9, 6, 8, 3, 0};
		
		int k = 6;
		
		PriorityQueue<Integer> queueOriginal = new PriorityQueue<Integer>();
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b; // default natural order
			}
		});
		
		for (int n : nums) {
			queueOriginal.offer(n);
			queue.offer(n);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		
		while(!queueOriginal.isEmpty()) {
			System.out.print(queueOriginal.poll() + " ");
		}
		
		System.out.println();
		
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}
}
