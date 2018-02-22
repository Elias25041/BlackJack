package basicClient;

public class Starter {

	static String IP;
	static int port;
	
	public Starter(final String pServerIP, int pServerPort) {
		IP = pServerIP;
		port = pServerPort;
	}
	
	public static void main(String[] args) {
		BasicClient bc;
		bc = new BasicClient(IP, port);
		System.out.println("Hallo");
	}

}
