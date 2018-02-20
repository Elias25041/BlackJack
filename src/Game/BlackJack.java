package Game;

import Cards.Card;

/**
 * 
 * @author Elias
 * @version 15DEC2017
 */
public class BlackJack {
//test
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

	public static void main(String[] args) {
		// BlackJack b = new BlackJack(1);
		// Player p = new Player();
		// p.getCard(b.dealer.getTop());
		// b.startGame();
		// b.setPlayertoTable(p);
		// p.calculateWorth();
		// System.out.println(b.table.getPlace(1).getCardWorth());
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
	public void cardToPlayer(Player pPlayer, Card s) {
		pPlayer.hit(s);
	}

	/**
	 * das Spiel wird gestartet, jeder Spieler und Dealer bekommen zwei Karten
	 * 
	 * @return boolean
	 */
	public boolean startGame() {
		if (canStartGame() == true) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < table.getPlayerCount(); i++) {
					cardToPlayer(table.getPlace(i), dealer.getTop());
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
	 * @return boolean
	 */
	public boolean canStartGame() {
		if(table.getPlayerCount() >= 2 || table.getPlayerCount() <= 6) {
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
		for(int i = 0; i < p.getCardAmount(); i++) {
			cardsAsString += p.getCards().get(i).getColour() + "_";
			cardsAsString += p.getCards().get(i).getType();
		}
		return cardsAsString;
	}
	
	public int getPlayerTurn() {
		return playerTurn;
	}
}
