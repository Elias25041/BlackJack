package Bot;
import AbiturKlassen.Client;
import Protokoll.Protokoll;

public class Bot_Client extends Client{

	public Bot_Client(String pServerIP, int pServerPort) {
		super(pServerIP, pServerPort);
	}

	public void processMessage(String pMessage) {
		String[] splitMessage = pMessage.split(":");
		switch(splitMessage[0]) {
			case Protokoll.SC_GAMESTART:
				
		}
	}

}
