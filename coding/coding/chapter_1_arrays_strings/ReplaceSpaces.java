/**
 * Author: Zhaolong Zhong
 * Date  : Mar 6, 2015 6:05:59 PM
 *
 */
package chapter_1_arrays_strings;

public class ReplaceSpaces {
  public static char[] replaceSpaces(char[] str) {
    int count = 0;
    for (int i = 0; i < str.length; i++) {
      if (str[i] == ' ') {
          count++;    
      }
    }
    int newLength = str.length + count * 2;
    char [] result = new char[newLength];
    int k = 0;
    for (int j = 0; j < str.length; j++) {
        if (str[j] == ' ') {
          result[k++] = '%';
          result[k++] = '2';
          result[k++] = '0';
        } else {
          result[k++] = str[j];
        }
    }
    return result;
  }
  
  public static void replaceSpacesInPlace(char[] str) {
    int count = 0, i = 0;
    for (i = 0; i < str.length; i++) {
      if(str[i] == ' ') {
        count++;
      }
    }
    
    int newLength = str.length + count * 2;
    // array is fixed, this will not work
    str[newLength] = '\0';
    
    for (i = str.length - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[--newLength] = '2';
        str[--newLength] = '0';
        str[--newLength] = '%';
      } else {
        str[--newLength] = str[i];
      }
    }
  }

  public static void main(String[] args) {
    char[] str = {'a', ' ', 'b', ' ', ' ', 'c'};
    char[] res = replaceSpaces(str);
    System.out.println(new String(res));
//    replaceSpacesInPlace(str);

  }
}
