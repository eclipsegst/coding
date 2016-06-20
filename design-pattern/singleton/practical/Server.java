package singleton.practical;

/**
 * @author Zhaolong Zhong Jun 19, 2016
 */
public class Server {
	private String name;
	private String ip;
	
	public Server(String name, String ip) {
		this.name = name;
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
