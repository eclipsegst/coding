package hackerrank;

import java.util.*;

public class ServiceLane {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int t = in.nextInt();
		
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		
		Arrays.asList(nums).forEach(e -> System.out.print(e + " "));
		
		for (int j = 0; j < t; j++) {
			int s = in.nextInt();
			int e = in.nextInt();
			int min = 3;
			for (int k = s; k <= e; k++) {
				if (min > nums[k]) min = nums[k];
			}
			System.out.println(min);
		}
		
		in.close();
	}
}
