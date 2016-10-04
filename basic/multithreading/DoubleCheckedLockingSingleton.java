package multithreading;

/**
 * @author Zhaolong Zhong Oct 3, 2016
 * 
 * Double-Checked Locking Singleton
 * 
 * It is typically used to reduce locking overhead when implementing "lazy initialization" 
 * in a multi-threaded environment, especially as part of the Singleton pattern. 
 * Lazy initialization avoids initializing a value until the first time it is accessed.
 * 
 * Note:
 * Works with acquire/release semantics for volatile in Java 1.5 and later
 * Broken under Java 1.4 and earlier semantics for volatile
 * 
 * Reference:
 * https://en.wikipedia.org/wiki/Double-checked_locking
 * http://www.ibm.com/developerworks/library/j-dcl/
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 */
public class DoubleCheckedLockingSingleton {
	private static volatile DoubleCheckedLockingSingleton instance;
	
	public static DoubleCheckedLockingSingleton getInstance() {
		if (instance == null) { // Single Checked
			synchronized(DoubleCheckedLockingSingleton.class) {
				if (instance == null) { // Double Checked
					instance = new DoubleCheckedLockingSingleton();
				}
			}
		}
		
		return instance;
	}
	
	public void print() {
		System.out.println("Double Checked Locking Singleton Pattern");
	}
	
	public static void main(String[] args) {
		DoubleCheckedLockingSingleton.getInstance().print();
	}
}
