package hackerrank;

import java.util.*;
public class UtopianTree {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			int h = 1;
			int n = in.nextInt();
			for (int j = 1; j <= n; j++) {
				if ((j % 2) == 1) {
					h = h * 2;
				} else {
					h = h + 1;
				}
			}
			
			System.out.println(h);
		}
		
		in.close();
	}
}
