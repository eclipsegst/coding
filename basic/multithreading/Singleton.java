package multithreading;

/**
 * @author Zhaolong Zhong Oct 3, 2016
 * 
 * Lazy Initialization Singleton
 * 
 * Correct but possibly expensive mult-ithreaded version
 * 
 * Note:
 * A lock must be obtained in case two threads call getHelper() simultaneously. 
 * However, the first call to getHelper() will create the object and only 
 * the few threads trying to access it during that time need to be synchronized; 
 * after that all calls just get a reference to the member variable. 
 * Since synchronizing a method could in some extreme cases decrease performance by a factor of 100 or higher,
 * the overhead of acquiring and releasing a lock every time this method is called seems unnecessary: 
 * once the initialization has been completed, acquiring and releasing the locks would appear unnecessary.
 * 
 * Reference:
 * https://en.wikipedia.org/wiki/Singleton_pattern#Lazy_initialization
 * https://en.wikipedia.org/wiki/Double-checked_locking
 * http://www.ibm.com/developerworks/library/j-dcl/
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 */
public class Singleton {
	private static Singleton instance = null;
	
	private Singleton() {}
	
	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		
		return instance;
	}
	
	public void print() {
		System.out.println("Lazy Initialization Singleton Pattern");
	}
	
	public static void main(String[] args) {
		Singleton.getInstance().print();
	}
}
