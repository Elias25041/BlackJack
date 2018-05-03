package ExtendetClient;

import ExtendetClient.ExtendetClientFrame;
import AbiturKlassen.Client;
import Protokoll.Protokoll;

public class ExtendetClient extends Client {
	private ExtendetClientFrame meineGui;

	public ExtendetClient(String pServerIP, int pServerPort, ExtendetClientFrame gui) {
		super(pServerIP, pServerPort);
		meineGui = gui;
		// TODO Auto-generated constructor stub
	}

	public void processMessage(String pMessage) {
		meineGui.ausgeben(pMessage);
		String[] splitMessage = pMessage.split(":");
		switch (splitMessage[0]) {
		case Protokoll.SC_GAMESTART:
			for (int i = 2; i < splitMessage.length; i++) {
				String toWork = splitMessage[i];
				if(splitMessage.length == 21 ) {
					
					for(int j = 0; i<5; i++) {
						
						
					}
				}
					
			}
			break;
		case Protokoll.SC_CARD:
			break;
		}
		//System.out.println("" + splitMessage[i]);
	}

	

	public void karteGezogen(String rest) {

	}
}
