package singleton.practical;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Zhaolong Zhong Jun 19, 2016
 */
public class LoadBalancer {
	private static LoadBalancer instance;
	
	private List<Server> servers = new ArrayList<Server>();
	
	private Random random = new Random();
	
	private LoadBalancer() {
		servers.add(new Server("Server A", "123.456.1.26"));
		servers.add(new Server("Server B", "123.456.2.26"));
		servers.add(new Server("Server C", "123.456.3.26"));
		servers.add(new Server("Server D", "123.456.4.26"));
		servers.add(new Server("Server E", "123.456.5.26"));
		servers.add(new Server("Server F", "123.456.6.26"));
	}
	
	public static LoadBalancer getInstance() {
		if (instance == null) {
			instance = new LoadBalancer();
		}
		
		return instance;
	}
	
	public Server getServer() {
		int index = random.nextInt(servers.size());
		return servers.get(index);
	}
}
