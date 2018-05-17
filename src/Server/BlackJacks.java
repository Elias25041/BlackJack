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
	
	/**
	 * diese Methode löscht alle Blakjackspiele, wo kein Spieler drin ist
	 * 
	 */
	public void deleteUnusedBlackJack() {
		for(int i = 0; i < blackJacks.size(); i++) {
			if(blackJacks.get(i).getPlayerCount() == 0) {
				blackJacks.remove(i);
				for(int j = i+1; j < blackJacks.size()-1; j++) {
					BlackJack tmp = blackJacks.get(j);
					blackJacks.remove(j-1);
					blackJacks.add(j-1, tmp);
				}
				blackJacks.add(blackJacks.size() - 1, blackJacks.get(blackJacks.size()));
				blackJacks.remove(blackJacks.size());
				i--;
			}
		}
	}
}
