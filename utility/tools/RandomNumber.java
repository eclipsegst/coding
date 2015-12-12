package tools;

import java.util.Random;

/**
 * @author Zhaolong Zhong Dec 12, 2015
 */
public class RandomNumber {
	
	public double getRandomNumberDouble(int min, int max) {
		return (double)Math.random() * max + min;
	}
	
	public int getRandomNumberInt(int min, int max) {
		return (int)Math.random() * max + min;
	}
	
	public int getRandomNumberSecond(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max) + min;
	}
}
