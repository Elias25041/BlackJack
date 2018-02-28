package ExtendetClient;

import ExtendetClient.ExtendetClientFrame;
import AbiturKlassen.Client;

public class ExtendetClient extends Client{
private ExtendetClientFrame meineGui;
	
	public ExtendetClient(String pServerIP, int pServerPort, ExtendetClientFrame gui) {
		super(pServerIP, pServerPort);
		meineGui = gui;
		// TODO Auto-generated constructor stub
	}

	public void processMessage(String pMessage) {
		meineGui.ausgeben(pMessage);
	}
}
