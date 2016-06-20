package singleton.structural;

/**
 * @author Zhaolong Zhong Jun 19, 2016
 */
public class Main {
	public static void main(String[] args) {
		Application a1 = Application.getInstance();
		Application a2 = Application.getInstance();
		
		System.out.println("Object are the same instance? " + (a1.equals(a2)));
	}
}
