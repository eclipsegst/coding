package warmup;

import java.util.Scanner;

public class WarmUpFive {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		double pos = 0.0, neg = 0.0, zero = 0.0;
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			if (t > 0) {
				pos++;
			} else if (t < 0) {
				neg++;
			} else {
				zero++;
			}
		}
		
		System.out.println(pos/n + "\n" + neg/n + "\n" + zero/n);
	}

}
