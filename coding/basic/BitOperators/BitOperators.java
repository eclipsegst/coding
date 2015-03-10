/**
 * Author: Zhaolong Zhong
 * Date  : Mar 9, 2015 8:17:29 PM
 * Bit Operators
 */
package BitOperators;

public class BitOperators {
  public static void main(String[] args) {
    int a = 0x23;   /* 00100011 = 35 */
    int b = 0x36;   /* 00110110 = 54 */
    System.out.println(a);  // 35
    System.out.println(b);  // 54
    System.out.println(~a); //-36
    System.out.println(~b); //-55
    
    int c = 0x55555555; /* 0110 0110 0110 0110 0110 0110 0110 0110 = 1431655765 */
    int d = 0x33333333; /* 0011 0011 0011 0011 0011 0011 0011 0011 = 858993459 */
    int e = 0x0f0f0f0f; /* 0000 1111 0000 1111 0000 1111 0000 1111 = 252645135 */
    System.out.println(Integer.toBinaryString(c));
    System.out.println(Integer.toBinaryString(d));
    System.out.println(Integer.toBinaryString(e));
    
    int f = 0x0000000F; /* equals 0xF = 0000 0000 0000 0000 0000 0000 0000 1111 = 16*/
    System.out.println(f);
    
    /*Bitwise operators*/
    // ~ NOT operator
    System.out.println("~ NOT operator");
    System.out.println( "~0 = " + ~0 ); // -1
    System.out.println("~0 to binary string: " + Integer.toBinaryString(~0));
    System.out.println( "~1 = " + ~1 ); // -2
    System.out.println("~1 to binary string: " + Integer.toBinaryString(~1));
    System.out.println( "~2 = " + ~2 ); // -3
    System.out.println("~2 to binary string: " + Integer.toBinaryString(~2));
    System.out.println();
    // & AND operator
    System.out.println("& AND operator");
    System.out.println( "0 & 0 = " + (0 & 0) ); // 0
    System.out.println( "0 & 1 = " + (0 & 1) ); // 0
    System.out.println( "1 & 0 = " + (1 & 0) ); // 0
    System.out.println( "1 & 1 = " + (1 & 1) ); // 1
    System.out.println( "1 & 2 = " + (1 & 2) ); // 0
    System.out.println( "2 & 1 = " + (2 & 1) ); // 0
    System.out.println( "2 & 2 = " + (2 & 2) ); // 2
    System.out.println();
    
    // | OR operator
    System.out.println("| OR operator");
    System.out.println( "0 | 0 = " + (0 | 0) ); // 0
    System.out.println( "0 | 1 = " + (0 | 1) ); // 1
    System.out.println( "1 | 0 = " + (1 | 0) ); // 1
    System.out.println( "1 | 1 = " + (1 | 1) ); // 1
    System.out.println( "1 | 2 = " + (1 | 2) ); // 3
    System.out.println( "2 | 1 = " + (2 | 1) ); // 3
    System.out.println( "2 | 2 = " + (2 | 2) ); // 2
    System.out.println();
    
    // ^ XOR operator
    System.out.println("^ XOR operator");
    System.out.println( "0 ^ 0 = " + (0 ^ 0) ); // 0
    System.out.println( "0 ^ 1 = " + (0 ^ 1) ); // 1
    System.out.println( "1 ^ 0 = " + (1 ^ 0) ); // 1
    System.out.println( "1 ^ 1 = " + (1 ^ 1) ); // 0
    System.out.println( "1 ^ 2 = " + (1 ^ 2) ); // 3
    System.out.println( "2 ^ 1 = " + (2 ^ 1) ); // 3
    System.out.println( "2 ^ 2 = " + (2 ^ 2) ); // 0
    System.out.println();
    
    /*Shift operators*/
    // left shift operator
    System.out.println("<< left shift operator");
    System.out.println( "5 << 1 = " + (5 << 1) ); // 101(2) = 5, left shift 2 spaces, 1010(2) = 10
    System.out.println( "5 << 2 = " + (5 << 2) ); // 101(2) = 5, left shift 2 spaces, 10100(2) = 20
    /*  In Java, the operator '>>' is signed right shift operator. 
     *  All integers are signed in Java, and it is fine to use >> for negative numbers. 
     *  The operator '>>' uses the sign bit(left most bit 0 or 1) to fill the trailing position after shift.
     *  If the number is negative which means left most is 1, then 1 is used as a filter and if the number is positive, then 0 is used as a filter.
     *  For example, if binary representation of number is 10...100, then right shifting it by 2 using >> will make it 11...1
    */
    System.out.println(">> right shift operator");
    System.out.println( "7 >> 1 = " + (7 >> 1) ); // left most fill with 0
    System.out.println("7 to binary string: " + Integer.toBinaryString(7));
    System.out.println( "7 >> 2 = " + (7 >> 2) ); 
    System.out.println("3 to binary string: " + Integer.toBinaryString(3));
    System.out.println( "7 >> 3 = " + (7 >> 3) ); 
    
    System.out.println( "-2 >> 1 = " + (-2 >> 1) ); // 1...1110 = -2, right shift 1 space and fill left most with 1, 1...1111 = -1
    System.out.println( "-3 >> 1 = " + (-3 >> 1) ); // 1...1101 = -3, right shift 1 space and fill left most with 1, 1...1110 = -2
    System.out.println("-3 to binary string: " + Integer.toBinaryString(-3));
    System.out.println("-2 to binary string: " + Integer.toBinaryString(-2));
    System.out.println( "-3 >> 2 = " + (-3 >> 2) ); // 1...1101 = -3, right shift 1 space and fill left most with 1, 1...1111 = -1

    System.out.println( "5 >> 2 = " + (5 >> 2) ); // 101(2) = 5, right shift 2 spaces, 1(2) = 1
    System.out.println( "-5 >> 2 = " + (-5 >> 2) ); // -101(2) = -5, right shift 2 spaces, 1(2) = 1
    
    /*  In Java, the operator '>>>' is unsigned right shift operator.
     *  It always fills 0 irrespective of the sign of the number.
     * */
    System.out.println( "-1 >>> 0 = " + (-1 >>> 0) ); //1111 1111 1111 1111 1111 1111 1111 1111
    System.out.println("-1 >>> 0 to binary string: " + Integer.toBinaryString(-1 >>> 0));
    System.out.println( "-1 >>> 1 = " + (-1 >>> 1) ); //0111 1111 1111 1111 1111 1111 1111 1111
    System.out.println("-1 >>> 1 to binary string: " + Integer.toBinaryString(-1 >>> 1));
    System.out.println( "-1 >>> 2 = " + (-1 >>> 2) ); //0011 1111 1111 1111 1111 1111 1111 1111
    System.out.println("-1 >>> 2 to binary string: " + Integer.toBinaryString(-1 >>> 2));
    System.out.println( "-1 >>> 3 = " + (-1 >>> 3) ); //0001 1111 1111 1111 1111 1111 1111 1111
    System.out.println("-1 >>> 3 to binary string: " + Integer.toBinaryString(-1 >>> 3));
    
    System.out.println( "-1 >>> 29 = " + (-1 >>> 29) ); // 0...0111 = 7
    System.out.println( "-1 >>> 30 = " + (-1 >>> 30) ); // 0...0011 = 3
    System.out.println( "-1 >>> 31 = " + (-1 >>> 31) ); // 0...0001 = 1
    System.out.println( "-1 >>> 32 = " + (-1 >>> 32) ); // 1...1111 = -1
    
    System.out.println( "-2 >>> 29 = " + (-2 >>> 29) ); // 0...0111 = 7
    System.out.println( "-2 >>> 30 = " + (-2 >>> 30) ); // 0...0011 = 3
    System.out.println( "-2 >>> 31 = " + (-2 >>> 31) ); // 0...0001 = 1
    System.out.println( "-2 >>> 32 = " + (-2 >>> 32) ); // 1...1110 = -2
    System.out.println( "5 >>> 2 = " + (5 >>> 2) ); // 101(2) = 5, right shift 2 spaces, 1(2) = 1
    System.out.println( "-5 >>> 31 = " + (-5 >>> 31) ); // 1...1010 = -5,
    System.out.println( "-5 << 1 = " + (-5 << 1) ); // 1...1010 = -5, left shift 1 space, 1...0110
    
    System.out.println("0xffffffff = " + 0xffffffff);
    
  }
}
