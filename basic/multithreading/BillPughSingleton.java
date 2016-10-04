package multithreading;

/**
 * @author Zhaolong Zhong Oct 3, 2016
 * 
 * Bill Pugh Singleton
 * 
 * Reference:
 * http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 * http://stackoverflow.com/a/6109966/2427211
 * 
 */
public class BillPughSingleton {
	private BillPughSingleton() {
		
	}
	
	private void print() {
		System.out.println("Bill Pugh Singleton Pattern");
	}
	
	private static class Holder {
		public static final BillPughSingleton instance = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return Holder.instance;
	}

	public static void main(String[] args) {
		BillPughSingleton.getInstance().print();
	}
}
