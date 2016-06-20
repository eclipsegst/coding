package singleton.structural;

/**
 * @author Zhaolong Zhong Jun 19, 2016
 */
public class Application {
	private static Application instance;
	
	private Application() {}
	
	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}
		
		return instance;
	}
}
