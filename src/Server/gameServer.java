package Server;

import AbiturKlassen.Server;
import Game.BlackJack;
import Game.Player;
import Game.Table;
import Protokoll.Protokoll;

import java.util.ArrayList;

public class gameServer extends Server {

	private BlackJack bj;
	private ArrayList<Account> accounts;

	public gameServer(int pPort, int cardAmount) {
		super(pPort);
		bj = new BlackJack(cardAmount);
		accounts = new ArrayList<Account>();
		System.out.println("Hallo ich bin der server auf Port: " + pPort + "; und CA = " + cardAmount);
	}

	public void processNewConnection(String pClientIP, int pClientPort) {
		switch (accounts.size()) {
		case 0:
			Account accountOne = new Account(pClientIP, pClientPort, 1);
			bj.setPlayertoTable(new Player());
			accounts.add(accountOne);
			System.out.println("Bin da");
			this.sendToAll("Nr. 1 ist da");
			break;
		case 1:
			Account accountTwo = new Account(pClientIP, pClientPort, 2);
			bj.setPlayertoTable(new Player());
			accounts.add(accountTwo);
			System.out.println("Bin da");
			this.sendToAll("Nr. 2 ist da");
			break;
		case 2:
			Account accountThree = new Account(pClientIP, pClientPort, 3);
			bj.setPlayertoTable(new Player());
			accounts.add(accountThree);
			System.out.println("Bin da");
			this.sendToAll("Nr. 3 ist da");
			break;
		case 3:
			Account accountFour = new Account(pClientIP, pClientPort, 4);
			bj.setPlayertoTable(new Player());
			accounts.add(accountFour);
			System.out.println("Bin da");
			this.sendToAll("Nr. 4 ist da");
			break;
		case 4:
			Account accountFive = new Account(pClientIP, pClientPort, 5);
			bj.setPlayertoTable(new Player());
			accounts.add(accountFive);
			System.out.println("Bin da");
			this.sendToAll("Nr. 5 ist da");
			break;
		case 5:
			Account accountSix = new Account(pClientIP, pClientPort, 6);
			bj.setPlayertoTable(new Player());
			accounts.add(accountSix);
			System.out.println("Bin da");
			this.sendToAll("Nr. 6 ist da");
			break;
		default:
			this.send(pClientIP, pClientPort, "Kein Platz mehr");
		}
	}

	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		System.out.println("Ich habe erhalten: " + pMessage);
		String backMessage = Protokoll.SC_ERROR;
		int currentMove = 0;
		String[] splitMessage = pMessage.split(Protokoll.TRENNER);
		String start = splitMessage[0];
		System.out.println("Nichts");
		if (bj.getPlayerTurn() == 0) {
			System.out.println("PlayerTurn=0");
			switch (start) {
			case Protokoll.CS_STARTGAME:
				backMessage = Protokoll.SC_GAMESTART;
				System.out.println("GameStart");
				if (bj.startGame()) {
					System.out.println("Spielgestartet");
					for (int i = 0; i < accounts.size(); i++) {
						backMessage += Protokoll.TRENNER + bj.getPlayerCards(accounts.get(i).getPlayer())
								+ accounts.get(i).getPlayer();
					}
				} else {
					backMessage = Protokoll.SC_ERROR;
				}
				break;
			}
		} else if (this.IPAndPortToAccount(pClientIP, pClientPort).getPlayer() == bj.getPlayerTurn()) {
			currentMove = this.IPAndPortToAccount(pClientIP, pClientPort).getPlayer();
			backMessage += "" + currentMove;
			switch (start) {
			case Protokoll.CS_HIT:
				backMessage = Protokoll.SC_CARD + bj.cardInfo(bj.cardToPlayer(currentMove));
				if (bj.winLose(currentMove) == 0) {
					backMessage = Protokoll.SC_WIN;
					bj.reset();
				} else if (bj.winLose(currentMove) == 1) {
					backMessage = Protokoll.SC_LOSE;
					bj.reset();
				}
				backMessage += currentMove;
				break;
			case Protokoll.CS_STAND:
				backMessage = Protokoll.SC_STAND;
				bj.setPlayerTurn();
			case Protokoll.CS_SPLIT:
				if(bj.playerSplit(currentMove)) {
					backMessage = Protokoll.SC_SPLIT;
				}
				break;
			}
		}
		System.out.println("Ich schicke: " + backMessage);

		this.sendToAll(backMessage);

	}

	public void processClosingConnection(String pClientIP, int pClientPort) {
		int player = this.IPAndPortToAccount(pClientIP, pClientPort).getPlayer();
		switch (player) {
		case 1:
			for (int i = 1; i < accounts.size(); i++) {
				accounts.get(i).setPlayer(i - 1);
				bj.forcePlace(i, i - 1);
			}
		case 2:
			for (int i = 2; i < accounts.size(); i++) {
				accounts.get(i).setPlayer(i - 1);
				bj.forcePlace(i, i - 1);
			}
		case 3:
			for (int i = 3; i < accounts.size(); i++) {
				accounts.get(i).setPlayer(i - 1);
				bj.forcePlace(i, i - 1);
			}
		case 4:
			for (int i = 4; i < accounts.size(); i++) {
				accounts.get(i).setPlayer(i - 1);
				bj.forcePlace(i, i - 1);
			}
		case 5:
			for (int i = 5; i < accounts.size(); i++) {
				accounts.get(i).setPlayer(i - 1);
				bj.forcePlace(i, i - 1);
			}
		case 6:
			for (int i = 6; i < accounts.size(); i++) {
				accounts.get(i).setPlayer(i - 1);
				bj.forcePlace(i, i - 1);
			}
			this.send(pClientIP, pClientPort, "Verbindung geschlossen");
		}

	}

	private Account IPAndPortToAccount(String pClientIP, int pClientPort) {
		Account tmp = null;
		for (int i = 0; i < accounts.size(); i++) {
			tmp = accounts.get(i);
			if ((tmp.getClientIP()).equals(pClientIP) && tmp.getClientPort() == pClientPort) {
				break;
			}
		}
		return tmp;
	}
}
