package implementation;

import java.util.*;

public class CutSticks {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		
		in.close();
		
		boolean stop = false;
		while (!stop) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if(nums[j] > 0) {
					count++;
				}
			}
			
			if (count == 0) {
				break;
			}
			
			System.out.println(count);
			
			int min = findMin(nums);
			for (int j = 0; j < n; j++) {
				nums[j] = nums[j] - min;
			}
		}
		
	}
	
	static int findMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && min > nums[i]) {
				min = nums[i];
			}
		}
		
		return min;
	}
}
