package penalty;
/*
 * Problem: Given a string, 0 means skipping class, 1 means late for class
 * if a student skip class or late for class for three times, then the student
 * will be punished. Check a string to find out if the student get punished or not.
 */

public class Penalty {
	public static void main(String[] args){
		String s1 = "11";
		String s2 = "111";
		String s3 = "10";
		
		boolean result1 = check(s1);
		boolean result2 = check(s2);
		boolean result3 = check(s3);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
	public static boolean check(String s){
		boolean result = false;
		
		int count = 0;
		for(int i= 0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='0'){
				result = true;
				break;
			}else{
				count ++;
				if(count==3){
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
