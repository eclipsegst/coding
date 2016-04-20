package hackerrank;

import java.util.*;

public class SherlockAndTheBeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int x = -1;
			for (int j = n; j >= 0; j = j - 5) {
				if (j % 3 == 0) {
					x = j;
					break;
				} 
			}
			
			if (x == -1) {
				System.out.println("-1");
			} else {
				StringBuffer sb = new StringBuffer();
				for (int p = 0; p < x; p++) {
					sb.append("5");
				}
				for (int q = 0; q < n - x; q++) {
					sb.append("3");
				}
				
				System.out.println(sb.toString());
			}
		}
		
		in.close();
	}
}
