package multithreading;

import java.util.Arrays;

/**
 * @author Zhaolong Zhong Oct 3, 2016
 * 
 * Enum Singleton
 * 
 * Making a class a Singleton can make it difficult to test its clients, 
 * as it’s impossible to substitute a mock implementation for a singleton 
 * unless it implements an interface that serves as its type. 
 * Recommended approach is implement Singletons by simply make an enum type with one element.
 * 
 * "This approach is functionally equivalent to the public field approach, 
 * except that it is more concise, provides the serialization machinery for free, 
 * and provides an ironclad guarantee against multiple instantiation, 
 * even in the face of sophisticated serialization or reflection attacks. 
 * While this approach has yet to be widely adopted, 
 * a single-element enum type is the best way to implement a singleton."
 * 
 * - "Effective Java"
 * 
 * Note:
 * enum fields are compile time constants, but they are instances of their enum type. 
 * And, they're constructed when the enum type is referenced for the first time.
 * 
 * Reference:
 * http://stackoverflow.com/a/71399/2427211
 * https://sites.google.com/site/io/effective-java-reloaded
 * 
 */
public enum EnumSingleton {
	INSTANCE;
	
	private final String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel" };
	
	private EnumSingleton() {
		
	}
	
	public void print() {
		System.out.println("Enum Singleton Pattern.");
	}
	
	public void pintFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}
	
	public static void main(String[] args) {
		EnumSingleton.INSTANCE.pintFavorites();
		EnumSingleton.INSTANCE.print();
	}
}
