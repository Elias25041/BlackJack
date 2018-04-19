package Bot;
import AbiturKlassen.Client;
import Protokoll.Protokoll;

public class Bot_Client extends Client{
	int credit;
	
	public Bot_Client(String pServerIP, int pServerPort) {
		super(pServerIP, pServerPort);
	}

	public void processMessage(String pMessage) {
		String[] splitMessage = pMessage.split(":");
		switch(splitMessage[0]) {
			case Protokoll.SC_GAMESTART:
				credit = Integer.parseInt(splitMessage[1]);
				
			case Protokoll.SC_CARD:
				
		}
		}
	
	public void hit() {
		send("CS_HIT");
	}
	
	public void set() {
		int x=credit/10;
		send("CS_PAY:" + x);
	}
	
	public void stand() {
		send("CS_STAND");
	}
	
	

}
