package warmup;

import java.lang.Math;
import java.util.Scanner;

public class WarmUpFour {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int diff = 0;
		int leftDiff = 0;
		int rightDiff = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int t = in.nextInt();
				// first diagonal
				if (i == j) {
					leftDiff += t;
				}
				// second diagonal
				if (i + j == n - 1) {
					rightDiff += t;
				}
			}
		}
		diff = Math.abs(leftDiff - rightDiff);
		System.out.println(diff);

	}

}
