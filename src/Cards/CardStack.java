package Cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Der CardStack besteht aus mehreren CardDecks
 * 
 * @author tamlyn.brandau / erik.meier / elias.grage
 * @version 07DEZ2017
 */
public class CardStack {

	ArrayList<Card> stack;
	CardDeck deck;

	/**
	 * Es wird ein cardSatck inizialisiert, welches aus 1-6 Decks besteht;
	 */
	public CardStack(int amountDecks) {
		stack = new ArrayList<Card>();
		deck = new CardDeck();
		createCardStack(amountDecks);
		Collections.shuffle(stack);

	}

	/**
	 * Es wird ein CardStack erstellt, welches aus unterschiedlich vielen Decks
	 * besteht
	 * 
	 * @param i
	 *            Anzahl der Decks, die in dem CardStack zusammengef�gt werden.
	 */
	public boolean createCardStack(int i) {
		if (i > 6) {
			return false;
		} else {
			for (int j = 0; j < i; i--) {
				stack.addAll(deck.getDeck());
			}
			return true;
		}
	}

	/**
	 * Oberste Karte wird gezogen
	 * 
	 * @return
	 */
	public Card getTop() {
		Card tmp = stack.get(0);
		stack.remove(0);
		// System.out.println(""+tmp);
		return tmp;

	}

}
