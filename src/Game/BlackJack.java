package Game;

import Cards.Card;

/**
 * 
 * @author Elias
 * @version 15DEC2017
 */
public class BlackJack {
	// test
	private Bank bank;
	private Dealer dealer;
	private Table table;
	private int playerTurn = 0;

	/**
	 * Erstellt eine Bank, einen Dealer, einen Tisch
	 * 
	 */
	public BlackJack(int cardAmount) {
		dealer = new Dealer(cardAmount);
		table = new Table(dealer);
		bank = new Bank();
	}

	/**
	 * Der Spieler wird an den Tisch gesetzt
	 */
	public boolean setPlayertoTable(Player p) {
		switch (table.getPlayerCount()) {
		case 0:
			table.setPlaceOne(p);
			return true;
		case 1:
			table.setPlaceTwo(p);
			return true;
		case 2:
			table.setPlaceThree(p);
			return true;
		case 3:
			table.setPlaceFour(p);
			return true;
		case 4:
			table.setPlaceFive(p);
			return true;
		case 5:
			table.setPlaceSix(p);
			return true;
		default:
			return false;
		}
	}

	/**
	 * gibt einem Spieler eine Karte
	 * 
	 * @param pPlayer
	 * @param s
	 */
	public Card cardToPlayer(int pPlayer) {
		Card tmp = dealer.getTop();
		if(this.ableCard(pPlayer) == true) {
			table.getPlace(pPlayer).hit(tmp);
			return tmp;
		} else {
			return null;
		}
	}

	/**
	 * das Spiel wird gestartet, jeder Spieler und Dealer bekommen zwei Karten
	 * 
	 * @return boolean
	 */
	public boolean startGame() {
		if (canStartGame() == true) {
			playerTurn = 1;
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i <= table.getPlayerCount(); i++) {
					cardToPlayer(i);
				}
				dealer.getCard(dealer.getTop());
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * es wird geguckt ob das Spiel gestartet wird
	 * 
	 * @return boolean
	 */
	public boolean canStartGame() {
		if (table.getPlayerCount() >= 2 && table.getPlayerCount() <= 6) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Startet eine Runde
	 */
	public void startRound() {
		playerTurn = 1;
	}

	/**
	 * guckt ob ein Spieler mitspielen kann
	 * 
	 * @return boolean
	 */
	public boolean playerPlay() {
		if (table.getPlayerCount() < 6) {
			return true;
		} else {
			return false;
		}
	}

	public String getPlayerCards(int pPlayer) {
		String cardsAsString = "";
		Player p = table.getPlace(pPlayer);
		for (int i = 0; i < p.getCardAmount(); i++) {
			cardsAsString += cardInfo(p.getCards().get(i)) + ":";
		}
		return cardsAsString;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn() {
		if (playerTurn == table.getPlayerCount()) {
			playerTurn = 1;
		} else {
			playerTurn += 1;
		}
	}

	public String cardInfo(Card c) {
		String tmp = "";
		tmp += c.getColour() + "_";
		tmp += c.getType();
		return tmp;
	}

	public int winLose(int pPlayer) {
		Player tmp = table.getPlace(pPlayer);
		if (tmp.checkWin()) {
			return 0;
		} else if (tmp.checkLose()) {
			return 1;
		} else {
			return 2;
		}
	}

	public void reset() {
		playerTurn = 0;
		int j = table.getPlayerCount();
		for(int i = 1; i <= j; i++) {
			table.getPlace(i).reset();
		}
	}

	public boolean forcePlace(int pPlayer, int place) {
			switch (place) {
			case 1:
				table.setPlaceOne(table.getPlace(pPlayer));
				return true;
			case 2:
				table.setPlaceTwo(table.getPlace(pPlayer));
				return true;
			case 3:
				table.setPlaceThree(table.getPlace(pPlayer));
				return true;
			case 4:
				table.setPlaceFour(table.getPlace(pPlayer));
				return true;
			case 5:
				table.setPlaceFive(table.getPlace(pPlayer));
				return true;
			case 6:
				table.setPlaceSix(table.getPlace(pPlayer));
				return true;
			default:
				return false;
			}
	}
	
	public boolean ableCard(int pPlayer) {
		if(table.getPlace(pPlayer) == null) {
			return false;
		}
		return true;
	}
}
