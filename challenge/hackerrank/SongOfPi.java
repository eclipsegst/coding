package hackerrank;

import java.util.*;

public class SongOfPi {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int t = Integer.parseInt(in.nextLine());
		String pi = "31415926535897932384626433833"; 
		
		for (int i = 0; i < t; i++) {
			String s = in.nextLine();
			String[] strs = s.split("\\s+");
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < strs.length; j++) {
				sb.append(strs[j].length());
			}
			String p = sb.toString();
			if (pi.substring(0, p.length()).equals(p)) {
				System.out.println("It's a pi song.");
			} else {
				System.out.println("It's not a pi song.");
			}
		}
		
		in.close();
	}
}
