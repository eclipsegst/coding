package basic;

import java.util.Arrays;

public class Trivia {

	public static void main(String[] args) {
		
		// Remove white spaces
		String s0 = "a b   c";
		System.out.println(s0.replaceAll("\\s+",""));
		String s1 = "d e f";
		System.out.println(s1.replaceAll("\\s",""));
		
		// Split by whit spaces
		String[] ss = s0.split(" +");
		// String[] ss = s0.split("\\s+");
		Arrays.asList(ss).forEach((String s) -> System.out.print(s + ","));
		System.out.println();
		System.out.println("Split by at least two spaces:");
		String[] sss = s0.split("\\s{2,}");
		Arrays.asList(sss).forEach((String s) -> System.out.print(s + ","));
		
	}

}
