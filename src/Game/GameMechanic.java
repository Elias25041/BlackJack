package Game;

import java.util.ArrayList;

import Cards.Card;

public class GameMechanic {
	
	private int cardAmount;
	private int cardWorth;
	private ArrayList<Card> cards;
	
	public GameMechanic() {
		cards = new ArrayList<Card>();
		cardWorth = 0;
	}

	/**
	 * Kartenwert wird berechnetn
	 */
	public void calculateWorth() {
		cardWorth = 0;
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
	 * 
	 * @return cardWorth
	 */
	public int getCardWorth() {
		return cardWorth;
	}
	
	public int getCardAmount() {
		return cardAmount;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public boolean checkWin() {
		calculateWorth();
		if (cardWorth == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkLose() {
		calculateWorth();
		if (cardWorth > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public void reset() {
		cardWorth = 0;
		cardAmount = 0;
		cards.clear();
	}
}
