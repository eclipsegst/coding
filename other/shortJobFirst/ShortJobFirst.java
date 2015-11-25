package shortJobFirst;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 */
class Process {
	int arrivalTime;
	int executeTime;
	Process(int arrivalTime, int executeTime) {
		this.arrivalTime = arrivalTime;
		this.executeTime = executeTime;
	}
}

public class ShortJobFirst {
	public static float shortJobFirst(int[] tasks, int[] dur) {
		if (tasks == null || dur == null || tasks.length != dur.length) return 0;
		
		PriorityQueue<Process> queue = new PriorityQueue<Process>(new Comparator<Process>() {
			@Override
			public int compare(Process p1, Process p2) {
				if (p1.executeTime == p2.executeTime) {
					return p1.arrivalTime - p2.arrivalTime;
				}
				return p1.executeTime - p2.executeTime;
			}
		});
		
		int length = tasks.length;
		int waitTime = 0;
		int currTime = 0;
		int i = 0;
		while (!queue.isEmpty() || i < length) {
			if (!queue.isEmpty()) {
				Process cur = queue.poll();
				waitTime += currTime - cur.arrivalTime;
				currTime += cur.executeTime;
				while (i < length && currTime >= tasks[i]) {
					queue.offer(new Process(tasks[i], dur[i]));
					i++;
				}
			} else {
				queue.offer(new Process(tasks[i], dur[i]));
				currTime = tasks[i];
				i++;
			}
		}
		
		return (float) waitTime /length;
	}
	
	public static void main(String[] args) {
		int[] tasks = new int[] {0, 2, 4, 5};
		int[] dur = new int[] {7, 4, 1, 4};
		System.out.println(shortJobFirst(tasks, dur)); // 4.0
		
		int[] tasks2 = new int[] {0, 1, 3, 9};
		int[] dur2 = new int[] {2, 1, 7, 5};
		System.out.println(shortJobFirst(tasks2, dur2)); // 0.5
	}
}
