package parallel_arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelArrays {

	public static void main(String[] args) {
		long[] arrayOfLong = new long [100];
		
		Arrays.parallelSetAll(arrayOfLong,
				index -> ThreadLocalRandom.current().nextInt(1000));
		Arrays.stream(arrayOfLong).limit(10).forEach(
				i -> System.out.print(i + " "));
		System.out.println();
		Arrays.parallelSort(arrayOfLong);
		Arrays.stream(arrayOfLong).limit(10).forEach(
				i -> System.out.print(i + " "));
		System.out.println();
	}
}
