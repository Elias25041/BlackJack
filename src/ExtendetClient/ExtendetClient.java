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
		String anfang = pMessage.substring(0, 0);
		String rest = pMessage.substring(2);
		switch (anfang) {
		case Protokoll.SC_GAMESTART:
			karteGezogen(rest);
			break;
		case Protokoll.SC_CARD:
			karteGezogen(rest);
			break;
		case Protokoll.SC_ERROR:
			meineGui.ausgeben(pMessage);
			break;
		}
	}
	
	public void karteGezogen(String rest) {
		
	}
}
