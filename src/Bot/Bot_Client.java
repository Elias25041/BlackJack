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
				int startspieler = splitMessage.length;
				this.set();
				break;
				
			case Protokoll.SC_CARD:
				cardworth = getCardtype(splitMessage[1]);
				y = Integer.parseInt(splitMessage[2]);
				cardworths[y] = cardworths[y] + cardworth;
				
				break;
				
			case Protokoll.SC_DEALERWIN:
				clearArray();
				
				break;
				
			case Protokoll.SC_LOSE:
				clearArray();
				
				break;
				
			case Protokoll.SC_WIN:
				clearArray();
				
				break;
				
			case Protokoll.SC_STAND:
				y = Integer.parseInt(splitMessage[2]);				
					while(cardworths[y]<cardworths[player]) {
						hit();
					}
					stand();
					
				break;			
				
		}
				
	}

	public void hit() {
		send(Protokoll.CS_HIT);
	}

	public void set() {
		int x = credit / 10;
		send(Protokoll.CS_PAY + ":"+ x);
	}
	
	public void stand() {
		send(Protokoll.CS_STAND);
	}
	
	/*
	 * Die Inhalte des Arrays, der die Kartenwerte der Spieler beinhaltet, werden gelöscht.
	 */
	public void clearArray() {
		for(int j=0; j<5; j++) {
			cardworths[j] = 0;
		}
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
