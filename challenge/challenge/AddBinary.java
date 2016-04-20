/**
 * Author: Zhaolong Zhong
 * Date  : Feb 4, 2015 11:37:19 PM
 *
 */
package challenge;

public class AddBinary {
  public static void main(String[] args) {
    System.out.println(addBinary("1", "111"));
  }
  
  public static String addBinary(String a, String b) {
    int len = Math.max(a.length(), b.length());
    a = padding(a, len);
    b = padding(b, len);
    String res = "";
    char flag = '0';
    for(int i = len -1; i >= 0; i--){
        char c = a.charAt(i);
        if(flag == '0') {
            if(c == '0'){
                res = b.charAt(i) + res;
            } else {
              if(b.charAt(i) == '0')
                res = '1' + res;
              else {
                res = '0' + res;
                flag = '1';
              }
            }
        }else {
            if(c == '0'){
                if(b.charAt(i) == '1'){
                  res = '0' + res;
                } else {
                  res = '1' + res;
                  flag = '0';
                }
            } else {
                res = b.charAt(i) + res;
                flag = '1';
            }
        }
    }
    if(flag == '1') return '1' + res;
    return res;
  }
  static String padding(String s, int len) {
    int l = s.length();
    for(int i = 0; i < len - l; i++){
        s = '0' + s;
    }
    return s;
  }
}
