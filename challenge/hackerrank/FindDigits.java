package hackerrank;

import java.util.Scanner;

public class FindDigits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int s = in.nextInt();
			String ss = String.valueOf(s);
			int count = 0;
			for(int j = 0; j < ss.length(); j++) {
				int x = Character.getNumericValue(ss.charAt(j));
				if (x == 0) {
					continue;
				} else {
					if (s % x == 0) {
						count++;
					}
				}
			}
			
			System.out.println(count);
			
			in.close();
		}
	}
}
