package a;

/**
 * @author Zhaolong Zhong May 29, 2016
 * 
 * Integer to Roman
 * 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
		int[] N    = { 1,   4,    5,   9,   10,  40,   50,  90,   100, 400,  500, 900, 1000};
		String[] C = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		
		String result = "";
		
		for (int i = 12; num != 0; i--) {
			while (num >= N[i]) {
				num -= N[i];
				result += C[i];
			}
		}
		
		return result;
	}
	
	public  static void main(String[] args) {
		IntegerToRoman solution = new IntegerToRoman();
		
		System.out.println(solution.intToRoman(26));
	}
}
