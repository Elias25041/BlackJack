package Server;

import Game.BlackJack;
import Game.Player;
import Game.Table;
import java.util.ArrayList;

import Cards.Card;

public class BlackJacks {
	private ArrayList<BlackJack> blackJacks;

	public BlackJacks(int cardAmount, int startCredit) {
		blackJacks = new ArrayList<BlackJack>();
		blackJacks.add(new BlackJack(cardAmount, startCredit));
	}
	
	public ArrayList<BlackJack> getBlackJacks() {
		return blackJacks;
	}
}
