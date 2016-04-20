package challenge;

/**
 * @author Zhaolong Zhong Apr 6, 2016
 * Problem:
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up:
 * Could you do it without using any loop / recursion?
 * 
 * Reference:
 * https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
 */
public class PowerOfThree {
	
	//Iterative solution
	public boolean isPowerOfThreeLoop(int n) {
		if (n > 1) {
			while (n % 3 == 0) {	
				n /= 3;
			}
		}
		
		return n==1;
	}
	
	//Iterate solution
	public boolean isPowerOfThreeRecursive(int n) {		
		return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThreeRecursive(n / 3)));
	}
	
	//maxPowerOfThree = 1162261467, 1162261467 is 3^19,  3^20 is bigger than int  
    public boolean isPowerOfThree(int n) {
    	return (n >0 && 1162261467 % n == 0);
    }
	
}
