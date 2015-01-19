package returnIntegerArray;
import java.util.Stack;
/*
 * Date: 01/19/2015 14:00
 * Problem:
 * Given an integer array, take the array as an integer and return an array after the integer plus one.
 * For example, given [1,2,3,4], plus 1, return [1,2,3,5]. Given [9,9,9,9], plus 1, return [1,0,0,0,0]  
*/
public class ReturnIntegerArray {
  public static void main(String[] args) {
    int[] a = {1,2,3,4};
    int[] b = {9,9,9,9};
    int[] c = returnArray(a);
    int[] d = returnArray(b);
    
    for (int i=0; i<c.length; i++) {
      System.out.print(c[i]);
    }
    System.out.println();
    for (int i=0; i<d.length; i++) {
      System.out.print(d[i]);
    }
  }
  public static int[] returnArray(int[] a) {
    if (a == null) {
      return null;
    }
    Stack<Integer> s = new Stack<Integer>();
    
    for (int i=0; i<a.length; i++) {
      s.push(a[i]);
    }

    boolean flag = true;
    int temp = 0;
    for (int j=0; j<a.length; j++) {
      int top = s.peek();    
      if (flag) {
        temp = top + 1;
      } else {
        temp = top;
      }
      if (temp<10) {
        a[a.length-1 -j] = temp;
        flag = false;
      }
      else{
        flag = true;
        String str = Integer.toString(temp);
        a[a.length-1 -j] = Integer.parseInt(str) % 10;
        //a[a.length-1 -j] = 0;
      }
      s.pop();
    }
    
    if (flag) {
      int[] arr = new int[a.length+1];
      arr[0] = 1;
      for (int k=0; k<a.length-1; k++) {
        arr[k+1] = a[k];
      }
      return arr;
    }
    return a;
  }

}
