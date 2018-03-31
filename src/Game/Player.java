package Game;

import Cards.Card;
import java.util.ArrayList;

/**
 * Der Spieler kann ueber Einsatz, weitere Karten ziehen oder aufh�ren
 * entscheiden und desweiteren verschiedene Aktionen im Spiel ausf�hren.
 * 
 * @author tamlyn.brandau
 *
 */
public class Player extends GameMechanic {
	// Guthaben des Spielers
	private int credit = 0;
	private boolean alreadyBet;
	private ArrayList<Card> splitCards;
	private boolean splited;
	private int bet;
	private int splitCardWorth;

	public Player() {
		super();
		splited = false;
		splitCards = new ArrayList<Card>();
		cards = new ArrayList<Card>();
		cardWorth = 0;
		alreadyBet = false;
	}

	/**
	 * Der Spieler teilt seine Hand, wenn alle Bedingungen erf�llt sind
	 * 
	 * @return boolean
	 */
	public boolean split() {
		if (cards.size() == 2 && (cards.get(0).getColour().equals(cards.get(1).getColour()) && credit > bet)) {
			if (cards.get(0).getColour().equals(cards.get(1).getColour())
				&& cards.get(0).getType().equals(cards.get(1).getType())) {
				splitCards = cards;
				splited = true;
				return true;
			}
		}
		return false;
	}

	/**
	 * Wenn der Spieler 2 Karten hat, kann er seinen Einsatz verdoppeln.
	 */
	public boolean doubleDown() {
		if(cards.size() == 2 && credit > bet) {
			return true;
		}
		return false;
	}

	/**
	 * fuegt Karte in cards hinzu
	 * 
	 * @param c
	 */
	public void hit(Card c) {
		cards.add(c);
		this.calculateWorth();
	}

	/**
	 * gibt das Guthaben des Spielers zur�ck
	 * 
	 * @return credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * der Spieler bekommt eine bestimmte Anzahl f�r den credit
	 * 
	 * @param i
	 */
	public void getPaid(int amount) {
		credit = credit + amount;
	}

	/**
	 * alreadyBet wird zur�ck gegeben
	 * 
	 * @return alreadyBet
	 */
	public boolean getAlreadyBet() {
		return alreadyBet;
	}

	/**
	 * alreadyBet wird ge�ndert
	 * 
	 * @param changeBet
	 */
	public void setAlreadyBet(boolean changeBet) {
		alreadyBet = changeBet;
	}
	
	/**
	 * der Player wird zur�ck gesetzt
	 */
	public void reset() {
		splited = false;
		cardWorth = 0;
		cards.clear();
		alreadyBet = false;
		splitCards.clear();
		splitCardWorth = 0;
		bet = 0;
	}
	
	/**
	 * der Credit wird ver�ndert
	 * 
	 * @param pCredit
	 */
	public void setCredit(int pCredit) {
		credit = pCredit;
	}
	
	/**
	 * splitCards wird zur�ck gegeben
	 * 
	 * @return splitCards
	 */
	public ArrayList<Card> getSplitCards() {
		return splitCards;
	}
	
	/**
	 * splited wird zur�ck gegeben
	 * 
	 * @return splited
	 */
	public boolean getSplitted() {
		return splited;
	}
	
	/**
	 * bet wird zur�ck gegeben
	 * 
	 * @return bet
	 */
	public int getBet() {
		return bet;
	}
	
	/**
	 * bet wird ver�ndert
	 * 
	 * @param pBet
	 */
	public void setBet(int pBet) {
		bet = pBet;
	}
	
	/**
	 * splitCardWorth wird errechnet
	 */
	public void calculateSplitCardWorth() {
		splitCardWorth = this.cardsWorth(splitCards);
	}
	
	/**
	 * splitCardWorth wird zur�ckgegeben
	 * 
	 * @return splitCardWorth
	 */
	public int getSplitCardWorth() {
		this.calculateSplitCardWorth();
		return splitCardWorth;
	}
}
