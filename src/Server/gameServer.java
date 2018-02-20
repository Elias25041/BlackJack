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
	}

	@Override
	public void processNewConnection(String pClientIP, int pClientPort) {
		if (bj.playerPlay() == true) {
			switch (accounts.size()) {
			case 0:
				Account accountOne = new Account(pClientIP, pClientPort, 1);
				bj.setPlayertoTable(new Player());
				accounts.add(accountOne);
				break;
			case 1:
				Account accountTwo = new Account(pClientIP, pClientPort, 2);
				bj.setPlayertoTable(new Player());
				accounts.add(accountTwo);
				break;
			case 2:
				Account accountThree = new Account(pClientIP, pClientPort, 3);
				bj.setPlayertoTable(new Player());
				accounts.add(accountThree);
				break;
			case 3:
				Account accountFour = new Account(pClientIP, pClientPort, 4);
				bj.setPlayertoTable(new Player());
				accounts.add(accountFour);
				break;
			case 4:
				Account accountFive = new Account(pClientIP, pClientPort, 5);
				bj.setPlayertoTable(new Player());
				accounts.add(accountFive);
				break;
			case 5:
				Account accountSix = new Account(pClientIP, pClientPort, 6);
				bj.setPlayertoTable(new Player());
				accounts.add(accountSix);
				break;
			default:
				this.send(pClientIP, pClientPort, "Kein Platz mehr");
			}
		} else {
			this.send(pClientIP, pClientPort, "Kein Platz mehr");
		}
	}

	@Override
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		String backMessage = Protokoll.SC_ERROR;
		if (this.IPAndPortToAccount(pClientIP, pClientPort).getPlayer() == bj.getPlayerTurn()) {
			String[] splitMessage = pMessage.split(Protokoll.TRENNER);
			String start = splitMessage[0];
			switch (start) {
			case Protokoll.CS_STARTGAME:
				backMessage = Protokoll.SC_GAMESTART;
				if (bj.startGame()) {
					for (int i = 0; i < accounts.size(); i++) {
						backMessage += Protokoll.TRENNER + bj.getPlayerCards(accounts.get(i).getPlayer())
								+ Protokoll.TRENNER + accounts.get(i).getPlayer();
					}
				}
				break;
			}
		}
		this.sendToAll(backMessage);

	}

	@Override
	public void processClosingConnection(String pClientIP, int pClientPort) {
		// TODO Auto-generated method stub

	}

	public Account IPAndPortToAccount(String pClientIP, int pClientPort) {
		Account tmp = null;
		for (int i = 0; i < accounts.size(); i++) {
			tmp = accounts.get(i);
			if ((tmp.getClientIP()).equals(pClientIP) || tmp.getClientPort() == pClientPort) {
				break;
			}
		}
		return tmp;
	}

}
