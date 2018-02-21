package basicClient;
import AbiturKlassen.Client;

public class BasicClient extends Client{

	public BasicClient(String pServerIP, int pServerPort) {
		super(pServerIP, pServerPort);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processMessage(String pMessage) {
		System.out.println(pMessage);
		
	}
	
}
