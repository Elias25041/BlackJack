package Game;

import Cards.Card;
import Cards.CardStack;
import java.util.ArrayList;
import java.util.Collections;

public class Dealer {

	private int cardAmount;
	private int cardWorth;
	private CardStack cardStack;
	private ArrayList<Card> cards;

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
	 * Der Wert aller Karten des Dealers wird zur√ºckgegeben.
	 * 
	 * @return CardWorth
	 */
	public int getCardWorth() {
		return cardWorth;
	}

	/**
	 * Kartenwert wird berechnetn
	 */
	public void calculateWorth() {
		for (int i = 0; i < cards.size(); i++) {
			Card c = cards.get(i);
			if (c.getType().equals("Kˆnig") || c.getType().equals("Dame") || c.getType().equals("Bube")
					|| c.getType().equals("Zehn")) {
				cardWorth = cardWorth + 10;
			} else if (c.getType().equals("Zwei")) {
				cardWorth = cardWorth + 2;
			} else if (c.getType().equals("Drei")) {
				cardWorth = cardWorth + 3;
			} else if (c.getType().equals("Vier")) {
				cardWorth = cardWorth + 4;
			} else if (c.getType().equals("F¸nf")) {
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
				if (cardAmount + 11 <= 21) {
					cardAmount = cardAmount + 11;
				} else {
					cardAmount = cardAmount + 1;
				}
			}
		}
	}

	/**
	 * f¸gt Karte in cars hinzu
	 * 
	 * @param c
	 */
	public void getCard(Card c) {
		cards.add(c);
	}

}