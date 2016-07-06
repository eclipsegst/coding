package challenge;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Jul 6, 2016
 * 
 * Super Ugly Number
 * 
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * 
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/30999
 * https://discuss.leetcode.com/topic/34841
 */
public class SuperUglyNumber {
	// O(kN)
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] result = new int[n];
        int[] index = new int[primes.length];
        
        result[0] = 1;
        
        for (int i = 1; i < n; i++) {
        	// find next
        	result[i] = Integer.MAX_VALUE;
        	for (int j = 0; j < primes.length; j++) {
        		result[i] = Math.min(result[i], primes[j] * result[index[j]]);
        	}
        	
        	// skip duplicate
        	for (int j = 0; j < primes.length; j++) {
        		while (primes[j] * result[index[j]] <= result[i]) {
        			index[j]++;
        		}
        	}
        }
        
        return result[n - 1];
    }
    
    // O(kN)
    public int nthSuperUglyNumberTradeSpace(int n, int[] primes) {
    	int[] result = new int[n];
    	int[] index = new int[primes.length];
    	int[] value = new int[primes.length];
    	Arrays.fill(value, 1);
    	
    	int next = 1;
    	for (int i = 0; i < n; i++) {
    		result[i] = next;
    		next = Integer.MAX_VALUE;
    		
    		for (int j = 0; j < primes.length; j++) {
    			if (value[j] == result[i]) {
    				value[j] = result[index[j]++] * primes[j];
    			}
    			
    			next = Math.min(next, value[j]);
    		}
    	}
    	
    	return result[n - 1];
    }
}
