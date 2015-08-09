package warmup;
/**
 * The Head Librarian at a library wants you to make a program 
 * that calculates the fine for returning the book after the return date. 
 * You are given the actual and the expected return dates. Calculate the fine as follows:
 * - If the book is returned on or before the expected return date, no fine will be charged, in other words fine is 0.
 * - If the book is returned in the same month as the expected return date, Fine = 15 Hackos ¡Á Number of late days
 * - If the book is not returned in the same month but in the same year as the expected return date, Fine = 500 Hackos ¡Á Number of late months
 * - If the book is not returned in the same year, the fine is fixed at 10000 Hackos.
 * 
 * For example,
 * 9 6 2015
 * 6 6 2015
 * 
 * Output: 45
 */

import java.util.Scanner;

public class LibraryFine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int [] nums = new int[6];
		for(int i = 0; i < 6; i++) {
			nums[i] = in.nextInt();
		}

        // year
		if (nums[2] > nums[5]) {
			System.out.println("10000");
		} else if (nums[2] == nums[5]){
            // month
			if (nums[1] > nums[4]) {
				int m = nums[1] - nums[4];
                System.out.println(m * 500);
			} else if (nums[1] == nums[4]){
                // day
                if (nums[0] > nums[3]) {
                    System.out.println((nums[0] - nums[3]) * 15);
                } else {
                    System.out.println(0);
                }
				
			} else {
                System.out.println(0);
            }
		} else {
            System.out.println(0);
        }
    }
}
