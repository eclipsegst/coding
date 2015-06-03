/**
 * Author: Zhaolong Zhong
 * Date  : 2015 4:04:55 PM
 */
package bitset;

import java.util.BitSet;

public class Example {
  public static void main(String[] args) {
 // create 2 bitsets
    BitSet bitset1 = new BitSet(8);
    BitSet bitset2 = new BitSet(8);

    // assign values to bitset1
    bitset1.set(0);
    bitset1.set(1);
    bitset1.set(2);
    bitset1.set(3);
    bitset1.set(4);
    bitset1.set(5);

    // assign values to bitset2
    bitset2.set(2);
    bitset2.set(4);
    bitset2.set(6);
    bitset2.set(8);
    bitset2.set(10);

    // print the sets
    System.out.println("Bitset1:" + bitset1);
    System.out.println("Bitset2:" + bitset2);

    // nextClearBits() returns the index of the next clear bit.
    // print the first clear bit of bitset1
    System.out.println("" + bitset1.nextClearBit(0));

    // print the first clear bit of bitset2 after index 5
    System.out.println("" + bitset2.nextClearBit(10));
    
    // return the number of bits set to true in this BitSet.
    System.out.println("Bitset1 cardinality:" + bitset1.cardinality());
    System.out.println("Bitset2 cardinality:" + bitset2.cardinality());
    
    // Sets each bit from the specified fromIndex (inclusive) to 
    // the specified toIndex (exclusive) to the complement of its current value.
    bitset1.flip(0, 3);
    bitset2.flip(0, 3);
    System.out.println("Bitset1 flip(0,3) = " + bitset1);
    System.out.println("Bitset2 flip(0,3) = " + bitset2);
  }
}
