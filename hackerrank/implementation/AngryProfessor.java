package implementation;

import java.util.*;

public class AngryProfessor {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int count = 0;
			for(int j = 0; j < n; j++) {
				int x = in.nextInt();
				if (x <= 0) {
					count++;
				}
			}
			
			if (count < k) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		in.close();
	}

}
