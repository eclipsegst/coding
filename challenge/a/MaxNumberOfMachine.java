package a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Zhaolong Zhong Jun 19, 2016
 * 
 * Given a list of jobs, return the maximum number of machine that we need to run the jobs without delay.
 * For example,
 * given three jobs: (1,3], (2,5], (3,7), the first element of each job is start time and the second is end time.
 * return 2
 * 
 * Because we need one machine to run the first job, and another one to run the second one since the first job end at time 3, 
 * but we need to run the second job at 2. The machine that has done the first job can run the third job 
 * since when the third job come, the first job is completed. So we need two machines for the three jobs.
 * 
 * Hints:
 * We can build minHeap based on end time of each job. 
 * Pop up the first element if its end time is less than the start time of new job.
 * Keep tracking of the maximum of heap size.
 */

class Task {
	int start;
	int end;
	
	public Task(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class MaxNumberOfMachine {
	public int maxNumberOfMachine(List<Task> tasks) {
		if (tasks == null || tasks.size() == 0) {
			return 0;
		}
		
		PriorityQueue<Task> queue = new PriorityQueue<Task>(tasks.size(), new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				return t1.end - t2.end;
			}
		});
		
		int result = 0;
		
		for (Task task : tasks) {
			if (queue.isEmpty()) {
				queue.add(task);
			} else {
				if (queue.peek().end <= task.start) {
					queue.poll();
					
				}
				
				queue.add(task);
			}
			
			if (result < queue.size()) {
				result = queue.size();
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MaxNumberOfMachine solution = new MaxNumberOfMachine();
		
		Task t1 = new Task(1, 3);
		Task t2 = new Task(2, 5);
		Task t3 = new Task(3, 7);
		Task t4 = new Task(4, 9);
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(t1);
		tasks.add(t2);
		tasks.add(t3);
		tasks.add(t4);
		
		System.out.println(solution.maxNumberOfMachine(tasks));
	}
}
