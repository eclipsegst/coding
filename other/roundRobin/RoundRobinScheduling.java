package roundRobin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhaolong Zhong Nov 18, 2015
 */

class Process {
	int arrivalTime;
	int executeTime;
	Process(int arrivalTime, int executeTime) {
		this.arrivalTime = arrivalTime;
		this.executeTime = executeTime;
	}
}

public class RoundRobinScheduling {
	public static float waitTime(int[] arriveTimes, int[] executeTimes, int q) {
		if (arriveTimes == null || executeTimes == null || arriveTimes.length != executeTimes.length)
			return 0;
		Queue<Process> queue = new LinkedList<Process>();
		int curTime = 0, waitTime = 0;
		int index = 0;
		int length = arriveTimes.length;
		while (!queue.isEmpty() || index < length) {
			if (!queue.isEmpty()) {
				Process cur = queue.poll();
				waitTime += curTime - cur.arrivalTime;
				curTime += Math.min(cur.executeTime, q);
				for (; index < length && arriveTimes[index] <= curTime; index++)
					queue.offer(new Process(arriveTimes[index], executeTimes[index]));
				if (cur.executeTime > q)
					queue.offer(new Process(curTime, cur.executeTime - q));
			} else {
				queue.offer(new Process(arriveTimes[index], executeTimes[index]));
				curTime = arriveTimes[index++];
			}
		}
		
		return (float) waitTime / length;
	}
	
	public static void main(String[] args) {
		int [] arriveTimes = new int[] {0, 1, 4};
		int [] executeTimes = new int[] {5, 2, 3};
		int q = 3;
		System.out.println("" + waitTime(arriveTimes, executeTimes, q));
	}
}


