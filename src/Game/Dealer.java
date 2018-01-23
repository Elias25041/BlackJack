package Game;

import Cards.Card;
import Cards.CardStack;

public class Dealer {

	private int cardAmount;
	private int cardWorth;
	private CardStack cardStack;


	
	public Dealer(int amountDecks) {
		cardStack = new CardStack(amountDecks);
		
	}

	/**
	 * Dealer zieht Karte und gibt sie an pPlayer
	 * 
	 * @return
	 */
	public Card giveCard(Player pPlayer) {
		
		return null;
	}
	
	
	

	/**
	 * Der Wert aller Karten des Dealers wird zurückgegeben.
	 * 
	 * @return CardWorth
	 */
	public int getCardWorth() {
		return cardWorth;
	}
	
	
}