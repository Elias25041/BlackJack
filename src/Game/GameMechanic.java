package Game;

import java.util.ArrayList;

import Cards.Card;

public class GameMechanic {

	protected int cardWorth;
	protected ArrayList<Card> cards;

	public GameMechanic() {
		cards = new ArrayList<Card>();
		cardWorth = 0;
	}

	/**
	 * Kartenwert wird berechnetn
	 */
	public void calculateWorth() {
		cardWorth = this.cardsWorth(cards);
	}

	/**
	 * Der Kartenwert wird zurï¿½ckgegeben
	 * 
	 * @return cardWorth
	 */
	public int getCardWorth() {
		this.calculateWorth();
		return cardWorth;
	}

	/**
	 * cards wird zurück gegeben
	 * 
	 * @return cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}

	/**
	 * es wird gegeuckt ob die Person gewonnen hat
	 * 
	 * @return boolean
	 */
	public boolean checkWin() {
		this.calculateWorth();
		if (cardWorth == 21) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * es wird geguckt ob die Person verloren hat
	 * 
	 * @return boolean
	 */
	public boolean checkLose() {
		this.calculateWorth();
		if (cardWorth > 21) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Person wird zurück gesetzt
	 */
	public void reset() {
		cardWorth = 0;
		cards.clear();
	}
	
	/**
	 * der Kartenwert einer Arraylist vom typ Card wird errechnet
	 * 
	 * @param a
	 * @return worth
	 */
	public int cardsWorth(ArrayList<Card> a) {
		int worth = 0;
		for (int i = 0; i < a.size(); i++) {
			Card c = a.get(i);
			if (c.getType().equals("Koenig") || c.getType().equals("Dame") || c.getType().equals("Bube")
					|| c.getType().equals("Zehn")) {
				worth = worth + 10;
			} else if (c.getType().equals("Zwei")) {
				worth = worth + 2;
			} else if (c.getType().equals("Drei")) {
				worth = worth + 3;
			} else if (c.getType().equals("Vier")) {
				worth = worth + 4;
			} else if (c.getType().equals("Fuenf")) {
				worth = worth + 5;
			} else if (c.getType().equals("Sechs")) {
				worth = worth + 6;
			} else if (c.getType().equals("Sieben")) {
				worth = worth + 7;
			} else if (c.getType().equals("Acht")) {
				worth = worth + 8;
			} else if (c.getType().equals("Neun")) {
				worth = worth + 9;
			} else if (c.getType().equals("Ass")) {
				if (worth + 11 <= 21) {
					worth = worth + 11;
				} else {
					worth = worth + 1;
				}
			}
		}
		
		return worth;
	}
}
