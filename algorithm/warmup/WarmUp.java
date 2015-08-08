package warmup;

import java.util.Scanner;

public class WarmUp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b;
		a = in.nextInt();
		b = in.nextInt();
		
		int sum;
		sum = sumUp(a, b);
		System.out.println(sum);
	}
	
	static int sumUp(int a, int b) {
		return a + b;
	}
}
