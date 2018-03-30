package Game;

import Cards.Card;

/**
 * 
 * @author Elias
 * @version 15DEC2017
 */
public class BlackJack {

	private Bank bank;
	private Dealer dealer;
	private Table table;
	private int playerTurn;
	private int deckAmount;
	private int startCredit;
	private boolean inGame;
	private int playerNotBetted;

	/**
	 * Initialisiert alle globale Variablen
	 * 
	 */
	public BlackJack(int pDeckAmount, int pStartCredit) {
		startCredit = pStartCredit;
		deckAmount = pDeckAmount;
		dealer = new Dealer(pDeckAmount);
		table = new Table(dealer);
		bank = new Bank();
		inGame = false;
		playerNotBetted = 0;
		playerTurn = 0;
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
	 * gibt einem Spieler eine Karte, wenn der Spieler einen Split gemacht hat wird dem Spieler zwei Karten gegeben.
	 * jedem Stapel eine
	 * 
	 * @param pPlayer
	 * @return backMessage
	 */
	public String cardToPlayer(int pPlayer) {
		Card tmp = dealer.getTop();
		String backMessage = this.cardInfo(tmp);
		if (this.playerOnPlace(pPlayer) == true) {
			table.getPlace(pPlayer).hit(tmp);
			if (table.getPlace(pPlayer).getSplitted()) {
				Card sCard = dealer.getTop();
				table.getPlace(pPlayer).getSplitCards().add(dealer.getTop());
				backMessage += ":SP:" + this.cardInfo(sCard);
			}
			return backMessage;
		} else {
			return null;
		}
	}

	/**
	 * das Spiel wird gestartet, jeder Spieler und Dealer bekommen zwei Karten, playerNotBetted und inGame werden neu Initialisiert
	 * 
	 * @return boolean
	 */
	public boolean startGame() {
		if (canStartGame() == true) {
			playerNotBetted = table.getPlayerCount();
			inGame = true;
			for (int j = 0; j < 2; j++) {
				for (int i = 1; i <= table.getPlayerCount(); i++) {
					cardToPlayer(i);
					if (table.getPlace(i).getCredit() != startCredit) {
						table.getPlace(i).setCredit(startCredit);
					}
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

	/**
	 * die Karten des Spielers werden zurückgegeben
	 * 
	 * @param pPlayer
	 * @return cardAsString
	 */
	public String getPlayerCards(int pPlayer) {
		String cardsAsString = "";
		Player p = table.getPlace(pPlayer);
		for (int i = 0; i < p.getCards().size(); i++) {
			cardsAsString += cardInfo(p.getCards().get(i)) + ":";
		}
		return cardsAsString;
	}

	/**
	 * gibt den palyerTurn zurück
	 * 
	 * @return playerTurn
	 */
	public int getPlayerTurn() {
		return playerTurn;
	}

	/**
	 * der playerTurn wird verändert, wenn der playerTurn gleich der Anzahl der Spieler ist wird die Runde beendet.
	 * Ein Gewinner wird errechnet und es wird alles zurück gesetzt, damit eine nächste Runde gestartet werden kann
	 * 
	 * @return tmp
	 */
	public String setPlayerTurn() {
		String tmp = "";
		if (!(playerTurn == table.getPlayerCount())) {
			if (this.winLose(playerTurn) == 0) {
				tmp += winMessage(playerTurn, bank.pay());
			} else if (this.winLose(playerTurn) == 1) {
				tmp += ":L";
				playerTurn++;
				if (playerTurn == table.getPlayerCount()) {
					tmp = winMessage(playerTurn, bank.pay());
				}
			} else {
				playerTurn++;
			}
		} else {
			int maxPoints = 0;
			int maxPlayer = 0;
			tmp = this.endRound();
			if (!tmp.equals("DW")) {
				for (int i = 1; i <= table.getPlayerCount(); i++) {
					if (table.getPlace(i).getSplitted()) {
						int points = table.getPlace(i).getSplitCardWorth();
						if (points > maxPoints && points <= 21) {
							maxPoints = points;
							maxPlayer = i;
						} else if (points == maxPoints) {
							if (table.getPlace(maxPlayer).getSplitCards().size() > table.getPlace(i).getSplitCards().size()) {
								maxPoints = points;
								maxPlayer = i;
							}
						}
					}
					int points = table.getPlace(i).getCardWorth();
					if (points > maxPoints && points <= 21) {
						maxPoints = points;
						maxPlayer = i;
					} else if (points == maxPoints) {
						if (table.getPlace(maxPlayer).getCards().size() > table.getPlace(i).getCards().size()) {
							maxPoints = points;
							maxPlayer = i;
						}
					}
				}
				tmp = winMessage(maxPlayer, bank.pay());
			}
		}
		return tmp;
	}

	/**
	 * die Informationen der Karte werden zurück gegeben
	 * 
	 * @param c
	 * @return cardInfo
	 */
	public String cardInfo(Card c) {
		String cardInfo = "";
		cardInfo += c.getColour() + "_";
		cardInfo += c.getType();
		return cardInfo;
	}

	/**
	 * es wird geguckt ob ein Spieler genau 21 Punkte (gewonnen), mehr als 21 Punkte (verloren), 
	 * oder unter 21 Punkte (kann weiter spielen) hat
	 * 
	 * @param pPlayer
	 * @return 0,1,2
	 */
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

	/**
	 * das Spiel wird auf Anfang gesetzt
	 */
	public void reset() {
		inGame = false;
		playerTurn = 0;
		dealer.reset();
		table.setPlaceDealer(new Dealer(deckAmount));
		int j = table.getPlayerCount();
		for (int i = 1; i <= j; i++) {
			table.getPlace(i).reset();
		}
	}

	/**
	 * ein Spieler wird auf einen Platz gezwungen
	 * 
	 * @param pPlayer
	 * @param place
	 * @return boolean
	 */
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

	/**
	 * es wird geguckt ob ein Spieler am Platz sitzt
	 * 
	 * @param pPlayer
	 * @return boolean
	 */
	private boolean playerOnPlace(int pPlayer) {
		if (table.getPlace(pPlayer) == null) {
			return false;
		}
		return true;
	}

	/**
	 * Wenn alle Bedingungen stimmen wird die Hand des Spielers gesplited
	 * 
	 * @param pPlayer
	 * @return boolean
	 */
	public boolean playerSplit(int pPlayer) {
		if (this.playerOnPlace(pPlayer)) {
			Player p = table.getPlace(pPlayer);
			if (p.split()) {
				p.getPaid(-p.getBet());
				bank.addPot(p.getBet());
				return true;
			}
		}
		return false;
	}

	/**
	 * die Karten des Dealers werden zurück gegeben
	 * 
	 * @return cardAsString
	 */
	public String getDealerCards() {
		String cardsAsString = "";
		for (int i = 0; i < dealer.getCards().size(); i++) {
			cardsAsString += cardInfo(dealer.getCards().get(i)) + ":";
		}
		return cardsAsString;
	}

	/**
	 * ein Spieler verlässt den Platz
	 * 
	 * @param place
	 */
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
				return "DW";
			} else {
				Player p;
				for (int i = 0; i < table.getPlayerCount(); i++) {
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

	/**
	 * startCredit wird zurück gegeben
	 * 
	 * @return startCredit
	 */
	public int getStartCredit() {
		return startCredit;
	}

	/**
	 * playerCount wird zurückgegeben
	 * 
	 * @return playerCount
	 */
	public int getPlayerCount() {
		return table.getPlayerCount();
	}

	/**
	 * die Wette des Spielers wird verarbeitet
	 * 
	 * @param player
	 * @param bet
	 * @return boolean
	 */
	public boolean Bet(int player, int bet) {
		Player p = table.getPlace(player);
		if (p.getAlreadyBet()) {
			return false;
		} else if (p.getCredit() <= 0 || (p.getCredit() - bet) < 0) {
			return false;
		} else {
			p.setBet(bet);
			p.setAlreadyBet(true);
			p.getPaid(-bet);
			bank.addPot(bet);
			playerNotBetted--;
			if (playerNotBetted == 0) {
				playerTurn = 1;
			}
			return true;
		}
	}

	/**
	 * inGame wird zurück gegeben
	 * 
	 * @return inGame
	 */
	public boolean getInGame() {
		return inGame;
	}

	/**
	 * winMessage wird erstellt
	 * 
	 * @param player
	 * @param toPay
	 * @return winMessage
	 */
	private String winMessage(int player, int toPay) {
		table.getPaid(table.getPlace(player), toPay);
		String winMessage = "W:" + player + ":" + toPay;
		this.reset();
		winMessage = ":" + winMessage;
		return winMessage;
	}

	/**
	 * die Karten der gespliteten Hand wird erstellt
	 * 
	 * @param pPlayer
	 * @return cardAsString
	 */
	public String getSplitCards(int pPlayer) {
		String cardsAsString = "";
		Player p = table.getPlace(pPlayer);
		for (int i = 0; i < p.getSplitCards().size(); i++) {
			cardsAsString += cardInfo(p.getCards().get(i)) + ":";
		}
		return cardsAsString;
	}
}