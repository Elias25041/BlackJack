package Game;

/**
 * 
 * @author Elias
 * @version 15DEC2017
 */
public class BlackJack {

	private Bank bank;
	private Dealer dealer;
	private Table table;

	/**
	 * Erstellt eine Bank, einen Dealer, einen Tisch
	 */
	public BlackJack() {

	}
	
	public static void main(String [] args) {
		
	}

	/**
	 * Der Spieler wird an den Tisch gesetzt
	 */
	public boolean setPlayertoTable(Player p) {
		switch(table.getPlayerCount()) {
		case 0:
			table.setPlaceOne(p);
			return true;
		case 1:
			table.setPlaceTwo(p);
			return true;
		case 2:
			table.setPlaceThree(p);
			return true;
		case 3:
			table.setPlaceFour(p);
			return true;
		case 4:
			table.setPlaceFive(p);
			return true;
		case 5:
			table.setPlaceSix(p);
			return true;
		default:
			return false;
		}
	}
	
	public void cardToPlayer(Player pPlayer) {
		//Test2
	}
	
	
	

}
