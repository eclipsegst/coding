/**
 * Author: Zhaolong Zhong
 * Date  : 2015 10:03:30 AM
 */
package sort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {
  private int[] nums;
  private final static int SIZE = 7;
  private final static int MAX = 20;
  
  @Before
  public void setUp() throws Exception {
    nums = new int[SIZE];
    Random generator = new Random();
    for (int i = 0; i < nums.length; i++) {
      nums[i] = generator.nextInt(MAX);
    }
  }

  /**
   * Test method for {@link sort.MergeSort#sort(int[])}.
   */
  @Test
  public void testSort() {
    long startTime = System.currentTimeMillis();
    
    MergeSort sorter = new MergeSort();
    sorter.sort(nums);
    
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("MergeSort time " + elapsedTime);
    
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        fail("Should not happen");
      }
    }
    
    assertTrue(true);
  }
  
  @Test
  public void testRepeatably() {
    for (int i= 0; i < 200; i++) {
      nums = new int[SIZE];
      Random generator = new Random();
      for (int j = 0; j < nums.length; j++) {
        nums[j] = generator.nextInt(MAX);
      }
      
      MergeSort sorter = new MergeSort();
      sorter.sort(nums);
      
      for (int k = 0; k < nums.length - 1; k++) {
        if (nums[k] > nums[k + 1]) {
          fail("Should not happen");
        }
      }
    }

    assertTrue(true);
  }
  
  @Test
  public void testStandardSort() {
    long startTime = System.currentTimeMillis();
    Arrays.sort(nums);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("Standard Java sort time: " + elapsedTime);
    
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        fail("Should not happen");
      }
    }
    
    assertTrue(true);
  }
}
