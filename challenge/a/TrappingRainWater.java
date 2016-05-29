package a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * @author Zhaolong Zhong May 28, 2016
 */
public class TrappingRainWater {
	static class Peak {
		int i;
		int height;
		
		Peak(int i, int height) {
			this.i = i;
			this.height = height;
		}
	}
	
	public int trapSlow(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		
		// find all peaks
		List<Peak> peaks = new ArrayList<Peak>();
		
		if (height[0] > height[1]) {
			peaks.add(new Peak(0, height[0]));
		}
		
		for (int i = 1; i < height.length - 1; i++) {
			if (height[i] >= height[i - 1] && height[i] >= height[i + 1]) {
				peaks.add(new Peak(i, height[i]));
			}
		}
		
		if (height[height.length - 1] >= height [height.length - 2]) {
			peaks.add(new Peak(height.length - 1, height[height.length - 1]));
		}
		
		if (peaks.size() == 0) {
			return 0;
		}
		
		// remove peaks which are between and lower than two other peaks
		PriorityQueue<Peak> peakQueue = new PriorityQueue<Peak>(peaks.size(), new Comparator<Peak>() {
			@Override
			public int compare(Peak p1, Peak p2) {
				return p1.height - p2.height;
			}
		});
		
		for (Peak peak : peaks) {
			peakQueue.offer(peak);
		}
		
		Peak pre = peakQueue.poll();
		while (peakQueue.peek() != null) {
			Peak cur = peakQueue.poll();
			int i = 0, j = 0;
			if (pre.i < cur.i) {
				i = pre.i;
				j = cur.i;
			} else {
				i = cur.i;
				j = pre.i;
			}
			
			Iterator<Peak> iterator = peaks.iterator();
			while (iterator.hasNext()) {
				Peak peak = iterator.next();
				if (peak.i > i && peak.i < j && peak.height < pre.height && peak.height < cur.height) {
					iterator.remove();
				}
			}
			
			pre = cur;
		}
		
		// calculate water among peaks
		int result = 0;
		for (int j = 0; j < peaks.size() - 1; j++) {
			Peak prev = peaks.get(j);
			Peak cur = peaks.get(j + 1);
			
			int min = prev.height > cur.height ? cur.height : prev.height;
			int sum = 0;
			
			for (int k = prev.i; k <= cur.i; k++) {
				if (height[k] <= min) {
					sum += min - height[k];
				}
			}
			
			result += sum;
		}
		
		return result;
	}
	
	/**
	 * O(n) time, O(1) space
	 */
	public int trap(int[] height) {
		int water = 0;
		if (height.length < 3) {
			return water;
		}
		
		// find max height and its position
		int maxHeight = 0;
		int maxHeightPos = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > maxHeight) {
				maxHeight = height[i];
				maxHeightPos = i;
			}
		}
		
		// calculate water before max height
		int preHeight = height[0];
		for (int i = 1; i < maxHeightPos; i++) {
			if (height[i] < preHeight) {
				water += preHeight - height[i];
			} else {
				preHeight = height[i];
			}
		}
		
		// calculate water after max height
		preHeight = height[height.length - 1];
		for (int i = height.length - 1; i > maxHeightPos; i--) {
			if (height[i] < preHeight) {
				water += preHeight - height[i];
			} else {
				preHeight = height[i];
			}
		}
		
		return water;
	}
	
	public static void main(String[] args) {
		TrappingRainWater solution = new TrappingRainWater();
		
//		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1}; // 6
//		int[] heights = {5,2,1,2,1,5}; //14
		int[] heights = {5,5,1,7,1,1,5,2,7,6}; //23
		System.out.println(solution.trapSlow(heights));
		System.out.println(solution.trap(heights));
	}
}
