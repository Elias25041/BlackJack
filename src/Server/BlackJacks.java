package Server;

import Game.BlackJack;
import java.util.ArrayList;

public class BlackJacks {
	private ArrayList<BlackJack> blackJacks;

	public BlackJacks(int cardAmount, int startCredit) {
		blackJacks = new ArrayList<BlackJack>();
		blackJacks.add(new BlackJack(cardAmount, startCredit));
	}
	
	/**
	 * blackjacks wird zurückgegeben
	 * 
	 * @return blackjacks
	 */
	public ArrayList<BlackJack> getBlackJacks() {
		return blackJacks;
	}
}
