package challenge;

import java.util.ArrayDeque;

/**
 * @author Zhaolong Zhong Jun 30, 2016
 * 
 * Moving Average from Data Stream
 * 
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {
	private ArrayDeque<Integer> queue;
	private int size;
	private double sum;
	
	/** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new ArrayDeque<Integer>();
        this.size = size;
        this.sum = 0.0;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > size) {
        	sum -= queue.removeFirst();
        }
        
    	return sum / (size > queue.size() ? queue.size() : size);
    }
    
    public static void main(String[] args) {
    	MovingAverage m = new MovingAverage(3);
    	System.out.println(m.next(1));
    	System.out.println(m.next(10));
    	System.out.println(m.next(3));
    	System.out.println(m.next(5));
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */