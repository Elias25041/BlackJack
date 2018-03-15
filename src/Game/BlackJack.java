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
			table.addPlayerCount(1);
			return true;
		case 1:
			table.setPlaceTwo(p);
			table.addPlayerCount(1);
			return true;
		case 2:
			table.setPlaceThree(p);
			table.addPlayerCount(1);
			return true;
		case 3:
			table.setPlaceFour(p);
			table.addPlayerCount(1);
			return true;
		case 4:
			table.setPlaceFive(p);
			table.addPlayerCount(1);
			return true;
		case 5:
			table.setPlaceSix(p);
			table.addPlayerCount(1);
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
		if (this.playerOnPlace(pPlayer) == true) {
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
	private boolean canStartGame() {
		if (table.getPlayerCount() >= 2 && table.getPlayerCount() <= 6) {
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

	public String setPlayerTurn() {
		String tmp = "";
		if (playerTurn == table.getPlayerCount()) {
			int maxPoints = 0;
			int maxPlayer = 0;
			tmp = this.endRound();
			if (!tmp.equals("dealerWin")) {
				for (int i = 1; i <= table.getPlayerCount(); i++) {
					int points = table.getPlayer(i).getCardWorth();
					if (points > maxPoints) {
						maxPoints = points;
						maxPlayer = i;
					} else if (points == maxPoints) {
						if (table.getPlace(maxPlayer).getCardAmount() > table.getPlace(i).getCardAmount()) {
							maxPoints = points;
							maxPlayer = i;
						}
					}
				}
				int toPay = bank.pay();
				table.getPaid(table.getPlace(maxPlayer), toPay);
				tmp = maxPlayer + "_win_" + maxPoints;
				this.reset();
			}
		} else {
			if (this.winLose(playerTurn) == 0) {
				tmp = playerTurn + "_W";
				this.reset();
			} else if (this.winLose(playerTurn) == 1) {
				tmp = playerTurn + "_L";
				this.reset();
			} else {
				playerTurn += 1;
			}
		}
		return tmp;
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
			System.out.println("gewonnen");
			return 0;
		} else if (tmp.checkLose()) {
			System.out.println("verloren");
			return 1;
		} else {
			return 2;
		}
	}

	public void reset() {
		playerTurn = 0;
		dealer.reset();
		int j = table.getPlayerCount();
		for (int i = 1; i <= j; i++) {
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

	private boolean playerOnPlace(int pPlayer) {
		if (table.getPlace(pPlayer) == null) {
			return false;
		}
		return true;
	}

	public boolean playerSplit(int pPlayer) {
		if (this.playerOnPlace(pPlayer)) {
			Player p = table.getPlace(pPlayer);
			if (p.split()) {
				return true;
			}
		}
		return false;
	}

	public String getDealerCards() {
		String cardsAsString = "";
		for (int i = 0; i < dealer.getCardAmount(); i++) {
			cardsAsString += cardInfo(dealer.getCards().get(i)) + ":";
		}
		return cardsAsString;
	}

	public void leavePlace(int place) {
		switch (place) {
		case 1:
			table.setPlaceOne(null);
			table.addPlayerCount(-1);
			break;
		case 2:
			table.setPlaceTwo(null);
			table.addPlayerCount(-1);
			break;
		case 3:
			table.setPlaceThree(null);
			table.addPlayerCount(-1);
			break;
		case 4:
			table.setPlaceFour(null);
			table.addPlayerCount(-1);
			break;
		case 5:
			table.setPlaceFive(null);
			table.addPlayerCount(-1);
			break;
		case 6:
			table.setPlaceSix(null);
			table.addPlayerCount(-1);
			break;
		}
	}

	/**
	 * Am Ende der Runde wird der Gewinner ermittelt und dieser kriegt den Inhalt
	 * des Pots gutgeschrieben
	 * 
	 * @return
	 */
	public String endRound() {
		playerTurn = 1;
		if (dealer.getCardWorth() < 16) {
			dealer.getCard(dealer.getTop());
			this.getDealerCards();
			if (dealer.checkWin()) {
				bank.getPaid();
				this.reset();
				return "dealerWin";
			} else {
				Player p;
				for (int i = 0; i < 5; i++) {
					p = table.getPlayer(i);
					if (p.checkWin()) {
						table.getPaid(p, bank.pay());
						break;
					}
				}
			}
		}
		return "";
	}
}
