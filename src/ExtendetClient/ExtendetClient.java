package ExtendetClient;

import ExtendetClient.ExtendetClientFrame;
import AbiturKlassen.Client;
import Protokoll.Protokoll;
import Cards.Card;
import java.util.ArrayList;

public class ExtendetClient extends Client {
	private ExtendetClientFrame meineGui;
	ArrayList<String> player1 = new ArrayList<String>();
	ArrayList<String> player2 = new ArrayList<String>();
	ArrayList<String> player3 = new ArrayList<String>();
	ArrayList<String> player4 = new ArrayList<String>();
	ArrayList<String> player5 = new ArrayList<String>();
	ArrayList<String> player6 = new ArrayList<String>();
	ArrayList<String> dealer = new ArrayList<String>();
	
	

	public ExtendetClient(String pServerIP, int pServerPort, ExtendetClientFrame gui) {
		super(pServerIP, pServerPort);
		meineGui = gui;
		clearCardSlots();
		// TODO Auto-generated constructor stub
	}
	
	// 3 + 3*anzahlSpieler
	
	public void processMessage(String pMessage) {
		meineGui.ausgeben(pMessage);
		String[] splitMessage = pMessage.split(":");
		switch (splitMessage[0]) {
		case Protokoll.SC_GAMESTART:
			if(splitMessage.length == 21) {
				for(int i = 2; i<3; i++) {
					player1.add(splitMessage[i]);
				}
				for(int k = 5; k<6; k++) {
					player2.add(splitMessage[k]);
				}
				for(int j = 8; j<9; j++) {
					player3.add(splitMessage[j]);
				}
				for(int l = 11; l<12; l++) {
					player4.add(splitMessage[l]);
				}
				for(int h = 14; h<15; h++) {
					player5.add(splitMessage[h]);
				}
				for(int g = 17; g<18; g++) {
					player6.add(splitMessage[g]);
				}
			}else if(splitMessage.length == 18) {
				for(int i = 2; i<3; i++) {
					player1.add(splitMessage[i]);
				}
				for(int k = 5; k<6; k++) {
					player2.add(splitMessage[k]);
				}
				for(int j = 8; j<9; j++) {
					player3.add(splitMessage[j]);
				}
				for(int l = 11; l<12; l++) {
					player4.add(splitMessage[l]);
				}
				for(int h = 14; h<15; h++) {
					player5.add(splitMessage[h]);
				}
			}else if(splitMessage.length == 15) {
				for(int i = 2; i<3; i++) {
					player1.add(splitMessage[i]);
				}
				for(int k = 5; k<6; k++) {
					player2.add(splitMessage[k]);
				}
				for(int j = 8; j<9; j++) {
					player3.add(splitMessage[j]);
				}
				for(int l = 11; l<12; l++) {
					player4.add(splitMessage[l]);
				}
			}else if(splitMessage.length == 12) {
				for(int i = 2; i<3; i++) {
					player1.add(splitMessage[i]);
				}
				for(int k = 5; k<6; k++) {
					player2.add(splitMessage[k]);
				}
				for(int j = 8; j<9; j++) {
					player3.add(splitMessage[j]);
				}
			}else if(splitMessage.length == 9) {
				for(int i = 2; i<3; i++) {
					player1.add(splitMessage[i]);
				}
				for(int k = 5; k<6; k++) {
					player2.add(splitMessage[k]);
				}
			}
			dealer.add(splitMessage[20]);
			break;
		case Protokoll.SC_CARD:
			if(splitMessage[2].equals("1")) {
				player1.add(splitMessage[1]);
			}else if(splitMessage[2].equals("2")) {
				player2.add(splitMessage[1]);
			}else if(splitMessage[2].equals("3")) {
				player3.add(splitMessage[1]);
			}else if(splitMessage[2].equals("4")) {
				player4.add(splitMessage[1]);
			}else if(splitMessage[2].equals("5")) {
				player5.add(splitMessage[1]);
			}else if(splitMessage[2].equals("6")) {
				player6.add(splitMessage[1]);
			}
			break;
		}
		//System.out.println("" + splitMessage[i]);
	}

	private void clearCardSlots() {
		player1.clear();
		player2.clear();
		player3.clear();
		player4.clear();
		player5.clear();
		player6.clear();
	}

	public void karteGezogen(String rest) {

	}
}
