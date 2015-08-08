package warmup;

import java.util.Scanner;

public class WarmUpTwo {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int t;
		int sum;
		int a, b;
		t = in.nextInt();
		for (int i = 0; i < t; i++) {
			a = in.nextInt();
			b = in.nextInt();
			sum = sumUp(a, b);
			System.out.println(sum);
		}
	}
	
	static int sumUp(int a, int b) {
		return a + b;
	}

}
