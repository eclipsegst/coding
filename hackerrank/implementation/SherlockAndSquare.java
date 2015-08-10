package implementation;

import java.util.*;

public class SherlockAndSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			long s = in.nextLong();
			long e = in.nextLong();
			long count = 0;
			
			
			count = (long)Math.floor(Math.sqrt(e)) - (long)Math.ceil(Math.sqrt(s)) + 1;
			if (count > 0) {
				System.out.println(count);
			} else {
				System.out.println(0);
			}
		}
		
		in.close();
	}
}
