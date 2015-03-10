/**
 * Author: Zhaolong Zhong
 * Date  : Mar 9, 2015 10:40:45 PM
 * Problem: Reverse bits of a given 32 bits unsigned integer.
 * For example, For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 */
package reverseBits;

public class ReverseBits {
  public static int reverseBits(int n) {
    n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;
    n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;
    n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;
    n = (n << 24) | ((n & 0xff00) << 8) | ((n >>> 8) & 0xff00) | (n >>> 24);
    return n;
  }
  public static void main(String[] args) {
//    int c = 0x55555555; /* 0110 0110 0110 0110 0110 0110 0110 0110 = 1431655765 */
//    int d = 0x33333333; /* 0011 0011 0011 0011 0011 0011 0011 0011 = 858993459 */
//    int e = 0x0f0f0f0f; /* 0000 1111 0000 1111 0000 1111 0000 1111 = 252645135 */
    
    int n = 43261596;
    System.out.println(reverseBits(n));
  }
}
