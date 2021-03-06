package challenge;
/*
 * Date: 2015-01-12 00:04:31
 * 
 * Problem:
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeTwo {
	public static void main(String[] args){
		System.out.println("Test Palindrome");
		System.out.println(isPalindrome(-1));
		System.out.println(isPalindrome(12));
		System.out.println(isPalindrome(12321));
		
		int n = 12345;
		int div = 1;
		while(n / div >= 10){
			div *= 10;
		}
		System.out.println(123/10);
		System.out.println(div);
		System.out.println(12345/10000);
		System.out.println(12345%10);
		System.out.println(12345/10);
	}
	
	public static boolean isPalindrome(int x){
		if(x < 0) return false;
		int div = 1;
		while(x / div >= 10){
			div *= 10;
		}
		
		while(x != 0){
			int l = x / div;
			int r = x % 10;
			if(l != r) return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}
	
	public static boolean palindrome(int x) {
	  if (x < 0) return false;
	  if (x == 0) return true;
	  int size = (int) Math.log10(x);
	  int mid = size / 2;
	  for (int i=0; i<=mid ; i++) {
	    int p = (int) (x / Math.pow(10, i)) % 10;
	    int q = (int) (x / Math.pow(10,  size - i)) % 10;
	    if (p != q) return false;
	  }
	  return true;
	}
}
