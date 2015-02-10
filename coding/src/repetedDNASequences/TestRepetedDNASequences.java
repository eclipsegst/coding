/**
 * Author: Zhaolong Zhong
 * Date  : Feb 9, 2015 11:45:48 PM
 *
 */
package repetedDNASequences;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestRepetedDNASequences {

  @Test
  public void testExample() {
    FindRepeatedDNASequences tester = new FindRepeatedDNASequences();
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    @SuppressWarnings("static-access")
    List<String> testResult = tester.findRepeatedDnaSequences(s);
    List<String> actualResult = new ArrayList<String>();
    actualResult.add("AAAAACCCCC");
    actualResult.add("CCCCCAAAAA");
    assertEquals(actualResult, testResult);
  }
}
