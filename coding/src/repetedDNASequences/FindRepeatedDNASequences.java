/**
 * Author : Zhaolong Zhong
 * Date   : Feb 9, 2015 10:46:40 PM
 * Problem:
 * Repeated DNA Sequences
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G and T,
 * for example:"ACGAATTCCG". When studying DNA, it is sometimes useful to identify
 * repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences(substrings) 
 * that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCAAAAAGGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"]
 */
package repetedDNASequences;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class FindRepeatedDNASequences {
  public static List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new ArrayList<String>();
    Set<String> set = new HashSet<String>();
    
    int len = s.length();
    if (len < 20) return res;
    for (int i = 0; i < len - 20; i++) {
      for (int j = i + 10; j < len - 10; j++) {
        if (s.substring(i, i + 10).equals(s.substring(j, j + 10))) {
          set.add(s.substring(i, i + 10));
        }
      }  
    }
    if (!set.isEmpty()) {
      res.addAll(set);
    }
    return res;
  }
  
  public static void main(String[] args) {
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    List<String> list = findRepeatedDnaSequences(s);
    System.out.println(Arrays.toString(list.toArray()));
  }
}
