/**
 * Author : Zhaolong Zhong
 * Date   : Feb 3, 2015 10:22:56 PM
 * 
 * Problem:
 * Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
package plusOne;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    boolean flag = false;
    for(int i = digits.length - 1; i >= 0; i--){
        if(i == digits.length -1) {
            digits[i] += 1;
        }
        
        if(flag) {
            if(digits[i] + 1 >= 10) {
                digits[i] = digits[i] + 1 - 10;
                flag = true;
            } else {
                digits[i] = digits[i] + 1;
                flag = false;
            }
            
        } else {
            if(digits[i] >= 10){
                digits[i] = digits[i] - 10;
                flag = true;
            } else {
                flag = false;
            }
        }
    }
    if(flag){
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for(int i = 1; i < res.length; i++){
            res[i] = digits[i-1];
        }
        return res;
    } else {
        return digits;
    }
}
}
