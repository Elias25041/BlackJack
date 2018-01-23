package Game;

import Cards.Card;
import java.util.ArrayList;


/**
 * Der Spieler kann über Einsatz, weitere Karten ziehen oder aufhören
 * entscheiden und desweiteren verschiedene Aktionen im Spiel ausführen.
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
	ArrayList<Card> cards;
	
	public Player() {
		cards = new ArrayList<Card>();
	}

	/**
	 * Der Spieler beendet seinen Zug
	 */
	public void stand() {

	}

	/**
	 * Der Spieler kann seine Hand teilen, wenn die ersten beiden Karten gleichwertig sind. 
	 */
	public void split() {

	}

	/**
	 * Wenn der Spieler 2 Karten hat, kann er seinen Einsatz verdoppeln.
	 */
	public void doubleDown() {

	}

	/**
	 * Der Spieler fragt an, ob er eine Karte ziehe
	 */ 
	public void hit() {

	}
	
	public void pullCard(Card c){		
	}

	public int getCardWorth() {
		return cardWorth;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public int setCoins(int coins) {
		return coins;
	}

}
