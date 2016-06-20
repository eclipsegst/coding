package singleton.practical;

/**
 * @author Zhaolong Zhong Jun 19, 2016
 */
public class Main {
	public static void main(String[] args) {
		LoadBalancer lb1 = LoadBalancer.getInstance();
		LoadBalancer lb2 = LoadBalancer.getInstance();
		LoadBalancer lb3 = LoadBalancer.getInstance();
		LoadBalancer lb4 = LoadBalancer.getInstance();
		LoadBalancer lb5 = LoadBalancer.getInstance();
		
		System.out.println("All instances are the same instance? " 
		+ (lb1 == lb2 && lb2 == lb3 && lb3 == lb4 && lb4 ==lb5));
		
		LoadBalancer balancer = LoadBalancer.getInstance();
		for (int i = 0; i < 26; i++) {
			Server server = balancer.getServer();
			System.out.printf("Request was sent to %s at IP address %s.\n", server.getName(), server.getIp());
		}
	}
}
