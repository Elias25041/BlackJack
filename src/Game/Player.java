package Game;

import Cards.Card;
import java.util.ArrayList;

/**
 * Der Spieler kann �ber Einsatz, weitere Karten ziehen oder aufh�ren
 * entscheiden und desweiteren verschiedene Aktionen im Spiel ausf�hren.
 * 
 * @author tamlyn.brandau
 *
 */
public class Player {
	// Kartenwert
	private int cardWorth;
	// Guthaben des Spielers
	private int credit;
	// ob spieler inGame ist
	private boolean inGame;
	// anzahl der Karten
	private int cardAmount;
	private ArrayList<Card> cards;

	public Player() {
		cards = new ArrayList<Card>();
		cardWorth = 0;
	}

	/**
	 * Der Spieler beendet seinen Zug
	 */
	public void stand() {

	}

	/**
	 * Der Spieler kann seine Hand teilen, wenn die ersten beiden Karten
	 * gleichwertig sind.
	 */
	public void split() {

	}

	/**
	 * Wenn der Spieler 2 Karten hat, kann er seinen Einsatz verdoppeln.
	 */
	public void doubleDown() {

	}

	/**
	 * fuegt Karte in cards hinzu
	 * 
	 * @param c
	 */
	public void hit(Card c) {
		cards.add(c);
	}
	/**
	 * Kartenwert wird berechnetn
	 */
	public void calculateWorth() {
		for (int i = 0; i < cards.size(); i++) {
			Card c = cards.get(i);
			if (c.getType().equals("K�nig") || c.getType().equals("Dame") || c.getType().equals("Bube")
					|| c.getType().equals("Zehn")) {
				cardWorth = cardWorth + 10;
			} else if (c.getType().equals("Zwei")) {
				cardWorth = cardWorth + 2;
			} else if (c.getType().equals("Drei")) {
				cardWorth = cardWorth + 3;
			} else if (c.getType().equals("Vier")) {
				cardWorth = cardWorth + 4;
			} else if (c.getType().equals("F�nf")) {
				cardWorth = cardWorth + 5;
			} else if (c.getType().equals("Sechs")) {
				cardWorth = cardWorth + 6;
			} else if (c.getType().equals("Sieben")) {
				cardWorth = cardWorth + 7;
			} else if (c.getType().equals("Acht")) {
				cardWorth = cardWorth + 8;
			} else if (c.getType().equals("Neun")) {
				cardWorth = cardWorth + 9;
			} else if (c.getType().equals("Ass")) {
				if (cardWorth + 11 <= 21) {
					cardWorth = cardWorth + 11;
				} else {
					cardWorth = cardWorth + 1;
				}
			}
		}
	}

	/**
	 * Der Kartenwert wird zur�ckgegeben
	 * @return cardWorth
	 */
	public int getCardWorth() {
		return cardWorth;
	}

	/**
	 * gibt das Guthaben des Spielers zur�ck
	 * @return credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * gibt die coins des Spielers wieder
	 * @param coins
	 * @return coins
	 */
	public int setCoins(int coins) {
		return coins;
	}
	
	public int getCardAmount() {
		return cardAmount;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
}
