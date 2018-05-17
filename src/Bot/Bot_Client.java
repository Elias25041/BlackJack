package Bot;

import AbiturKlassen.Client;
import Protokoll.Protokoll;

public class Bot_Client extends Client {
	int credit;
	int player;
	int[] cardworths = new int[5];
	int y;
	int cardworth;
	

	public Bot_Client(String pServerIP, int pServerPort) {
		super(pServerIP, pServerPort);
		credit = 100;
	}

	public void processMessage(String pMessage) {
		String[] splitMessage = pMessage.split(":");
		if(splitMessage[0].matches("-?\\d+")) {
			player = Integer.parseInt(splitMessage[0]);
		}
		switch(splitMessage[0]) {
			case Protokoll.SC_GAMESTART:
				credit = Integer.parseInt(splitMessage[1]);
				//Startkarten auswerten hinzufügen
				break;
				
			case Protokoll.SC_CARD:
				cardworth = getCardtype(splitMessage[1]);
				y = Integer.parseInt(splitMessage[2]);
				cardworths[y] = cardworths[y] + cardworth;
		}
				
	}

	public void hit() {
		send("CS_HIT");
	}

	public void set() {
		int x = credit / 10;
		send("CS_PAY:" + x);
	}
	
	public void stand() {
		send("CS_STAND");
	}
	
	private int getCardtype(String card) {
		String[] cardComponent = card.split("_");
		if(cardComponent[1].equals("Koenig") || cardComponent[1].equals("Dame") ||cardComponent[1].equals("Bube")) {
			return 10;
		} else if(cardComponent[1].equals("Ass")) {
			return 11;
		}
		return Integer.parseInt(cardComponent[1]);
	}
	
	

}
