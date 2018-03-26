package Server;

import AbiturKlassen.Server;
import Game.BlackJack;
import Game.Player;
import Game.Table;
import Protokoll.Protokoll;

import java.util.ArrayList;

public class gameServer extends Server {

	private BlackJacks bjs;
	private ArrayList<Account> accounts;
	private int cardAmount;
	private int startCredit;

	public gameServer(int pPort, int pCardAmount, int pStartCredit) {
		super(pPort);
		cardAmount = pCardAmount;
		startCredit = pStartCredit;
		bjs = new BlackJacks(pCardAmount, pStartCredit);
		accounts = new ArrayList<Account>();
		System.out.println("Hallo ich bin der server auf Port: " + pPort + "; und CA = " + cardAmount);
	}

	public synchronized void processNewConnection(String pClientIP, int pClientPort) {
		int sessions = bjs.getBlackJacks().size();
		switch (bjs.getBlackJacks().get(sessions - 1).getPlayerCount()) {
		case 0:
			bjs.getBlackJacks().get(sessions - 1).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 1, sessions));
			System.out.println("Bin da");
			this.sendToAll("Nr. 1 ist da");
			break;
		case 1:
			bjs.getBlackJacks().get(sessions - 1).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 2, sessions));
			System.out.println("Bin da");
			this.sendToAll("Nr. 2 ist da");
			break;
		case 2:
			bjs.getBlackJacks().get(sessions - 1).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 3, sessions));
			System.out.println("Bin da");
			this.sendToAll("Nr. 3 ist da");
			break;
		case 3:
			bjs.getBlackJacks().get(sessions - 1).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 4, sessions));
			System.out.println("Bin da");
			this.sendToAll("Nr. 4 ist da");
			break;
		case 4:
			bjs.getBlackJacks().get(sessions - 1).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 5, sessions));
			System.out.println("Bin da");
			this.sendToAll("Nr. 5 ist da");
			break;
		case 5:
			bjs.getBlackJacks().get(sessions - 1).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 6, sessions));
			System.out.println("Bin da");
			this.sendToAll("Nr. 6 ist da");
			break;
		default:
			bjs.getBlackJacks().add(new BlackJack(cardAmount, startCredit));
			bjs.getBlackJacks().get(sessions).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 1,sessions + 1));
			this.send(pClientIP, pClientPort, "" + sessions);
		}
	}

	public synchronized void processMessage(String pClientIP, int pClientPort, String pMessage) {
		System.out.println("Ich habe erhalten: " + pMessage);
		String backMessage = Protokoll.SC_ERROR;
		int currentMove = 0;
		int currentBlackJack = this.IPAndPortToAccount(pClientIP, pClientPort).getBlackJacks() - 1;
		String[] splitMessage = pMessage.split(Protokoll.TRENNER);
		String start = splitMessage[0];
		System.out.println("Nichts");
		if ( bjs.getBlackJacks().get(currentBlackJack).getPlayerTurn() == 0) {
			System.out.println("PlayerTurn=0");
			switch (start) {
			case Protokoll.CS_STARTGAME:
				backMessage = Protokoll.SC_GAMESTART + Protokoll.TRENNER +  bjs.getBlackJacks().get(currentBlackJack).getStartCredit();
				System.out.println("GameStart");
				if ( bjs.getBlackJacks().get(currentBlackJack).startGame()) {
					System.out.println("Spielgestartet" + bjs.getBlackJacks().get(currentBlackJack).getPlayerCount());
					for (int i = 0; i < bjs.getBlackJacks().get(currentBlackJack).getPlayerCount(); i++) {
						backMessage += Protokoll.TRENNER +  bjs.getBlackJacks().get(currentBlackJack).getPlayerCards(accounts.get(i).getPlayer())
								+ accounts.get(i).getPlayer();
					}
				} else {
					backMessage = Protokoll.SC_ERROR;
				}
				break;
			}
		} else if (this.IPAndPortToAccount(pClientIP, pClientPort).getPlayer() ==  bjs.getBlackJacks().get(currentBlackJack).getPlayerTurn()) {
			currentMove = this.IPAndPortToAccount(pClientIP, pClientPort).getPlayer();
			backMessage += "" + currentMove;
			switch (start) {
			case Protokoll.CS_HIT:
				backMessage = Protokoll.SC_CARD + Protokoll.TRENNER +  bjs.getBlackJacks().get(currentBlackJack).cardInfo( bjs.getBlackJacks().get(currentBlackJack).cardToPlayer(currentMove));
				backMessage += currentMove;
				break;
			case Protokoll.CS_STAND:
				backMessage = Protokoll.SC_STAND + Protokoll.TRENNER + currentMove;
				backMessage +=  bjs.getBlackJacks().get(currentBlackJack).setPlayerTurn();
				if ( bjs.getBlackJacks().get(currentBlackJack).winLose(currentMove) == 1) {
					this.playerLeave(currentMove, currentBlackJack);
				}
			case Protokoll.CS_SPLIT:
				if ( bjs.getBlackJacks().get(currentBlackJack).playerSplit(currentMove)) {
					backMessage = Protokoll.SC_SPLIT;
				}
				break;
			}
		}
		System.out.println("Ich schicke: " + backMessage);

		this.sendToAll(backMessage);

	}
	
	public synchronized void processClosingConnection(String pClientIP, int pClientPort) {
		int player = this.IPAndPortToAccount(pClientIP, pClientPort).getPlayer();
		int currentBlacksJacks = this.IPAndPortToAccount(pClientIP, pClientPort).getBlackJacks();
		switch (player) {
		case 1:
			playerLeave(player, currentBlacksJacks);
			break;
		case 2:
			playerLeave(player, currentBlacksJacks);
			break;
		case 3:
			playerLeave(player, currentBlacksJacks);
			break;
		case 4:
			playerLeave(player, currentBlacksJacks);
			break;
		case 5:
			playerLeave(player, currentBlacksJacks);
			break;
		case 6:
			playerLeave(player, currentBlacksJacks);
			break;
		}
		this.sendToAll("Verbindung von Spieler " + player + " geschlossen");
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

	private void playerLeave(int pPlayer, int currentB) {
		for (int i = pPlayer; i < accounts.size(); i++) {
			if (i > 1) {
				accounts.get(i + 1).setPlayer(i);
				 bjs.getBlackJacks().get(currentB).forcePlace(i + 1, i);
			}
		}
		 bjs.getBlackJacks().get(currentB).leavePlace(accounts.size());
		accounts.remove(accounts.size() - 1);
	}
}
