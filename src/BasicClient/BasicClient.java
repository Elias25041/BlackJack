package BasicClient;
import AbiturKlassen.Client;
import Protokoll.Protokoll;

public class BasicClient extends Client{

	private BasicClientFrame meineGui;
	
	public BasicClient(String pServerIP, int pServerPort, BasicClientFrame gui) {
		super(pServerIP, pServerPort);
		meineGui = gui;
		// TODO Auto-generated constructor stub
	}

	public void processMessage(String pMessage) {
		meineGui.ausgeben(pMessage);
	}
	
}
