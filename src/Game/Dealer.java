package Game;

import Cards.Card;
import Cards.CardStack;
import java.util.ArrayList;

public class Dealer extends GameMechanic {

	private CardStack cardStack;

	public Dealer(int amountDecks) {
		cardStack = new CardStack(amountDecks);
		cards = new ArrayList<Card>();
	}

	/**
	 * Dealer zieht Karte
	 * 
	 * @return tmp
	 */

	public Card getTop() {
		Card tmp = cardStack.getStack().get(0);
		cardStack.getStack().remove(0);
		// System.out.println(""+tmp);
		return tmp;
	}

	/**
	 * fügt Karte in cards hinzu
	 * 
	 * @param c
	 */
	public void getCard(Card c) {
		cards.add(c);
		this.calculateWorth();
	}

}