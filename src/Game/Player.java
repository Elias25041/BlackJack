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
	private int credit = 50;
	// ob spieler inGame ist
	private boolean inGame;
	private boolean alreadyBet;

	public Player() {
		super();
		cards = new ArrayList<Card>();
		cardWorth = 0;
		alreadyBet = false;
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

	public void getPaid(int i) {
		credit = credit + i;
	}

	public boolean getAlreadyBet() {
		return alreadyBet;
	}

	public void setAlreadyBet(boolean changeBet) {
		alreadyBet = changeBet;
	}
	
	public void reset() {
		cardWorth = 0;
		cardAmount = 0;
		cards.clear();
		alreadyBet = false;
	}
}
