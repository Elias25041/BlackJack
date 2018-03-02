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
public class Player extends GameMechanic {
	// Guthaben des Spielers
	private int credit;
	// ob spieler inGame ist
	private boolean inGame;

	public Player() {
		super();
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
	public boolean split() {
		if (cardAmount == 2) {
			if (cards.get(0).getColour().equals(cards.get(1).getColour())
					&& cards.get(0).getType().equals(cards.get(1).getType())) {
				return true;
			}
		}
		return false;
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
		this.calculateWorth();
		cardAmount++;
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
	 * gibt die coins des Spielers wieder
	 * 
	 * @param coins
	 * @return coins
	 */
	public int setCoins(int coins) {
		return coins;
	}
}
