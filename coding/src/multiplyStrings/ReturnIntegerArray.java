package multiplyStrings;
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
    
    printArray(c);
    printArray(d);
    
    int[] e = {1,2,3,4};
    int[] f = {9,9,9,9};
    int[] g = {2,2,2,2};
    int[] h = returnArrayTwo(f,e); //output {1,1,2,3,3}
    int[] i = returnArrayTwo(g,e); //output {3,4,5,6}
    
    printArray(h);
    printArray(i);
    
    int[] m = {1,2};
    int[] n = {1,1};
    int[] l = returnArrayMultiply(m,n);
    printArray(l);
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
        a[a.length-1 -j] = temp % 10;
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
  
//given two integer array return one array
public static int[] returnArrayTwo(int[] a, int[] b) {
  if (a==null && b!=null) {
    return b;
  } else if (a!=null && b==null) {
    return a;
  } else if (a==null && b==null) {
    return null;
  }
  int lena = a.length;
  int lenb = b.length;
  if (lena != lenb) {
    return null;
  }

  Stack<Integer> sa = new Stack<Integer>();
  Stack<Integer> sb = new Stack<Integer>();
 
  for (int i=0; i<lena; i++) {
    sa.push(a[i]);
    sb.push(b[i]);
  }
  
  boolean flag = false;
  int sum = 0, tempa = 0, tempb = 0;
    for (int k=0; k<lena; k++) {
      tempa = sa.peek();
      tempb = sb.peek();
      if(flag){
        sum = tempa + tempb + 1;
      } else {
        sum = tempa + tempb;
      }

      if (sum < 10) {
        a[lena-1-k] = sum;
        flag = false;
      } else {
        a[lena-1-k] = sum % 10;
        flag = true;
      }
      sa.pop();
      sb.pop();
    }
    if (flag) {
      int[] arr = new int[lena+1];
      arr[0] = 1;
      for (int m=0; m<lena; m++) {
        arr[m+1] = a[m]; 
      }
      return arr;
    }
    return a;
  }
  
  public static void printArray(int[] a) {
    for (int i=0; i<a.length; i++) {
      System.out.print(a[i]);
    }
    System.out.println();
  }
//two array multiply
public static int[] returnArrayMultiply(int[] a, int[] b) {
  if (a==null && b!=null) {
    return b;
  } else if (a!=null && b==null) {
    return a;
  } else if (a==null && b==null) {
    return null;
  }
  boolean flag = false;// leading zero
  String stra = "";
  String strb = "";
  for (int i=0; i<a.length; i++) {
    if (a[i] != 0) {
      flag = true;
    }
    if (flag) {
      stra += a[i];
    }
  }
 
  flag = false;
  for (int j=0; j<b.length; j++) {
    if (b[j] != 0) {
      flag = true;
    }
    if (flag){
      strb += b[j];
    }
  }
  int ia = Integer.parseInt(stra);
  int ib = Integer.parseInt(strb);
  int result = ia * ib;
  String str = String.valueOf(result);
  int[] res = new int[str.length()];
  for (int k=0;k<str.length();k++) {
    res[k] = Character.getNumericValue(str.charAt(k));
  }
  return res;
}
}
