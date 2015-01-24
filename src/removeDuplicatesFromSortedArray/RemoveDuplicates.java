package removeDuplicatesFromSortedArray;

import java.util.Arrays;
/*
 * Date: 01/18/2015
 * 
 * Create an array with all unique elements
 */
public class RemoveDuplicates {
  public static void main(String[] args) {
	int[] arr1 = {1,2,2,3,4,4};
	int[] arr2 = {1,1,1,2,2,2,3,3,3,4};
	int [] a = removeDuplicates(arr1);
//	System.out.println(a.length);
//	System.out.println(countUnique(a));
//	System.out.println(removeDuplicatesTwoNaive(arr2));
//	System.out.println(removeDuplicatesCorrect(arr2));
	System.out.println(removeDuplicatesBetter(arr2));
	System.out.println(arr2[3]);
  }
	
  public static int[] removeDuplicates(int[] a) {
	if (a.length < 2) {
	  return a;
	}
		
	int i = 1;
	int j = 0;
	
	while (i < a.length) {
	  if(a[i] == a[j]) {
	    i++;
  	  } else {
  	    j++;
  	    a[j] = a[i];
  	    i++;
  	  }
	}
		
	int[] b = Arrays.copyOf(a, j+1);
	  return b;
  }
	
  public static int countUnique(int[] a) {
	int count = 0;
	for (int i = 0; i < a.length - 1; i++) {
	  if (a[i] == a[i+1]) {
		count++;
	  }
	}
	return (a.length - count);
  }
  
  /*It doesn't change the original array.*/
  public static int removeDuplicatesTwoNaive(int[] a) {
	if (a.length < 2) {
	  return a.length;
	}
	  
	int count = 0;
	int i = 1;
	boolean flag = false;
	int pre = a[0];
	while (i < a.length) {
	  if (pre == a[i]){
	    if (flag == true) {
	      count ++;
	    } else {
	      flag = true;
	    }
	  } else{
	    flag = false;
	  }
	  pre = a[i];
	  i++;
	}
	return a.length - count;
  }
  
  /*It will change the original array*/
  public static int removeDuplicatesCorrect(int[] a) {
    if (a == null || a.length == 0) {
      return 0;
    }
    int count = 0;
    int i = 1;
    int j = 1;
    boolean flag = false;
    int pre = a[0];
    while(i < a.length) {
      if (pre == a[i]) {
        if (flag == true) {
          count ++;
        } else {
          flag = true;
          a[j++] = a[i]; // after 2 to 3, we need to set the digit after 3 to the current digit.
        }
      }else{
        pre = a[i];
        a[j++] = a[i];
        flag = false;
      }
      
      i++;
    }
    return a.length - count;
  }
  
  /*Use to pointer, the previous pointer + 1 will be the result.*/
  public static int removeDuplicatesBetter(int[] a) {
    if (a.length <= 2) {
      return a.length;
    }
    
    int pre = 1;
    int cur = 2;
    
    while (cur < a.length) {
      if (a[cur] == a[pre] && a[cur] == a[pre-1]) {
        cur ++;
      } else {
        pre ++;
        a[pre] = a[cur];
        cur ++;
      }
    }
    
    return pre + 1;
  }
}
