package test;

public class MainTest {
	public static void main(String[] args){
		System.out.println("Test Palindrome");
		System.out.println(isPalindrome(-1));
		System.out.println(isPalindrome(12));
		System.out.println(isPalindrome(12321));
	}
	
	public static boolean isPalindrome(int x){
		if (x < 0) return false;
		// get the first digit, x/tmp
		int tmp = 1;
		while (x/tmp > 10){
			tmp = tmp * 10;
		}
		// get the last digit, x%10
		int f = 0;
		int l = 0;
		while ( x > 0){
			f = x/tmp;
			l = x%10;
			if (f != l) return false;
			x = x%tmp;
			x = x/10;
			tmp = tmp/100;
		}
		return true;
	}
}
