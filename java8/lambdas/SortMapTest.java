package lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class SortMapTest {

	@Test
	public void testSortByValueJava8() {
		Random random = new Random(System.currentTimeMillis());
		Map<String, Integer> testMap = new HashMap<String, Integer>(100);
		
		for (int i = 0; i < 100; i++) {
			testMap.put("RandomString" + random.nextInt(), random.nextInt());
		}
		
		testMap = SortMap.sortByValue(testMap);
		Assert.assertEquals(100, testMap.size());
		
		Integer previous = null;
		for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
			Assert.assertNotNull( entry.getValue());
			if (previous != null) {
				Assert.assertTrue( entry.getValue() >= previous);
			}
			previous = entry.getValue();
		}
	}
	
	@Test
	public void testSortByValueJava7() {
		Random random = new Random(System.currentTimeMillis());
		Map<String, Integer> testMap = new HashMap<String, Integer>(100);
		
		for (int i = 0; i < 100; i++) {
			testMap.put("RandomString" + random.nextInt(), random.nextInt());
		}
		
		testMap = SortMap.sortByValueJava7(testMap);
		Assert.assertEquals(100, testMap.size());
		
		Integer previous = null;
		for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
			Assert.assertNotNull( entry.getValue());
			if (previous != null) {
				Assert.assertTrue( entry.getValue() >= previous);
			}
			previous = entry.getValue();
		}
	}

}
