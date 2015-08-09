package warmup;

/**
 * Julius Caesar protected his confidential information from his enemies by encrypting it. 
 * Caesar rotated every letter in the string by a fixed number K. 
 * This made the string unreadable by the enemy. You are given a string S and the number K. 
 * Encrypt the string and print the encrypted string.
 * For example: 
 * If the string is middle-Outz and K=2, the encoded string is okffng-Qwvb. Note that only the letters are encrypted while symbols like - are untouched. 
 * 'm' becomes 'o' when letters are rotated twice, 
 * 'i' becomes 'k', 
 * '-' remains the same because only letters are encoded, 
 * 'z' becomes 'b' when rotated twice.
 * 
 * Constraints:
 * 1 <= N <= 100
 * 0 <= K <= 100
 * 
 * Sample Input:
 * 11
 * middle-Outz
 * 2
 * 
 * Sample Output:
 * okffng-Qwvb
 */
import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int c = in.nextInt();
		c = c%26;
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i < n; i++) {
			char t = s.charAt(i);
			if (t <= 'z' && t >= 'a') {
				if ((int)t + c <= (int)'z') {
					sb.append((char)((int)t + c));
				} else {
					sb.append((char)((int)t + c - (int)'z' + (int)'a' - 1));
				}
			} else if (t <= 'Z' && t >= 'A') {
				if ((int)t + c <= (int)'Z') {
					sb.append((char)((int)t + c));
				} else {
					sb.append((char)((int)t + c - (int)'Z' + (int)'A' - 1));
				}
			} else {
				sb.append(t);
			}
		}
		
		System.out.println(sb.toString());
	}

}
