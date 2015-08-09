package warmup;

import java.util.Scanner;

/**
 * @author Zhaolong Zhong
 * Time Conversion
 * Convert time in AM/PM format to 24 hour format.
 * Input example: Midnight is 12:00:00AM or 00:00:00 and noon is 12:00:00PM
 * Output is : 00:00:00, 12:00:00 
 *
 */
public class TimeConversion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int hours = Integer.parseInt(s.substring(0,2));
		if (s.contains("PM")){
			if (hours == 12) {
				System.out.println(s.substring(0,8));
			} else {
				int h = hours + 12;
				System.out.println(h + s.substring(2, 8));
			}
		} else {
			if (hours == 12) {
				System.out.println("00" + s.substring(2, 8));
			} else {
				System.out.println(s.substring(0,8));
			}
		}
		
	}

}
