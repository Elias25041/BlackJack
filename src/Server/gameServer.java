package Server;

import AbiturKlassen.Server;
import Bot.Bot_Client;
import Game.BlackJack;
import Game.Player;
import Protokoll.Protokoll;

import java.util.ArrayList;

public class gameServer extends Server {

	private BlackJacks bjs;
	private ArrayList<Account> accounts;
	private int cardAmount;
	private int startCredit;
	private Bot_Client bot;

	public gameServer(int pPort, int pCardAmount, int pStartCredit) {
		super(pPort);
		cardAmount = pCardAmount;
		startCredit = pStartCredit;
		bjs = new BlackJacks(pCardAmount, pStartCredit);
		accounts = new ArrayList<Account>();
		bot = new Bot_Client("localhost", pPort);
		System.out.println("Hallo ich bin der server auf Port: " + pPort + "; und CA = " + cardAmount);
	}

	/**
	 * produziert eine neue Verbindung
	 */
	public synchronized void processNewConnection(String pClientIP, int pClientPort) {
		int sessions = bjs.getBlackJacks().size() - 1;
		System.out.println("Sessions:" + sessions);
		switch (bjs.getBlackJacks().get(sessions).getPlayerCount()) {
		case 0:
			bjs.getBlackJacks().get(sessions).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 1, sessions));
			System.out.println("Bin da 1");
			this.send(pClientIP, pClientPort, "" + 1);
			break;
		case 1:
			bjs.getBlackJacks().get(sessions).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 2, sessions));
			System.out.println("Bin da 2");
			this.send(pClientIP, pClientPort, "" + 2);
			break;
		case 2:
			bjs.getBlackJacks().get(sessions).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 3, sessions));
			System.out.println("Bin da 3");
			this.send(pClientIP, pClientPort, "" + 3);
			break;
		case 3:
			bjs.getBlackJacks().get(sessions).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 4, sessions));
			System.out.println("Bin da 4");
			this.send(pClientIP, pClientPort, "" + 4);
			break;
		case 4:
			bjs.getBlackJacks().get(sessions).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 5, sessions));
			System.out.println("Bin da 5");
			this.send(pClientIP, pClientPort, "" + 5);
			break;
		case 5:
			bjs.getBlackJacks().get(sessions).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 6, sessions));
			System.out.println("Bin da 6");
			this.send(pClientIP, pClientPort, "" + 6);
			break;
		default:
			bjs.getBlackJacks().add(new BlackJack(cardAmount, startCredit));
			bjs.getBlackJacks().get(sessions + 1).setPlayertoTable(new Player());
			accounts.add(new Account(pClientIP, pClientPort, 1, sessions + 1));
			this.send(pClientIP, pClientPort, "" + 1);
		}
	}

	/**
	 * produziert eine neue Mitteilung für den Client
	 */
	public synchronized void processMessage(String pClientIP, int pClientPort, String pMessage) {
		System.out.println("Ich habe erhalten: " + pMessage);
		String backMessage = Protokoll.SC_ERROR;
		int currentMove = this.IPAndPortToAccount(pClientIP, pClientPort).getPlayer();
		System.out.println("currentMove: " + currentMove);
		int currentBlackJack = this.IPAndPortToAccount(pClientIP, pClientPort).getBlackJacks();
		System.out.println("currentBlackJack: " + currentBlackJack);
		String[] splitMessage = pMessage.split(Protokoll.TRENNER);
		String start = splitMessage[0];
		System.out.println("playerTurn:" + bjs.getBlackJacks().get(currentBlackJack).getPlayerTurn());
		if (bjs.getBlackJacks().get(currentBlackJack).getPlayerTurn() == 0) {
			switch (start) {
			case Protokoll.CS_STARTGAME:
				backMessage = Protokoll.SC_GAMESTART + Protokoll.TRENNER
						+ bjs.getBlackJacks().get(currentBlackJack).getStartCredit();
				System.out.println("GameStart");
				if (bjs.getBlackJacks().get(currentBlackJack).startGame()) {
					System.out.println("Spielgestartet" + bjs.getBlackJacks().get(currentBlackJack).getPlayerCount());
					for (int i = 0; i < bjs.getBlackJacks().get(currentBlackJack).getPlayerCount(); i++) {
						backMessage += Protokoll.TRENNER
								+ bjs.getBlackJacks().get(currentBlackJack).getPlayerCards(accounts.get(i).getPlayer())
								+ accounts.get(i).getPlayer();
					}
					backMessage += ":" + bjs.getBlackJacks().get(currentBlackJack).getDealerCard(2);
				} else {
					backMessage = Protokoll.SC_ERROR;
				}
				break;
			case Protokoll.CS_PAY:
				if (bjs.getBlackJacks().get(currentBlackJack).getInGame()) {
					try {
						if (bjs.getBlackJacks().get(currentBlackJack).Bet(currentMove,
								Integer.parseInt(splitMessage[1]))) {
							backMessage = Protokoll.SC_PAY + ":" + currentMove;
						} else {
							backMessage = Protokoll.CONVERT + Protokoll.SC_PAY + ":" + currentMove;
						}
					} catch (Exception e) {
						backMessage = Protokoll.SC_ERROR;
					}
				}
				break;
			}
		} else if (currentMove == bjs.getBlackJacks().get(currentBlackJack).getPlayerTurn()) {
			backMessage += "" + currentMove;
			switch (start) {
			case Protokoll.CS_HIT:
				backMessage = Protokoll.SC_CARD + Protokoll.TRENNER
						+ bjs.getBlackJacks().get(currentBlackJack).cardToPlayer(currentMove);
				backMessage += Protokoll.TRENNER + currentMove;
				break;
			case Protokoll.CS_STAND:
				backMessage = Protokoll.SC_STAND + Protokoll.TRENNER + currentMove;
				backMessage += bjs.getBlackJacks().get(currentBlackJack).setPlayerTurn();
			case Protokoll.CS_SPLIT:
				if (bjs.getBlackJacks().get(currentBlackJack).playerSplit(currentMove)) {
					backMessage = Protokoll.SC_SPLIT;
				}
				break;
			case Protokoll.CS_DOUBLEDOWN:
				if (bjs.getBlackJacks().get(currentBlackJack).playerDoubleDown(currentMove)) {
					backMessage = Protokoll.SC_DOUBLEDOWN + Protokoll.TRENNER + currentMove;
				}
			}
		}
		System.out.println("Ich schicke: " + backMessage);

		this.sendToSession(currentBlackJack, backMessage);

	}

	/**
	 * schließt die verbindung zu Client
	 */
	public synchronized void processClosingConnection(String pClientIP, int pClientPort) {
		Account account = this.IPAndPortToAccount(pClientIP, pClientPort);
		int currentBlacksJacks = this.IPAndPortToAccount(pClientIP, pClientPort).getBlackJacks();
		switch (account.getPlayer()) {
		case 1:
			playerLeave(account, currentBlacksJacks);
			break;
		case 2:
			playerLeave(account, currentBlacksJacks);
			break;
		case 3:
			playerLeave(account, currentBlacksJacks);
			break;
		case 4:
			playerLeave(account, currentBlacksJacks);
			break;
		case 5:
			playerLeave(account, currentBlacksJacks);
			break;
		case 6:
			playerLeave(account, currentBlacksJacks);
			break;
		}
		this.sendToAll("Verbindung von Spieler " + account.getPlayer() + " geschlossen");
	}

	/**
	 * ordnet IP und Port zu einem Client zu
	 * 
	 * @param pClientIP
	 * @param pClientPort
	 * @return account
	 */
	private Account IPAndPortToAccount(String pClientIP, int pClientPort) {
		Account account = null;
		for (int i = 0; i < accounts.size(); i++) {
			account = accounts.get(i);
			if ((account.getClientIP()).equals(pClientIP) && account.getClientPort() == pClientPort) {
				break;
			}
		}
		return account;
	}

	/**
	 * ordnet spieler und Spiele zu einem Account zu
	 * 
	 * @param blackJack
	 * @param player
	 * @return Account || null
	 */
	private Account sessionAndPlayerToAccount(int blackJack, int player) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getBlackJacks() == blackJack && accounts.get(i).getPlayer() == player) {
				return accounts.get(i);
			}
		}
		return null;
	}

	/**
	 * Spieler verlässt das Spiel
	 * 
	 * @param pAccount
	 * @param currentB
	 */
	private void playerLeave(Account pAccount, int currentB) {
		for (int i = pAccount.getPlayer(); i < bjs.getBlackJacks().get(currentB).getPlayerCount(); i++) {
			if (i > 1) {
				bjs.getBlackJacks().get(currentB).forcePlace(i + 1, i);
			}
		}
		bjs.getBlackJacks().get(currentB).leavePlace(bjs.getBlackJacks().get(currentB).getPlayerCount());
		accounts.remove(pAccount);
	}

	/**
	 * sendet eine Message zu einem Spiel
	 * 
	 * @param blackJack
	 * @param message
	 */
	private void sendToSession(int blackJack, String message) {
		BlackJack bj = bjs.getBlackJacks().get(blackJack);
		for (int i = 0; i < bj.getPlayerCount(); i++) {
			Account acc = this.sessionAndPlayerToAccount(blackJack, i + 1);
			this.send(acc.getClientIP(), acc.getClientPort(), message);
		}
	}
}
