package ExtendetClient;

import ExtendetClient.ExtendetClientFrame;
import AbiturKlassen.Client;
import Protokoll.Protokoll;
import Cards.Card;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ExtendetClient extends Client {
	private ExtendetClientFrame meineGui;
	ArrayList<String> player1 = new ArrayList<String>();
	ArrayList<String> player2 = new ArrayList<String>();
	ArrayList<String> player3 = new ArrayList<String>();
	ArrayList<String> player4 = new ArrayList<String>();
	ArrayList<String> player5 = new ArrayList<String>();
	ArrayList<String> player6 = new ArrayList<String>();
	ArrayList<String> dealer = new ArrayList<String>();
	
	ArrayList<ImageIcon> playerCard1 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> playerCard2 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> playerCard3 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> playerCard4 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> playerCard5 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> playerCard6 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> dealerCard = new ArrayList<ImageIcon>();
	
	

	public ExtendetClient(String pServerIP, int pServerPort, ExtendetClientFrame gui) {
		super(pServerIP, pServerPort);
		meineGui = gui;
		
		// TODO Auto-generated constructor stub
	}
	
	// 3 + 3*anzahlSpieler
	
	public void processMessage(String pMessage) {
		clearCardSlots();
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
				dealer.add(splitMessage[20]);
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
				dealer.add(splitMessage[17]);
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
				dealer.add(splitMessage[14]);
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
				dealer.add(splitMessage[11]);
			}else if(splitMessage.length == 9) {
				for(int i = 2; i<3; i++) {
					player1.add(splitMessage[i]);
				}
				for(int k = 5; k<6; k++) {
					player2.add(splitMessage[k]);
				}
				dealer.add(splitMessage[8]);
			}
			playerCard1 = meineGui.returnImages(player1, "player1");
			playerCard2 = meineGui.returnImages(player2, "player2");
			playerCard3 = meineGui.returnImages(player3, "player3");
			playerCard4 = meineGui.returnImages(player4, "player4");
			playerCard5 = meineGui.returnImages(player5, "player5");
			playerCard6 = meineGui.returnImages(player6, "player6");
			
			meineGui.setImagesToGUI(playerCard1, "player1");
			meineGui.setImagesToGUI(playerCard2, "player2");
			meineGui.setImagesToGUI(playerCard3, "player3");
			meineGui.setImagesToGUI(playerCard4, "player4");
			meineGui.setImagesToGUI(playerCard5, "player5");
			meineGui.setImagesToGUI(playerCard6, "player6");
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
			playerCard1 = meineGui.returnImages(player1, "player1");
			playerCard2 = meineGui.returnImages(player2, "player2");
			playerCard3 = meineGui.returnImages(player3, "player3");
			playerCard4 = meineGui.returnImages(player4, "player4");
			playerCard5 = meineGui.returnImages(player5, "player5");
			playerCard6 = meineGui.returnImages(player6, "player6");
			
			meineGui.setImagesToGUI(playerCard1, "player1");
			meineGui.setImagesToGUI(playerCard2, "player2");
			meineGui.setImagesToGUI(playerCard3, "player3");
			meineGui.setImagesToGUI(playerCard4, "player4");
			meineGui.setImagesToGUI(playerCard5, "player5");
			meineGui.setImagesToGUI(playerCard6, "player6");
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
	
	public ArrayList<String> getPlayer1() {
		return player1;
	}
	
	public ArrayList<String> getPlayer2() {
		return player2;
	}
	
	public ArrayList<String> getPlayer3() {
		return player3;
	}
	
	public ArrayList<String> getPlayer4() {
		return player4;
	}
	
	public ArrayList<String> getPlayer5() {
		return player5;
	}
	
	public ArrayList<String> getPlayer6() {
		return player6;
	}
	
	public ArrayList<String> getDealer() {
		return dealer;
	}
}
